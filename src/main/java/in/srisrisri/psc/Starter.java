package in.srisrisri.psc;

import in.srisrisri.psc.FileStorage.FileStorageProperties;
import in.srisrisri.psc.FileStorage.FileStorageService;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class Starter {

    private static org.apache.log4j.Logger logger = Logger.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("----------- before SpringApplication.run----------------->");

//            DerbyServerUtil derbyServerUtil = new DerbyServerUtil(1527);
//           derbyServerUtil.start();
        SpringApplication.run(Starter.class, args);
       
        logger.info("-------------started- ----------------");

    }

   
    
    
    
    
    
    
    
    
    
    @Bean
    public CommandLineRunner demo() {
        logger.info("started CommandLineRunner");
        return null;

    }

}
