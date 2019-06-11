/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.psc.appointment;

import java.util.List;

/**
 *
 * @author akr
 */
public class ReportIncomeFromDoctorsDTO {
    List<AppointmentEntity> appointmentEntitys;

    float totalConsultFee;
    float totalFeeForClinic;

    public ReportIncomeFromDoctorsDTO(List<AppointmentEntity> appointmentEntitys) {
        this.appointmentEntitys = appointmentEntitys;
    }

    public List<AppointmentEntity> getAppointmentEntitys() {
        return appointmentEntitys;
    }

    public void setAppointmentEntitys(List<AppointmentEntity> appointmentEntitys) {
        this.appointmentEntitys = appointmentEntitys;
    }

    public float getTotalConsultFee() {
        return totalConsultFee;
    }

    public void setTotalConsultFee(float totalConsultFee) {
        this.totalConsultFee = totalConsultFee;
    }

    public float getTotalFeeForClinic() {
        return totalFeeForClinic;
    }

    public void setTotalFeeForClinic(float totalFeeForClinic) {
        this.totalFeeForClinic = totalFeeForClinic;
    }
    
    
    
    
 
    
    
    public void calculateTotal(){
        for(AppointmentEntity appointmentEntity : appointmentEntitys){
        totalConsultFee+=appointmentEntity.getConsultFee();
       totalFeeForClinic+=appointmentEntity.getFeeForClinic();
        }
    }
    
}
