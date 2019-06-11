/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.psc.Document;

/**
 *
 * @author akr
 */
import in.srisrisri.psc.appointment.AppointmentEntity;
import in.srisrisri.psc.appointment.AppointmentResource;
import in.srisrisri.psc.appointmentStatus.AppointmentStatusEntity;

import in.srisrisri.psc.appointmentType.AppointmentTypeEntity;
import in.srisrisri.psc.doctor.DoctorEntity;
import in.srisrisri.psc.doctor.DoctorResource;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psc/api/xlsx")
public class ApachePOIExcel {

    @Autowired
    DoctorResource doctorResource;
  
    @Autowired
    AppointmentResource appointmentResource;

    private static final String READ_FILE_NAME = "/home/akr/xlsx/doctors.xlsx";
    private static final String WRITE_FILE_NAME = "/home/akr/Desktop/MyFirstExcelWrite.xlsx";

    public ApachePOIExcel(DoctorResource doctorResource,  AppointmentResource appointmentResource) {
        this.doctorResource = doctorResource;
       
        this.appointmentResource = appointmentResource;
    }

    @GetMapping("write")
    public void writeTest() {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
            {"Datatype", "Type", "Size(in bytes)"},
            {"int", "Primitive", 2},
            {"float", "Primitive", 4},
            {"double", "Primitive", 8},
            {"char", "Primitive", 1},
            {"String", "Non-Primitive", "No fixed size"}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(WRITE_FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }

    @GetMapping("readDoctors")
    public void readDoctors(String[] args) {

        try {

            FileInputStream excelFile = 
                    new FileInputStream(
                            new File("/home/akr/Desktop/clinicplus/netbeansProject/src/main/webapp/uploads/patient/1/prescription/doctor.xlsx")
                
                    );
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Row row0 = sheet.getRow(0);
              short lastCellNum = row0.getLastCellNum();
            for (int colNum = 0; colNum < lastCellNum; colNum++) {
                Cell cell0 = row0.getCell(colNum);
                String stringCellValue = cell0.getStringCellValue();
                System.out.println("value [" + colNum + "] =" + stringCellValue);
            }

            System.out.println("--------------------------" + sheet.getLastRowNum());
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                DoctorEntity doctorEntity = new DoctorEntity();
                Row row = sheet.getRow(rowNum);
                for (int colNum = 0; colNum < lastCellNum; colNum++) {
                    Cell cell0 = row.getCell(colNum);

                    switch (colNum) {
                        case 15: {
                            String value = cell0.getStringCellValue();
                            doctorEntity.setName(value);
                            break;
                        }
                        case 10: {
                            double value = cell0.getNumericCellValue();
                            doctorEntity.setFees((int) value);
                            break;
                        }
                        case 5: {
                            String value = cell0.getStringCellValue();
                            doctorEntity.setDepartment(value);
                            break;
                        }
                        case 1: {
                            String value = cell0.getStringCellValue();
                            doctorEntity.setAddress(value);
                            break;
                        }
                        case 6: {
                            String value = cell0.getStringCellValue();
                            doctorEntity.setDescription(value);
                            break;
                        }
                        case 20: {
                            String value = cell0.getStringCellValue();
                            doctorEntity.setVisitDay(value);
                            break;
                        }
                        case 21: {
                            String value = cell0.getStringCellValue();
                            doctorEntity.setVisitTime(value);
                            break;
                        }

                        case 12: {
                            double value = cell0.getNumericCellValue();
                            doctorEntity.setFixedId((long) value);
                            break;
                        }
                        case 2: {
                            String value = cell0.getStringCellValue();
                            doctorEntity.setContactPhone(value);
                            break;
                        }
                          

                    }

                }
                // end of row 
                System.out.println("row " + rowNum + "    " + doctorEntity.toString());
                doctorResource.PostMapping_one(doctorEntity);
            }

//            
//            
//            Iterator<Row> iterator = datatypeSheet.iterator();
//
//            while (iterator.hasNext()) {
//
//                Row currentRow = iterator.next();
//                Iterator<Cell> cellIterator = currentRow.iterator();
//
//                while (cellIterator.hasNext()) {
//
//                    Cell currentCell = cellIterator.next();
//                    //getCellTypeEnum shown as deprecated for version 3.15
//                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
//                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                        System.out.print(currentCell.getStringCellValue() + "-->");
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        System.out.print(currentCell.getNumericCellValue() + "-->");
//                    }
//
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    String body = "<html>";

   

    public java.sql.Date convertDateUtilToSql(Date dateUtil) {
        java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
        return dateSql;
    }

    public java.sql.Date convertToLocalDate2(Date dateUtil) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(dateUtil);
        // String dateLocal = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
        // String dateLocal = calendar.get(Calendar.YEAR) + "-" + zero((calendar.get(Calendar.MONTH) + 1)) + "-" + zero(calendar.get(Calendar.DATE));
        java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
        return dateSql;
    }

    public String zero(int n) {
        if (n < 10) {
            return "0" + n;
        } else {
            return "" + n;
        }

    }

    @GetMapping("readAppointments")
    public String readAppointments(String[] args) {
        body = "<html>";
        try {

            FileInputStream excelFile =
                    new FileInputStream(
                        new File("/home/akr/Desktop/clinicplus/netbeansProject/src/main/webapp/uploads/patient/1/prescription/appointment.xlsx")
                
                    );
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);

            Row row0 = sheet.getRow(0);
           
            short lastCellNum = row0.getLastCellNum();
            for (int colNum = 0; colNum < lastCellNum; colNum++) {
                Cell cell0 = row0.getCell(colNum);
                String stringCellValue = cell0.getStringCellValue();
                body += ("<br>value [" + colNum + "] =" + stringCellValue);
            }

            System.out.println("--------------------------" + sheet.getLastRowNum());
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                AppointmentEntity appointEntity = new AppointmentEntity();
                Row row = sheet.getRow(rowNum);
                for (int colNum = 0; colNum < lastCellNum; colNum++) {
                    Cell cell0 = row.getCell(colNum);
                    try {
                        switch (colNum) {
                             case 5: {
                                double value = cell0.getNumericCellValue();
                                appointEntity.setFixedId((long) value);
                                break;
                            }
                            case 13: {
                                double value = cell0.getNumericCellValue();
                                appointEntity.setBookId((long) value);
                                break;
                            }
                            case 11: {
                                double value = cell0.getNumericCellValue();
                                DoctorEntity doctorEntity = new DoctorEntity();
                                doctorEntity.setId((long) value);
                                appointEntity.setDoctor(doctorEntity);
                                break;
                            }
                            case 12: {
                                double value = cell0.getNumericCellValue();
                              
                                break;
                            }
                            case 3: {
                                Date value = cell0.getDateCellValue();
                                appointEntity.setDateOfAppointment(convertDateUtilToSql(value));
                                break;
                            }
                            case 2: {
                                Date value = cell0.getDateCellValue();
                                appointEntity.setCreationTime(convertDateUtilToSql(value));
                                break;
                            }

                            case 7: {
                                int value = (int) cell0.getNumericCellValue();
                                appointEntity.setTokenNumber(value);
                                break;
                            }
                            case 1: {
                                int value = (int) cell0.getNumericCellValue();
                                appointEntity.setConsultFee(value);
                                break;
                            }
                            case 4: {
                                int value = (int) cell0.getNumericCellValue();
                                appointEntity.setFeeForClinic(value);
                                break;
                            }

                            case 9: {
                                int value = (int) cell0.getNumericCellValue();
                                AppointmentStatusEntity appointmentStatusEntity = new AppointmentStatusEntity();
                                appointmentStatusEntity.setId(value);
                                appointEntity.setAppointmentStatusEntity(appointmentStatusEntity);
                                break;
                            }

                            case 10: {
                                int value = (int) cell0.getNumericCellValue();
                                AppointmentTypeEntity appointmentStatusEntity = new AppointmentTypeEntity();
                                appointmentStatusEntity.setId(value);
                                appointEntity.setAppointmentTypeEntity(appointmentStatusEntity);
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(" exception at" + colNum);
                    }

                }
                // end of row 
                body += ("<hr>row " + rowNum + "    " + appointEntity.toString());
            appointmentResource.PostMapping_one(appointEntity);
            }

//            
//            
//            Iterator<Row> iterator = datatypeSheet.iterator();
//
//            while (iterator.hasNext()) {
//
//                Row currentRow = iterator.next();
//                Iterator<Cell> cellIterator = currentRow.iterator();
//
//                while (cellIterator.hasNext()) {
//
//                    Cell currentCell = cellIterator.next();
//                    //getCellTypeEnum shown as deprecated for version 3.15
//                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
//                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                        System.out.print(currentCell.getStringCellValue() + "-->");
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        System.out.print(currentCell.getNumericCellValue() + "-->");
//                    }
//
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public void main(String[] args) {
        writeTest();
    }
}
