/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.psc.Document;

import in.srisrisri.psc.doctor.DoctorEntity;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author akr
 */
@RestController
@RequestMapping("/clinicPlus/api/csvUpload")
public class CSV_Uploader {

    @GetMapping("")
    public String po() {

        String line = null, fulltext = null;

        DoctorEntity doctorEntity = new DoctorEntity();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("/home/akr/export_doctor.csv"), StandardCharsets.US_ASCII);
             line = br.readLine();
            while (line != null) {
              
                fulltext += br.readLine();
                  line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(CSV_Uploader.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] lines_all = fulltext.split("\r\n");
        
         for (String cellheading : lines_all[0].split("=")) {
                System.out.println("heading --> " + cellheading);
            }
         
        for (int i = 1; i < lines_all.length; i++) {
           

            String[] columns = lines_all[i].split("=");
            for (int j = 0; j < columns.length; j++) {
                String content = columns[j];
                System.out.println("col[" + j + "] =" + content);
                switch (j) {
                    case 0: {
                        doctorEntity.setName(content);
                        break;
                    }
                    case 2: {

                        break;
                    }
                }

            }
        }
            System.out.println("doctor=" + doctorEntity.toString());
            System.out.println("line= " + line);
           
        

        return "done";
    }
    String input = "";
}
