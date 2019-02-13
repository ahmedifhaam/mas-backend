package com.xelvias.controllers;

import com.xelvias.models.PredictionRequestBody;
import com.xelvias.models.PredictionResult;
import com.xelvias.services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PredictionController {

    @Autowired
    PredictionService predictionService;

    @RequestMapping(value = "/predict",method = RequestMethod.POST)
    @ResponseBody
    public PredictionResult predictvalues(@RequestBody PredictionRequestBody body){
        PredictionResult predictfor = predictionService.predictfor(body.getData(), body.getFabric(), body.getComponent(), body.getSize());
        System.out.println(predictfor.getData());
        System.out.println(predictfor.getLength());
        System.out.println(predictfor.getWidth());
        return predictfor;
    }
}
