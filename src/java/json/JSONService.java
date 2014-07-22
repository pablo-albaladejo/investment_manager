package json;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class JSONService {
               
    public static JsonObject getJsonObject(String url) {
        String stringJson = getStream(url);
        JsonParser jsonParser = new JsonParser();        
        return (JsonObject)jsonParser.parse(stringJson);
    }   
       
    private static String getStream(String stringUrl) {     
        String outputString;
        try{
            URL url = new URL(stringUrl);
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8")); 
                        
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            
            while ((inputStr = streamReader.readLine()) != null){
                responseStrBuilder.append(inputStr);
            }
            outputString = responseStrBuilder.toString();
            
        }catch(IOException e){
            outputString = null;
        }
        //Workaround: Some Google financials json are worng
        String pattern = "// [";
        if (outputString != null && outputString.substring(0, pattern.length()).compareTo(pattern) == 0){
           outputString = outputString.substring(pattern.length(), outputString.length()-1);
        }
        return outputString;
    }
}
