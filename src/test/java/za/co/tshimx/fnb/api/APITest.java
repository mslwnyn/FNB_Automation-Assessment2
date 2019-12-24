package za.co.tshimx.fnb.api;


import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.co.tshimx.fnb.utils.ExtentTestManager;


public class APITest extends BaseTest {
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
    public void getAPITestMethod() {
        try{
              apiClient = new APIClient();
              apiClient.get(url);
        }catch(Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL,e.getMessage());
            Assert.fail(e.getMessage());
        }
        

    }
}
