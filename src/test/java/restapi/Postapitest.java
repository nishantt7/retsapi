package restapi;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONException;
import org.testng.annotations.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.Testbase;
import com.qa.client.RestClient;
import com.qa.data.Data;

public class Postapitest extends Testbase
		{
			String url;
			String apiurl;
			String serviceurl;
			CloseableHttpResponse httpresponse;
			RestClient restclient;
			
			@BeforeMethod
			public void urlcreation() 
			{
				url=prop.getProperty("URL");
				apiurl=prop.getProperty("serviceurl");
				serviceurl=url+apiurl;
			}
			@Test
			{
				restclient=new RestClient();
				ObjectMapper obj=new ObjectMapper();
			    Data data=new Data("abc","leader");
			    obj.writeValue(new File("C:\\eclipse\\restapi\\src\\main\\java\\com\\qa\\data\\jsondata"), data);
			    
			}

}
