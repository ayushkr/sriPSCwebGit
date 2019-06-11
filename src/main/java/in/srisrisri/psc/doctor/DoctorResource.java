package in.srisrisri.psc.doctor;

import in.srisrisri.psc.responses.DeleteResponse;
import in.srisrisri.psc.utils.*;
import in.srisrisri.psc.FileStorage.FileStorageService;
import in.srisrisri.psc.FileStorage.UploadFileResponse;
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
@RequestMapping("/clinicPlus/api/doctor")
public class DoctorResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private DoctorRepo doctorRepo;

    DoctorResource(DoctorRepo doctorRepo, FileStorageService fileStorageService_) {
        this.doctorRepo = doctorRepo;
        this.fileStorageService = fileStorageService_;
    }

    private static final String ENTITY_NAME = "Doctor";

    String label = "Doctor";

    @GetMapping("port")
    @ResponseBody
    public List<DoctorEntity> port() {
        logger.warn("REST getItems() , {} ", new Object[]{label});

        List<DoctorEntity> list = doctorRepo.findAll();
        for (DoctorEntity entity : list) {
            if (entity.getFixedId() != 0) {
                entity.setId(entity.getFixedId());
                doctorRepo.save(entity);
            }
        }
        return list;
    }

    @GetMapping("")
    @ResponseBody
    public List<DoctorEntity> all() {
        logger.warn("REST getItems() , {} ", new Object[]{label});

        List<DoctorEntity> list = doctorRepo.findAll();

        return list;
    }

    @GetMapping("pageNumber/{id}")
    @ResponseBody
    public Page<DoctorEntity> allPageNumber(@PathVariable("id") int id) {
        logger.warn("REST getItems() , {} ", new Object[]{ENTITY_NAME});
        Pageable pageable = PageRequest.of(id - 1, 20, Sort.by("id").ascending());
        Page<DoctorEntity> list = doctorRepo.findAll(pageable);

        return list;
    }

    @GetMapping("{id}")
    @ResponseBody
    public Optional<DoctorEntity> id(@PathVariable("id") Long id) {
        logger.warn("id {} No {}", new Object[]{label, id});
        Optional<DoctorEntity> item = doctorRepo.findById(id);
        //  item.get().setCreationTime(new Date());
        return item;
    }

    // create
    @PostMapping("")
    public ResponseEntity<DoctorEntity> PostMapping_one(DoctorEntity entityBefore) {
        ResponseEntity<DoctorEntity> body = null;
        try {
            logger.warn("PostMapping_one id:{} ", entityBefore.toString());
            logger.warn("---- id ={}", entityBefore.getId());
            DoctorEntity entityAfter = null;
            if (entityBefore.getId() != 0) {

                entityAfter = doctorRepo.findById(entityBefore.getId()).get();

                entityAfter.setUpdationTime(Date.valueOf(LocalDate.now()));
            } else {
                entityAfter = new DoctorEntity();
                entityAfter.setCreationTime(Date.valueOf(LocalDate.now()));
            }

            BeanUtils.copyProperties(entityBefore, entityAfter);
            entityAfter = doctorRepo.save(entityAfter);

            body = ResponseEntity
                    .created(new URI("/api/doctors/" + entityAfter.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME,
                            entityAfter.getId() + ""))
                    .body(entityAfter);
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(DoctorResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return body;
    }

   

    // delete
    @GetMapping("delete/id/{id}")
    public DeleteResponse DeleteMapping_id(@PathVariable("id") Long id) {
        logger.warn("REST request to delete {} {}", new Object[]{label, id});
        doctorRepo.deleteById(id);
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("Deleted Doctor with id " + id);
        return deleteResponse;
    }

    @PostMapping("profileImage")
    public UploadFileResponse fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("fileLabel") String fileLabel) {
        String fileName = fileStorageService.storeFile(file, fileLabel+".jpg", "doctor");

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploads/doctor/" + fileLabel + ".jpg")
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
