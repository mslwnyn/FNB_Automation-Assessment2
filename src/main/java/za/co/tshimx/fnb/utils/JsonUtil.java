/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.tshimx.fnb.utils;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Tshimologo
 */
public class JsonUtil {
   
    public static String getValueByPath(JSONObject responseJson,String jpath){
        Object obj = responseJson;
        for(String s :jpath.split("/")) 
            if(!s.isEmpty())
                if(!(s.contains("[")||s.contains("]")))
                     obj=((JSONObject)obj).get(s);
                else if(s.contains("[")||s.contains("]"))
                    obj=((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
        return responseJson.toString();
    }
    
    
          
               
    
}
