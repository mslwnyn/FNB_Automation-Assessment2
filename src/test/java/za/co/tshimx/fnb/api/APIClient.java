package za.co.tshimx.fnb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import za.co.tshimx.fnb.domain.UsersPage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import static za.co.tshimx.fnb.api.APITest.logger;
import za.co.tshimx.fnb.utils.ExtentTestManager;

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
