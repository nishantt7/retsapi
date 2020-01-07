package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {

	//Get method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException, JSONException 
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse httpresponse=httpclient.execute(httpget);
		return httpresponse;
	}
	
	//post method
	public CloseableHttpResponse post(String url,String entityString,HashMap<String, String>headermap) throws ClientProtocolException, IOException, JSONException 
	{
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpPost httppost=new HttpPost(url);
		httppost.setEntity(new StringEntity(entityString)); //define payload
		CloseableHttpResponse httpresponse=httpclient.execute(httppost);
		return httpresponse;
	}
}
