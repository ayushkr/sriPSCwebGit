/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.clinic.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author akr
 */
public class DateHandler extends StdDeserializer<Date> {

    public DateHandler() {
        this(null);
    }

    public DateHandler(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String date = p.getText();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
             System.out.println("sdf="+sdf.toString());
            java.util.Date utildate = sdf.parse(date);
           
            Date sqlDate = new Date(utildate.getYear(), utildate.getMonth(), utildate.getDay());
            return sqlDate;
        } catch (Exception e) {
            System.out.println("deserialize() sdf "+e.toString());
            return null;
        }

    }

}
