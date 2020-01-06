package za.co.tshimx.fnb.api;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;


public class APIClient {
    final static Logger logger = Logger.getLogger(APIClient.class);
    public CloseableHttpResponse getCloseableHttpResponse(String url) throws Exception {
           
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
            return closeableHttpResponse;     
    }
    
    
    public CloseableHttpResponse getCloseableHttpResponse(String url,HashMap<String,String> headerMap) throws Exception {
           
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            for(Map.Entry<String,String> entry :headerMap.entrySet() ){
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
            return closeableHttpResponse;     
    }


    
}
