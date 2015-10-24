package mainGame;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A website is a collection of pages that will be used to display content
 *
 */
public class Website {
	
	//Used for navigation within the site
	private WebPage currentPage;
	private WebPage previousPage;
	
	private ArrayList<WebPage> pages; //List of webpages that are associated with the site
	private String siteName;
	private String workingDirectory = System.getProperty("user.dir") + "/websites/"; //Sets the working directory to where the websites are located
	
	/**
	 * Uses a file in order to load the content of a website
	 * @param siteName Name of the site
	 * @param isExisting Determines if the site was previously created, or is completely new
	 * @throws IOException 
	 */
	public Website(String siteName, boolean isExisting) throws IOException{
		
		pages = new ArrayList<WebPage>();
		
		//A completely new site is being created
		if(isSiteAvailable(siteName) && !isExisting){	
			new File(workingDirectory + "siteName").mkdirs(); //Creates a new folder to store webpages
			pages.add(new WebPage(siteName, "index", false)); //Creates a blank index page and adds it to the site
		}
		
		//The website is already created, and is being loaded
		else if(isSiteAvailable(siteName) && isExisting){
			
			String workingDirectory = System.getProperty("user.dir") + "/websites/" + siteName;
			File directory = new File(workingDirectory);
			for(File file: directory.listFiles()){
				pages.add(new WebPage(siteName, file.getName(), true));
			}
		}
		
		//Sets the current page and previous page to the index
		currentPage = pages.get(pages.indexOf("index"));
		previousPage = currentPage;
	}
	
	/**
	 * Checks to see if the site hasn't already been created. Currently only in local use
	 * @param siteName Site that is being searched for
	 * @return Whether or not the site has already been created
	 */
	private boolean isSiteAvailable(String siteName){
		File dir = new File(System.getProperty("user.dir"));
		for(File file: dir.listFiles()){
			if(file.getName().equals(siteName)){
				return false;
			}
		}
		return true;
	}
}
