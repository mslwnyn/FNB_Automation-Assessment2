package za.co.tshimx.fnb.api;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetTest extends BaseTest {
    String serviceURL;
    String apiURL;
    String url;
    APIClient apiClient;

    @BeforeMethod
    public void setUP() throws Exception {
        serviceURL = env_prop.getProperty("serviceURL");
        apiURL = env_prop.getProperty("apiURL");
        url = serviceURL + apiURL;
        System.out.println(url);
    }


    @Test
    public void getTestMethod() {
        apiClient = new APIClient();
        apiClient.get(url);

    }
}
