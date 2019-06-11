package in.srisrisri.psc.question;

import in.srisrisri.psc.responses.DeleteResponse;
import in.srisrisri.psc.utils.*;
import in.srisrisri.psc.FileStorage.FileStorageService;
import in.srisrisri.psc.FileStorage.UploadFileResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/psc/api/question")
public class QuestionResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private QuestionRepo questionRepo;

    QuestionResource(QuestionRepo questionRepo, FileStorageService fileStorageService_) {
        this.questionRepo = questionRepo;
        this.fileStorageService = fileStorageService_;
    }

 

    String label = "question";

    @GetMapping("port")
    @ResponseBody
    public List<QuestionEntity> port() {
        logger.warn("REST getItems() , {} ", new Object[]{label});

        List<QuestionEntity> list = questionRepo.findAll();
        for (QuestionEntity entity : list) {
            if (entity.getFixedId() != 0) {
                entity.setId(entity.getFixedId());
                questionRepo.save(entity);
            }
        }
        return list;
    }

    @GetMapping("")
    @ResponseBody
    public List<QuestionEntity> all() {
        logger.warn("REST getItems() , {} ", new Object[]{label});

        List<QuestionEntity> list = questionRepo.findAll();

        return list;
    }

    @GetMapping("pageNumber/{id}")
    @ResponseBody
    public Page<QuestionEntity> allPageNumber(@PathVariable("id") int id) {
        logger.warn("REST getItems() , {} ", new Object[]{label});
        Pageable pageable = PageRequest.of(id - 1, 10, Sort.by("id").ascending());
        Page<QuestionEntity> list = questionRepo.findAll(pageable);

        return list;
    }

    @GetMapping("{id}")
    @ResponseBody
    public Optional<QuestionEntity> id(@PathVariable("id") Long id) {
        logger.warn("id {} No {}", new Object[]{label, id});
        Optional<QuestionEntity> item = questionRepo.findById(id);
        item.get().setMyEditor(readFile(item.get().getFilepath()));
        //  item.get().setCreationTime(new Date());
        return item;
    }

    // create
    @PostMapping("")
    public ResponseEntity<QuestionEntity> PostMapping_one(QuestionEntity entityBefore) {
        ResponseEntity<QuestionEntity> body = null;
        try {
            logger.warn("PostMapping_one id:{} ", entityBefore.toString());
            logger.warn("---- id ={}", entityBefore.getId());
            QuestionEntity entityAfter = null;
            if (entityBefore.getId() != 0) {

                entityAfter = questionRepo.findById(entityBefore.getId()).get();

                //entityAfter.setUpdationTime(Date.valueOf(LocalDate.now()));
            } else {
                entityAfter = new QuestionEntity();
                // entityAfter.setCreationTime(Date.valueOf(LocalDate.now()));
            }
            String content = entityBefore.getMyEditor();
            System.out.println("myEditor content =" + content);
            BeanUtils.copyProperties(entityBefore, entityAfter);

            entityAfter.setMyEditor("--");
            entityAfter = questionRepo.save(entityAfter);
            String path = fileStorageService.storeFileFromContent(content, "question/" + entityAfter.getId());
            entityAfter.setFilepath(path);
            entityAfter = questionRepo.save(entityAfter);

            entityAfter.setMyEditor(readFile(path));
            body = ResponseEntity
                    .created(new URI("/api/"+label+"/" + entityAfter.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(label,
                            entityAfter.getId() + ""))
                    .body(entityAfter);
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(QuestionResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return body;
    }

    public static String readFile(String file) {

        System.out.println("read file =" + file);
        String full = "";
        String st;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                full += st;
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(QuestionResource.class.getName()).log(Level.SEVERE, null, ex);
        }

        return full;
    }

    // delete
    @GetMapping("delete/id/{id}")
    public DeleteResponse DeleteMapping_id(@PathVariable("id") Long id) {
        logger.warn("REST request to delete {} {}", new Object[]{label, id});
        questionRepo.deleteById(id);
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("Deleted  with id " + id);
        return deleteResponse;
    }

    @PostMapping("profileImage")
    public UploadFileResponse fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("fileLabel") String fileLabel) {
        String fileName = fileStorageService.storeFile(file, fileLabel , label);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploads/"+label+"/" + fileName )
                .toUriString();
        logger.warn("fileUploaded to : {} ", new Object[]{fileDownloadUri});
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("fileUpload")
    public UploadFileResponse fileUpload_(@RequestParam("profileImage_file") MultipartFile file, @RequestParam("profileImage") String imageName) {
        String fileName = fileStorageService.storeFile(file, imageName, "");

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/clinicPlus/uploads/" + imageName + "")
                .toUriString();
        logger.warn("fileUploaded to : {} ", new Object[]{fileDownloadUri});
        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

}
