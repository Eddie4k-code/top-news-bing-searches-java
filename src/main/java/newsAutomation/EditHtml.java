package newsAutomation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.ArrayList;

public class EditHtml {
	
	
	
	public static void editHtml(ArrayList<String> names, ArrayList<String> urls) {
		
		/*Edits an HTML File and writes the trending news topics from bing to it*/
		
		File f = new File("News.html");
		
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			
			for (int i = 0; i < names.size(); i++) {
				String html = MessageFormat.format("<ul><h1> {0} </h1> <li><a href={1}>Link</a></li></ul>", names.get(i), urls.get(i));
				bw.write(html);
			}
			
			
			bw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	
	
	
	
}
