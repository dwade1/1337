package mainGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A processor is a game object that effects the time it takes to perform local
 * tasks, such as password breaking
 */
public class Processor {

	// Stores the current clock speed, as well as all possible clock speeds
	private double clockSpeed;
	private ArrayList<Double> clockSpeeds = new ArrayList<Double>(Arrays.asList(1.4, 2.4, 3.4, 4.2));

	// Stores the current tier, as well as the maximum tier and names of the
	// tiers
	private int tier = 1;
	private int maxTier = 4;
	private ArrayList<String> tierNames = new ArrayList<String>(
			Arrays.asList("Excel Bronze", "Excel Silver", "Excel Gold", "Excel Platinum"));
	private String tierName = tierNames.get(0);

	/**
	 * Creates an instance of Processor with default settings
	 */
	public Processor() {

		clockSpeed = clockSpeeds.get(tier - 1);

	}

	/**
	 * Returns the current tier of the processor
	 * 
	 * @return Current tier of the processor
	 */
	public int getTier() {

		return tier;
	}

	/**
	 * Upgrades the processor, if it's not at the max level
	 */
	public void upgrade() {

		if (tier != maxTier) {
			tier++;
			tierName = tierNames.get(tier - 1);
		}
	}

	@Override
	/**
	 * Returns a representation of the Processor
	 */
	public String toString() {

		return tierName + "[" + clockSpeed + "]";
	}
}
