package newsAutomation;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import utils.FrameworkProperties;

public class GetData {
	
	public static JSONArray makeRequest() throws IOException, InterruptedException {
		/*Makes request to API and returns a JSON Formatted Array */
		
		FrameworkProperties props = new FrameworkProperties();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://bing-news-search1.p.rapidapi.com/news/trendingtopics?setLang=en&textFormat=Raw&safeSearch=Off"))
				.header("X-BingApis-SDK", "true")
				.header("X-RapidAPI-Key", props.getProperty("API_KEY"))
				.header("X-RapidAPI-Host", "bing-news-search1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		  
		JSONObject body = new JSONObject(response.body());
		
		JSONArray data = new JSONArray(body.get("value").toString());
		
		
		return data;
		
		
		
	}
	
	
	public static ArrayList<String> getData(String key, JSONArray data) {
		/* Will look into the JSONArray  */
		ArrayList<String> results = new ArrayList<String>();
		
		try {
			
			for (int i =0; i < data.length(); i++) {
				results.add((String) data.getJSONObject(i).get(key));
				
			}
			
		} catch(Exception e) {
			System.out.println("Key not found");
			
		}
		
		return results;

	
	}
	

}
