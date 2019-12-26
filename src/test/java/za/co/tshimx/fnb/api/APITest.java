package za.co.tshimx.fnb.api;


import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.co.tshimx.fnb.utils.ExtentTestManager;


public class APITest extends BaseTest {
     final static Logger logger = Logger.getLogger(APITest.class);
    String serviceURL;
    String apiURL;
    String uri;
    APIClient apiClient;

    @BeforeMethod
    public void setUP() throws Exception {
        logger.info("API BeforeMethod : Setting up " );
        serviceURL = env_prop.getProperty("serviceURL");
        apiURL = env_prop.getProperty("apiURL");
        uri = serviceURL + apiURL;
        logger.info("API BeforeMethod url : " + uri);
      
    }

    @Test
    public void getAPITestMethod() {
        try{
            
              apiClient = new APIClient();
              apiClient.get(uri);
        }catch(Exception e){
            ExtentTestManager.getTest().log(LogStatus.FAIL,e.getMessage());
            Assert.fail(e.getMessage());
        }
        

    }
}
