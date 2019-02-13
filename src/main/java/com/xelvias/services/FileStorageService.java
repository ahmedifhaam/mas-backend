package com.xelvias.services;

import com.xelvias.dao.EntryDAO;
import com.xelvias.models.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileStorageService {

    @Autowired
    EntryService entryService;

    private final Path fileStorageLocation;

    public FileStorageService() throws IOException {
        this.fileStorageLocation = Paths.get("./uploads").toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStorageLocation);
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    public Path storeFile(MultipartFile file,String fabric,String component,String size) throws Exception {
        // Normalize file name
        String filename = fabric+"-"+component+"-"+size;
        String fileName = StringUtils.cleanPath(filename);

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return targetLocation;
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) throws Exception {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new Exception("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new Exception("File not found " + fileName, ex);
        }
    }

    public boolean parseDatatoDb(Path filePath,String fabric,String component,String size){
        boolean success = true;
        String file = filePath.toAbsolutePath().toString();
        BufferedReader fileReader = null;

        final String DEL = ",";
        List<Entry> entries = new ArrayList<>();
        try{
            String line = "";
            //Create file reader
            fileReader = new BufferedReader(new FileReader(file));


            //Read the file line by line
            while((line=fileReader.readLine())!=null){
                //Get all the tokens available in a line
                String[] tokens = line.split(DEL);
                if(tokens.length!=26) return false;

                Entry entry = new Entry();
                entry.setFabric(fabric);
                entry.setComponent(component);
                entry.setSize(size);
                entry.setVal1(Double.parseDouble(tokens[0].replaceAll("[^a-zA-Z0-9]", "")));
                entry.setVal2(Double.parseDouble(tokens[1].trim()));
                entry.setVal3(Double.parseDouble(tokens[2].trim()));
                entry.setVal4(Double.parseDouble(tokens[3].trim()));
                entry.setVal5(Double.parseDouble(tokens[4].trim()));
                entry.setVal6(Double.parseDouble(tokens[5].trim()));
                entry.setVal7(Double.parseDouble(tokens[6].trim()));
                entry.setVal8(Double.parseDouble(tokens[7].trim()));
                entry.setVal9(Double.parseDouble(tokens[8].trim()));
                entry.setVal10(Double.parseDouble(tokens[9].trim()));
                entry.setVal11(Double.parseDouble(tokens[10].trim()));
                entry.setVal12(Double.parseDouble(tokens[11].trim()));
                entry.setVal13(Double.parseDouble(tokens[12].trim()));
                entry.setVal14(Double.parseDouble(tokens[13].trim()));
                entry.setVal15(Double.parseDouble(tokens[14].trim()));
                entry.setVal16(Double.parseDouble(tokens[15].trim()));
                entry.setVal17(Double.parseDouble(tokens[16].trim()));
                entry.setVal18(Double.parseDouble(tokens[17].trim()));
                entry.setVal19(Double.parseDouble(tokens[18].trim()));
                entry.setVal20(Double.parseDouble(tokens[19].trim()));
                entry.setVal21(Double.parseDouble(tokens[20].trim()));
                entry.setVal22(Double.parseDouble(tokens[21].trim()));
                entry.setVal23(Double.parseDouble(tokens[22].trim()));
                entry.setVal24(Double.parseDouble(tokens[23].trim()));
                entry.setVal25(Double.parseDouble(tokens[24].trim()));
                entry.setVal26(Double.parseDouble(tokens[25].trim()));

                entries.add(entry);
            }

            for(Entry entry:entries){
                entryService.saveEntry(entry);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
