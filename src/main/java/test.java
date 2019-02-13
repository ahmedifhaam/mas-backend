import com.google.gson.Gson;
import com.xelvias.models.PredictionResult;

public class test{
    public static void main(String args[]){
        String as = "{\"data\": [32.8, 43.6, 48.4, 46.8, 51.4, 53.6, 53.6, 51.0, 46.6, 49.375, 32.2, 25.0, 61.0, 403.0, 558.0, 599.0, 510.0, 600.0, 529.0, 606.0, 512.0, 539.625, 60.0, 41.0], \"length\": {\"predicted_val\": 60.595947265625, \"mae\": 12.305839538574219}, \"width\": {\"predicted_val\": 37.56917953491211, \"mae\": 9.980630874633789}}";
        PredictionResult predictionResult = new Gson().fromJson(as, PredictionResult.class);
        System.out.println(predictionResult.toString());
    }
}