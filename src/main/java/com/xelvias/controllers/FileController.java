package com.xelvias.controllers;


import com.xelvias.models.UploadFileResponse;
import com.xelvias.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.annotation.MultipartConfig;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileController {
    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    @ResponseBody
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,@RequestParam String component,
                                         @RequestParam String size,@RequestParam String fabric){
        try{

            Path filename = fileStorageService.storeFile(file,fabric,component,size);
//            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                    .path("uploads/")
//                    .path(filename)
//                    .toUriString();

            boolean result = fileStorageService.parseDatatoDb(filename,fabric,component,size);


            return new UploadFileResponse(filename.getFileName().toString(),result,file.getContentType(),file.getSize());
        }catch (Exception ex){
            ex.printStackTrace();
            return new UploadFileResponse("",false,"",0);
        }
    }

//    @PostMapping("/uploadMultipleFiles")
//    @ResponseBody
//    public List<UploadFileResponse> uploadMultipartFiles(@RequestParam("files")MultipartFile[] files){
//        return Arrays.asList(files)
//                .stream()
//                .map(file->uploadFile(file))
//                .collect(Collectors.toList());
//    }
}
