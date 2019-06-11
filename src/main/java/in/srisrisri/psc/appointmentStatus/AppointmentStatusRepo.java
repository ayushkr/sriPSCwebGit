package in.srisrisri.psc.appointmentStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentStatusRepo extends JpaRepository<AppointmentStatusEntity,Long> {
    
}


