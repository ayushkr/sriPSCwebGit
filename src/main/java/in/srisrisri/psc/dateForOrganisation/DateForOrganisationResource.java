package in.srisrisri.psc.dateForOrganisation;


import in.srisrisri.psc.responses.DeleteResponse;
import in.srisrisri.psc.utils.HeaderUtil;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@RestController
@RequestMapping("/clinicPlus/api/dateForOrganisation")
public class DateForOrganisationResource {
String label="DateForOrganisation";
    private final Logger logger = LoggerFactory.getLogger(DateForOrganisationResource.class);

    @Autowired
   DateForOrganisationRepo repo;


    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<DateForOrganisationEntity>> gets(){
       logger.debug("gets", new Object (){ });
        List<DateForOrganisationEntity> list=repo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

 @GetMapping("pageNumber/{id}")
    @ResponseBody
    public Page<DateForOrganisationEntity> allPageNumber(@PathVariable("id") int id) {    
        logger.warn("REST getItems() , {} ", new Object[]{label});
        Pageable  pageable=PageRequest.of(id-1, 5,Sort.by("id").ascending());
        Page<DateForOrganisationEntity> list = repo.findAll(pageable);
        
        return list;
    }


    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<Optional<DateForOrganisationEntity>> geti(@PathVariable("id") Long id){
      Optional<DateForOrganisationEntity> item=repo.findById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    
    
       // create
    @PostMapping("")
    public ResponseEntity<DateForOrganisationEntity> PostMapping_one(DateForOrganisationEntity entityBefore) {
         ResponseEntity<DateForOrganisationEntity> body = null;
        try {
            logger.warn("PostMapping_one id:{} ", entityBefore.toString());
            logger.warn("---- id ={}", entityBefore.getId());
            DateForOrganisationEntity entityAfter = null;
            if(entityBefore.getId()!=0){
            
            entityAfter=repo.findById(entityBefore.getId()).get();
             //entityAfter.setUpdationTime(new Date());
            }else{
            entityAfter=new DateForOrganisationEntity();
            // entityAfter.setCreationTime(new Date());
            }
           
            BeanUtils.copyProperties(entityBefore, entityAfter);
            entityAfter = repo.save(entityAfter);

           body = ResponseEntity
                    .created(new URI("/api/dateForOrganisationEntity/" + entityAfter.getId()))
                    .headers(HeaderUtil.createEntityCreationAlert(label,
                            entityAfter.getId() + ""))
                    .body(entityAfter);
        } catch (Exception ex) {
            logger.error("",ex); 
        }
        return body;
    }
   
       // delete
    @GetMapping("delete/id/{id}")
    public DeleteResponse DeleteMapping_id(@PathVariable("id") Long id) {
         DeleteResponse deleteResponse = new DeleteResponse();
        logger.warn("DeleteMapping_id obj={},id= {}", new Object[]{label, id});
        try{
       repo.deleteById(id);
       deleteResponse.setMessage("Deleted with id " + id);
        }
        catch(Exception e){
                deleteResponse.setMessage(e.toString()); 
                deleteResponse.setStatus("fail");
                }
       
        
        return deleteResponse;
    }

  
  

   

}