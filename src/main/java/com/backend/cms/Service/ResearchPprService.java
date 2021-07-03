package com.backend.cms.Service;

import com.backend.cms.Exceptions.FileStorageException;
import com.backend.cms.Exceptions.MyFileNotFoundException;
import com.backend.cms.Model.FileStorageProperties;
import com.backend.cms.Model.ResearchPpr;
import com.backend.cms.Repository.ResearchPprRepository;
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


//import java.util.ArrayList;

@Service
public class ResearchPprService {
    private final Path fileStorageLocation;
    @Autowired
    public ResearchPprRepository research;
//    @Autowired
//    public EmailService emservice;

    public ResearchPpr saveResearch(ResearchPpr researchPpr)
    {
//        try {
//            emservice.sendEmail(researchPpr);
      return  research.save(researchPpr);
//        } catch (MailException mailException) {
//            System.out.println(mailException);
//            return null;
//        }


    }
    public List<ResearchPpr> showResearch() {
        return (ArrayList<ResearchPpr>) research.findAll();
    }


    @Autowired
    public ResearchPprService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
           throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
                   ex);
       }
    }

    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
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
