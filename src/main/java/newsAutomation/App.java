package newsAutomation;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	
		
		//Make request to Bing Search Rapid API
		JSONArray allData = GetData.makeRequest();
		
		
		//Names of trending news searches/articles
		ArrayList<String> names = new ArrayList<String>(GetData.getData("name", allData));
		
		
		//All Links for the results
		ArrayList<String> links = new ArrayList<String>(GetData.getData("newsSearchUrl", allData));
		
		//Write to HTML
		EditHtml.editHtml(names, links);
	}

}
