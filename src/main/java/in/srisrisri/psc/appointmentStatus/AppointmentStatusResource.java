package in.srisrisri.psc.appointmentStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/clinicPlus/api/appointmentStatusEntity")
public class AppointmentStatusResource {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppointmentStatusRepo repo;
  
   

  

    private static final String label = "appointmentStatus";

    public AppointmentStatusResource(AppointmentStatusRepo repo) {
        this.repo = repo;
    }

    @GetMapping("")
    @ResponseBody
    public List<AppointmentStatusEntity> all() {
        logger.warn("REST getItems() , {} ", new Object[]{label}); 
        List<AppointmentStatusEntity> list = repo.findAll();
        return list;
    }
    
   

}
