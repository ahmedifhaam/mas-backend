package com.xelvias.services;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.Gson;
import com.xelvias.models.PredictionResult;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class PredictionServiceImpl implements PredictionService {
    @Override
    public PredictionResult predictfor(String[] data, String fabric, String component, String size) {
        try{
            Path fileStorageLocation = Paths.get("./uploads").toAbsolutePath().normalize();
//            String[] ar = {"32.8", "43.6", "48.4", "46.8", "51.4", "53.6", "53.6", "51", "46.6", "49.375",
//                    "32.2", "25", "61", "403", "558", "599", "510", "600", "529", "606", "512", "539.625", "60", "41"};
            String[] ar = data;
            String arg = String.join(",",ar);
            String fileName = fabric+"-"+component+"-"+size;
            Path targetLocation = fileStorageLocation.resolve(fileName);
            System.out.println(targetLocation.toAbsolutePath().toString());
            String fpath = Paths.get("./pyt").resolve("predictor.py").toAbsolutePath().toString();
            System.out.println(fpath);
            ProcessBuilder pb = new ProcessBuilder("python3",fpath,targetLocation.toAbsolutePath().toString(),arg);
//            ProcessBuilder pb = new ProcessBuilder("python3",fpath);
            Process p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String val = null;
            String output = "";

            while((val = in.readLine())!=null){
                System.out.println(val);
                output+=val;
            }
//            String val = in.readLine();
//            System.out.println(val);
            if(output.contains("Error")){
                return null;
            }else{
                PredictionResult predictionResult = new Gson().fromJson(output, PredictionResult.class);
                System.out.println("here : 1 : "+predictionResult);
                if(predictionResult==null) System.out.println("out :" + output);
                else System.out.println(predictionResult.getLength());
                return predictionResult;
            }

        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
