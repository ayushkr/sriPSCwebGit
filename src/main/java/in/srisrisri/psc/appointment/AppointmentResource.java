package in.srisrisri.psc.appointment;

import in.srisrisri.psc.doctor.DoctorEntity;

import in.srisrisri.psc.responses.DeleteResponse;
import in.srisrisri.psc.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/clinicPlus/api/appointment")
public class AppointmentResource {
int വി=0;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppointmentRepo appointmentRepo;

    public AppointmentResource(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

 
   

   

    private static final String label = "appointment";

    @GetMapping("")
    @ResponseBody
    public List<AppointmentEntity> all() {
        logger.warn("REST getItems() , {} ", new Object[]{label});
        List<AppointmentEntity> list = appointmentRepo.findAll();
        return list;
    }

    
@GetMapping("dateOfAppointment")
    @ResponseBody
    public List<AppointmentEntity> all2() {
        logger.warn("REST getItems() , {} ", new Object[]{label});
        Sort sort=new Sort(new Sort.Order(Sort.Direction.DESC, "dateOfAppointment"));
        List<AppointmentEntity> list = appointmentRepo.findAll(sort);
        return list;
    }
    
    @GetMapping("doctor/{id}")
    @ResponseBody
    public ReportIncomeFromDoctorsDTO all_ByDoctor(@PathVariable("id") int id) {
        logger.warn("REST getItems() , {} ", new Object[]{label});
        Sort sort=new Sort(new Sort.Order(Sort.Direction.DESC, "dateOfAppointment"));
        DoctorEntity doctorEntity = new DoctorEntity();doctorEntity.setId(id);
        
        List<AppointmentEntity> list = appointmentRepo.findByDoctor(doctorEntity,sort);
        
        ReportIncomeFromDoctorsDTO reportIncomeFromDoctorsDTO=new ReportIncomeFromDoctorsDTO(list);
        reportIncomeFromDoctorsDTO.calculateTotal();
        
        return reportIncomeFromDoctorsDTO;
    }
    
    
        @GetMapping("pageNumber/{id}")
    @ResponseBody
    public Page<AppointmentEntity> allPageNumber(@PathVariable("id") int id) {    
        logger.warn("REST getItems() , {} ", new Object[]{label});
        Pageable  pageable=PageRequest.of(id-1,8,Sort.by("dateOfAppointment").ascending().and(Sort.by("bookId").ascending()));
        Page<AppointmentEntity> list = appointmentRepo.findAll(pageable);
        
        return list;
    }

    @GetMapping("{id}")
    @ResponseBody
    public AppointmentEntity id(@PathVariable("id") Long id) {
        logger.warn("id {} No {}", new Object[]{label, id});
        AppointmentEntity appointmentEntity = appointmentRepo.findById(id).get();
//       appointmentEntity.setDoctorId(3L);
//       appointmentEntity.setPatientId(3L);

        //  item.get().setCreationTime(new Date());
        return appointmentEntity;
    }

    // create
    @PostMapping("")
    public ResponseEntity<AppointmentEntity> PostMapping_one(AppointmentEntity entityBefore) {
        ResponseEntity<AppointmentEntity> body = null;
        try {
            logger.warn("PostMapping_one , entityBefore={} ", entityBefore.toString());
          
            AppointmentEntity entityAfter = null;
            if (entityBefore.getId() != 0) {

                entityAfter = appointmentRepo.findById(entityBefore.getId()).get();
                //entityAfter.setUpdationTime(new Date());
            } else {
                entityAfter = new AppointmentEntity();

                //entityAfter.setCreationTime(new Date());
            }

            
            BeanUtils.copyProperties(entityBefore, entityAfter);
            entityAfter = appointmentRepo.save(entityAfter);
logger.warn("PostMapping_one, entityAfter ={}", entityAfter);
            body = ResponseEntity
                    .created(new URI("/api/appointment/" + entityAfter.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(label,
                            entityAfter.getId() + ""))
                    .body(entityAfter);
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(AppointmentResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return body;
    }

    // create many
    @PostMapping("many")
    public ResponseEntity<String> many(@RequestBody AppointmentWrapper items)
            throws URISyntaxException {
        String bodyMatter = "";
        logger.warn("REST request to add many  {} ", items);
        for (AppointmentEntity item : items.getList()) {
            bodyMatter += "item " + item.getId();
        }

        return ResponseEntity.created(new URI("/api/appointment/many"))
                .headers(HeaderUtil.createEntityCreationAlert(label, "0"))
                .body(bodyMatter);

    }

    // delete
    @GetMapping("delete/id/{id}")
    public DeleteResponse DeleteMapping_id(@PathVariable("id") Long id) {
        logger.warn("REST request to delete {} {}", new Object[]{label, id});
        appointmentRepo.deleteById(id);
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("Deleted appointment with id " + id);
        return deleteResponse;
    }

}
