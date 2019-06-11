package in.srisrisri.psc.appointmentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/clinicPlus/api/appointmentTypeEntity")
public class AppointmentTypeResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppointmentTypeRepo repo;
  
   

  

    private static final String label = "appointment";

    public AppointmentTypeResource(AppointmentTypeRepo repo) {
        this.repo = repo;
    }

    @GetMapping("")
    @ResponseBody
    public List<AppointmentTypeEntity> all() {
        logger.warn("REST getItems() , {} ", new Object[]{label}); 
        List<AppointmentTypeEntity> list = repo.findAll();
        return list;
    }
    
   

}
