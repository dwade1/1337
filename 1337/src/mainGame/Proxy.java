package mainGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A proxy slows down the tracing of the player The higher level the proxy,
 * the harder it is to be traced
 */
public class Proxy {

	private ArrayList<Double> delays = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 5.0, 10.0));
	private double delay;
	private int tier = 1;
	private String ip;
	
	/**
	 * Creates an instance of Proxy with default settings
	 */
	public Proxy(){

		delay = delays.get(0);
		ip = "0.0.0.0";
	}
	
	@Override
	/**
	 * Returns a representation of the proxy
	 */
	public String toString(){

		return "Proxy level: " + tier + "[" + ip +"]";
	}
}
