package com.xelvias.models;

import com.google.gson.Gson;

import java.io.Serializable;

public class PredictionResult implements Serializable {

    SingleValue length;
    SingleValue width;
    double[] data;

    class SingleValue implements Serializable{
        double predicted_val;
        double mae;

        public double getPredicted_val() {
            return predicted_val;
        }

        public void setPredicted_val(double predicted_val) {
            this.predicted_val = predicted_val;
        }

        public double getMae() {
            return mae;
        }

        public void setMae(double mae) {
            this.mae = mae;
        }

        @Override
        public String toString() {
            return new Gson().toJson(this);
        }
    }

    public SingleValue getLength() {
        return length;
    }

    public void setLength(SingleValue length) {
        this.length = length;
    }

    public SingleValue getWidth() {
        return width;
    }

    public void setWidth(SingleValue width) {
        this.width = width;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
