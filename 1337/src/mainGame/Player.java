package mainGame;
import java.util.ArrayList;
public class Player {
	
	private Processor processor;
	private Network network;
	private double cash;
	private String name;
	private int Rank;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Processor getProcessor() {
		return processor;
	}
	public Network getNetwork() {
		return network;
	}
	public double getCash() {
		return cash;
	}
	public int getRank() {
		return Rank;
	}
	
	
}
