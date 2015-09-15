package mainGame;

import java.util.Comparator;

/**
 * 
 * Contains a port that is either open or closed, and has a type - which is
 * related to the function of the port
 *
 */
public class Port {

	/*
	 * Type of server. CURRENT SUPPORTED TYPES:  Website
	 * 
	 */
	//TODO: Add more types of ports
	
	private int port;
	private String type;
	private boolean isOpen;

	// Holds the content of the server (Object, because it depends on the type
	// of server
	private Object content;

	/**
	 * Creates an empty port that does nothing
	 */
	public Port() {
		port = 0;
	}
	
	/**
	 * Creates a specific type of port
	 * @param ty the type of port
	 */
	public Port(String ty){
		switch(ty.toLowerCase()){
		case "website":
			content = new Website();
			break;
		}
	}
	
	public int getPort() {
		return port;
	}

	
	
	/**
	 * Helper class that will allow sorting by port number
	 */
	public class portCompare implements Comparator<Port> {

		@Override
		public int compare(Port p1, Port p2) {
			if (p1.getPort() > p2.getPort()) {
				return 1;
			}
			if (p2.getPort() < p2.getPort()) {
				return -1;
			}
			return 0;
		}
	}
}
