package restapi;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.Testbase;
import com.qa.client.RestClient;

public class Apitest extends Testbase
{
	String url;
	String apiurl;
	String serviceurl;
	CloseableHttpResponse httpresponse;
	
	public Apitest() throws IOException, JSONException 
	{
		super();
	}
	@BeforeMethod
	public void urlcreation() 
	{
		url=prop.getProperty("URL");
		apiurl=prop.getProperty("serviceurl");
		serviceurl=url+apiurl;
	}
	@Test
	public void  test1() throws ClientProtocolException, IOException, JSONException 
	{
	RestClient obj=new RestClient();
	httpresponse=obj.get(serviceurl);
 
	int statuscode=httpresponse.getStatusLine().getStatusCode();
	System.out.println(statuscode);
		
	Assert.assertEquals(statuscode, 200,"status code is not 200");
	
	String resposnsestring=EntityUtils.toString(httpresponse.getEntity(),"UTF-8");
	System.out.println(resposnsestring);
	
	JSONObject responseJson=new JSONObject(resposnsestring.trim());
	System.out.println(responseJson);
	
	int pagevalue=(Integer)responseJson.get("page");
	System.out.println(pagevalue);	
	int per_page=(Integer)responseJson.get("per_page");
	System.out.println(per_page);
	int total=(Integer)responseJson.get("total");
	System.out.println(total);
	int total_pages=(Integer)responseJson.get("total_pages");
	System.out.println(total_pages);
	
	Header[] headers=httpresponse.getAllHeaders();	
	HashMap<String, String> map=new HashMap<String, String>();
	for(Header head : headers)
		map.put(head.getName(), head.getValue());
	System.out.println(map);

	JSONArray arr = responseJson.getJSONArray("data");
    for (int i = 0; i < arr.length(); i++) 
    {
        String id = arr.getJSONObject(i).getString("id");
        String email = arr.getJSONObject(i).getString("email");
        String first_name = arr.getJSONObject(i).getString("first_name");
        String last_name = arr.getJSONObject(i).getString("last_name");
        String avatar = arr.getJSONObject(i).getString("avatar");
        System.out.println(id);
        System.out.println(email);
        System.out.println(first_name);
        System.out.println(last_name);
        System.out.println(avatar);
    }
    

  }
}