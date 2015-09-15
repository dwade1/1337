package mainGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A server is a game object that the player will connect to and interact with
 * It will have different port to connect to, with each one having a different purpose
 *
 */
public class Server {
	 //COMMON PORTS: http://packetlife.net/media/library/23/common_ports.pdf
	
	//Ports that are open on the server
	private ArrayList<Port> openPorts = new ArrayList<Port>();
	private String ip;
	private String hostName;
	//TODO: Add a player server that can be upgraded
	
	/**
	 * Creates a new Server with default values
	 */
	public Server(){
		ip = "0.0.0.0";
		hostName = "Default Server";
	}
	/**
	 * Creates a Server with custom parameters
	 * @param name Name of the server
	 * @param address Ip of the server
	 */
	public Server(String name, String address){
		hostName = name;
		ip = address;
	}
}
