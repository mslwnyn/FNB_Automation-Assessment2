package za.co.tshimx.fnb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class APIClient {

    public void get(String url) throws Exception {
        

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            JSONObject responseJson = new JSONObject(responseString);
            writetoFile(jsonToJavaObject(jsonToJavaObject(responseString)));

            Header[] headerArray = closeableHttpResponse.getAllHeaders();
            HashMap allHeaders = new HashMap<String, String>();
            for (Header header : headerArray) {
                allHeaders.put(header.getName(), header.getValue());
            }

        
    }


    public void writetoFile (String fileContent) throws IOException
    {

        FileWriter fileWriter = new FileWriter("./apiFile//api.txt");
        fileWriter.write(fileContent);
        fileWriter.close();
    }

    public String jsonToJavaObject (String input){
        UsersPage userPage =null;
        try{
            ObjectMapper mapper = new ObjectMapper();
            userPage = mapper.readValue(input, UsersPage.class);
            System.out.println(userPage);

        }catch(Exception e){
            e.printStackTrace();
        }
        return userPage.toString();
    }
}
