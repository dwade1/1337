package mainGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * HTML file that holds the content of a page, as well as another couple
 * commands
 *
 */
public class WebPage{

	private File page;
	private String siteName;
	private String fileName;
	private String path;
	private boolean isInteractive;
	private final String DEFAULT_STRING = "<html><p> Add contents here </p></html>";

	/**
	 * Creates a new webpage for a given site based on the contents of a file
	 * 
	 * @param siteName
	 *            Name of the site that the page is hosted on
	 * @param fileName
	 *            Name of the file that the page was created in
	 * @param isInteractive
	 *            Handles whether or not the page is static, or changes when a
	 *            command is entered
	 * @throws IOException 
	 */

	public WebPage(String siteName, String fileName, boolean isExisting) throws IOException {
		this.siteName = siteName;
		this.fileName = fileName;
		path = System.getProperty("user.dir") + "/websites/" + siteName + "/";
		
		//Creates a static file with generic content
		if (!isExisting) {
			new File(path + fileName).createNewFile();
			createGenericPage();
			isInteractive = false;
			
		}
		
		//Creates a new object with an existing file
		else{
			page = new File(path);
			Scanner file = new Scanner(page);
			isInteractive = file.nextLine().equals("true"); file.close(); //Uses a scanner to get the header, which says if the file is interactive or not
			
		}
	}
	/**
	 * Fills the page with a generic string ("Add contents here")
	 * @throws IOException
	 */
	private void createGenericPage() throws IOException {
		FileOutputStream pageStream = new FileOutputStream(page, false);
		pageStream.write(DEFAULT_STRING.getBytes());
		pageStream.close();
	}
	
	/**
	 * Returns the current page's content as a list of strings, in order to print it out easier in a JApplet window
	 * @return The current page's content as a list of strings
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> getPageAsList() throws FileNotFoundException{
		//List of lines of the file that's being translated
		ArrayList<String> pageLines = new ArrayList<String>();
		Scanner file = new Scanner(page);
		
		//Takes the file and cuts it into lines, with each one being added to a list
		while(file.hasNextLine()){
			pageLines.add(file.nextLine());
		}
		
		return pageLines;
	}
	
	@Override
	public boolean equals(Object object){
		return this.toString().equals(object.toString());
	}
	

}
