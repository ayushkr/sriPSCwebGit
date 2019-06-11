/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.psc.FileStorage;

/**
 *
 * @author ayush
 */

import in.srisrisri.psc.utils.HeaderUtil;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/clinicPlus/api/fileStore")
public class FileStoreResource {

    private static final Logger logger = LoggerFactory.getLogger(FileStoreResource.class);
 private static final String ENTITY_NAME = "fileStore";
    @Autowired
    private final FileStorageService fileStorageService;
    @Autowired
    private final FileStoreRepo fileStoreRepo;

    public FileStoreResource(FileStorageService fileStorageService, FileStoreRepo fileStoreRepo) {
        this.fileStorageService = fileStorageService;
        this.fileStoreRepo = fileStoreRepo;
    }
    
    @GetMapping("")
    @ResponseBody
    public List<FileStoreEntity> all() {
        logger.warn("REST getItems() , {} ", new Object[]{ENTITY_NAME});

        List<FileStoreEntity> list = fileStoreRepo.findAll();

        return list;
    }
    
     @GetMapping("{id}")
    @ResponseBody
    public Optional<FileStoreEntity> id(@PathVariable("id") Long id) {
        logger.warn("id {} No {}", new Object[]{ENTITY_NAME, id});
        Optional<FileStoreEntity> item = fileStoreRepo.findById(id);
        //  item.get().setCreationTime(new Date());
        return item;
    }

    @GetMapping("pageNumber/{id}")
    @ResponseBody
    public Page<FileStoreEntity> allPageNumber(@PathVariable("id") int id) {
        logger.warn("REST getItems() , {} ", new Object[]{ENTITY_NAME});
        Pageable pageable = PageRequest.of(id - 1, 5, Sort.by("id").ascending());
        Page<FileStoreEntity> list = fileStoreRepo.findAll(pageable);

        return list;
    }
    
    
     @PostMapping("")
    public ResponseEntity<FileStoreEntity> PostMapping_one(FileStoreEntity entityBefore) {
        ResponseEntity<FileStoreEntity> body = null;
        try {
            logger.warn("PostMapping_one id:{} ", entityBefore.toString());
            logger.warn("---- id ={}", entityBefore.getId());
            FileStoreEntity entityAfter = null;
            if (entityBefore.getId() != 0) {

                entityAfter = fileStoreRepo.findById(entityBefore.getId()).get();

               // entityAfter.setUpdationTime(Date.valueOf(LocalDate.now()));
            } else {
                entityAfter = new FileStoreEntity();
                //entityAfter.setCreationTime(Date.valueOf(LocalDate.now()));
            }

            BeanUtils.copyProperties(entityBefore, entityAfter);
            entityAfter = fileStoreRepo.save(entityAfter);

            body = ResponseEntity
                    .created(new URI("/api/fileStore/" + entityAfter.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME,
                            entityAfter.getId() + ""))
                    .body(entityAfter);
        } catch (BeansException | URISyntaxException ex) {
            java.util.logging.Logger.getLogger(FileStoreResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return body;
    }

    
    
    
    @GetMapping("folder/{folder}")
    public   List<FileDTO>  listFiles(@PathVariable String folder){
    folder=folder.replace(".", "/");
       List<FileDTO>  listFilesInThisFolder = fileStorageService.listFilesInThisFolder(folder);
        return listFilesInThisFolder;
    }
    
    
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file,"noname","");

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/all")
    public ResponseEntity<String> getList() {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = ResponseEntity.created(new URI("---"))
                    .headers(HeaderUtil.createEntityCreationAlert("Fle",
                            "id" + ""))
                    .body("hai file");
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger("FileSer").log(Level.SEVERE, null, ex);
        }
        return responseEntity;
    }

  

}
