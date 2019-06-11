package in.srisrisri.psc.appointment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.srisrisri.psc.appointmentStatus.AppointmentStatusEntity;
import in.srisrisri.psc.appointmentType.AppointmentTypeEntity;
import in.srisrisri.psc.doctor.DoctorEntity;

import in.srisrisri.clinic.utils.FinanceUtils;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Transient;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Appointment") // this name will be used to name the Entity
@Table(name = "Appointment") // this name will be used to name a table in DB
public class AppointmentEntity implements Serializable {

    long rid;

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    long id;
    @OneToOne
    DoctorEntity doctor;
  
     @JsonDeserialize(using = in.srisrisri.clinic.utils.DateHandler.class)
    Date dateOfAppointment;
    @ColumnDefault(value = "0")
    int tokenNumber;
    @ColumnDefault(value = "0")
    int consultFee;
    @ColumnDefault(value = "0")
    int feeForClinic;
    @OneToOne
    AppointmentTypeEntity appointmentTypeEntity;
    @OneToOne
    AppointmentStatusEntity appointmentStatusEntity;
    Date creationTime;
    Date updationTime;
    @ColumnDefault(value = "0")
    long fixedId;
     @ColumnDefault(value = "0")
    long bookId;
    @Transient
    String totalInWords="not set";

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

   
    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    

    public int getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public int getConsultFee() {
        return consultFee;
    }

    public void setConsultFee(int consultFee) {
        this.consultFee = consultFee;
    }

    public int getFeeForClinic() {
        return feeForClinic;
    }

    public void setFeeForClinic(int feeForClinic) {
        this.feeForClinic = feeForClinic;
    }

    public AppointmentTypeEntity getAppointmentTypeEntity() {
        return appointmentTypeEntity;
    }

    public void setAppointmentTypeEntity(AppointmentTypeEntity appointmentTypeEntity) {
        this.appointmentTypeEntity = appointmentTypeEntity;
    }

    public AppointmentStatusEntity getAppointmentStatusEntity() {
        return appointmentStatusEntity;
    }

    public void setAppointmentStatusEntity(AppointmentStatusEntity appointmentStatusEntity) {
        this.appointmentStatusEntity = appointmentStatusEntity;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdationTime() {
        return updationTime;
    }

    public void setUpdationTime(Date updationTime) {
        this.updationTime = updationTime;
    }

    public long getFixedId() {
        return fixedId;
    }

    public void setFixedId(long fixedId) {
        this.fixedId = fixedId;
    }

    public String getTotalInWords() {
        return FinanceUtils.RsToWords((getConsultFee()+getFeeForClinic())+"");
    }

    public void setTotalInWords(String totalInWords) {
        this.totalInWords = totalInWords;
    }

   
}
