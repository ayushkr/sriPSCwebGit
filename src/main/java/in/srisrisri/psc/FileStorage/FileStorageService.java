/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.srisrisri.psc.FileStorage;

/**
 *
 * @author ayush
 */
import java.io.File;
import java.io.FileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FileStorageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FileStorageProperties fileStorageProperties;
    private final String uploadPathBaseString;
    private final Path basePath;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageProperties = fileStorageProperties;
        uploadPathBaseString = fileStorageProperties.getUploadDir();
        basePath = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

    }

    public List<FileDTO> listFilesInThisFolder(String folderName) {
        String contents = "[";
        List<FileDTO> listFileDTO = new ArrayList<>();
        try {
            Path filePath = this.basePath.resolve(folderName).normalize();
            logger.info("listFilesInThisFolder filePath", new Object[]{filePath.toString()});

            for (File file : filePath.toFile().listFiles()) {
                FileDTO fileDTO = new FileDTO();
                String name = file.getName();
                fileDTO.setName(name);
                String path = "/uploads" + "/" + folderName + "/" + name;
                fileDTO.setPath(path);
                fileDTO.setFileType(name.substring(name.indexOf('.')+1,name.length()));

                listFileDTO.add(fileDTO);
            }

        } catch (Exception ex) {
            logger.info("exp {}", new Object[]{ex.toString()});
//            FileDTO fileDTO = new FileDTO();
//            fileDTO.setFileType("error");
//            listFileDTO.add(fileDTO);
        }
        return listFileDTO;
    }

    public String storeFile(MultipartFile multipartFile, String nameRequired, String pathParent) {
        // Normalize file name
        String nameActual = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String contentType = multipartFile.getContentType();
        String extension = contentType.split("/")[1];
        String nameRequiredWithExt = nameRequired + "." + extension;
        logger.info("storeFile filename= {} ,contentType={} , ext={} ,nameRequiredWithExt={}", new Object[]{nameActual, contentType, extension, nameRequiredWithExt});

        try {
            // Check if the file's name contains invalid characters
            if (nameActual.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + nameActual);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path parentFolderPath = Paths.get(fileStorageProperties.getUploadDir(), pathParent).toAbsolutePath().normalize();

            try {
                Files.createDirectories(parentFolderPath);
            } catch (Exception ex) {
                logger.info("storeFile  Files.createDirectory Exception= {}", new Object[]{ex.toString()});
            }
            //   .toAbsolutePath().normalize();
            Path targetLocation = parentFolderPath.resolve(nameRequiredWithExt);
            logger.info("storeFile targetLocation= {}", new Object[]{targetLocation});
            Files.copy(multipartFile.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return nameRequiredWithExt;
        } catch (IOException ex) {
            logger.info("storeFile IOException= {}", new Object[]{ex.toString()});
            throw new FileStorageException("Could not store file " + nameActual + ". Please try again!", ex);
        }
    }
  public String storeFileFromContent(String content,String path){
       Path parentFolderPath = Paths.get(fileStorageProperties.getUploadDir(), path).toAbsolutePath().normalize();

        File file = (parentFolderPath.toFile());
        try {
            System.out.println("writing to "+file.getAbsolutePath());
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FileStorageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return file.getAbsolutePath();
  }
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.basePath.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
