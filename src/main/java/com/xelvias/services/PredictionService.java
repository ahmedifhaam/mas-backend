package com.xelvias.services;

import com.xelvias.models.PredictionResult;

public interface PredictionService {
    PredictionResult predictfor(String[] data,String fabric,String component,String size);
}
