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
    
    
////            JSONObject responseJson = new JSONObject(responseString);
////            String per_page=JsonUtil.getValueByPath(responseJson, "/per_page");
////            String total=JsonUtil.getValueByPath(responseJson, "/total");
////            logger.info("per_page :"+ per_page);
////            logger.info("total :"+ total);
    
////            String lastname =JsonUtil.getValueByPath(responseJson, "/data[0]/last_name");
////            logger.info("/data[0]/last_name :"+ lastname);
////            String id =JsonUtil.getValueByPath(responseJson, "/data[0]/id");
////            logger.info("/data[0]/id :"+ id);
////            String firstname =JsonUtil.getValueByPath(responseJson, "/data[0]/first_name");
////            logger.info("/data[0]/first_name :"+ firstname);
////            String avatar =JsonUtil.getValueByPath(responseJson, "/data[0]/avatar");
////            logger.info("/data[0]/avatar :"+ avatar);
            
               
    
}
