package za.co.tshimx.fnb.api;

import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    Properties env_prop;

    public BaseTest(){

        loadProperties();
    }


    public void loadProperties()  {

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("rest_config.properties");
            env_prop = new Properties();
            env_prop.load(inputStream);
            inputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
