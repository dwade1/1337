package mainGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Networking hardware for the player, as well as the computers. The
 * strength of the network will determine how fast network operations (e.g.
 * uploading/downloading files, connecting to servers, etc) will complete
 */

public class Network {

	// Used to store the current network speeds
	private double uploadSpeed;
	private double downloadSpeed;

	// Used to store the possible speeds, making it easier to upgrade
	private ArrayList<Double> uploadSpeeds = new ArrayList<Double>(Arrays.asList(0.05, 0.1, 1.0, 10.0, 100.0));
	private ArrayList<Double> downloadSpeeds = new ArrayList<Double>(Arrays.asList(.512, 1.0, 10.0, 100.0, 1000.0));

	// Tracks the ability for upgrades
	private boolean canUpgrade = true;

	// Tier of hardware that is currently available, and its maximum
	private int tier = 1;
	private int maxTier = 5;
	private ArrayList<String> tierNames = new ArrayList<String>(Arrays.asList("Dialup", "DSL", "DOCSIS", "Broadband", "Gigabit"));
	private String tierName = tierNames.get(0);
	// TODO: Add requirements to tiers

	/**
	 * Creates an instance of Network with the default settings
	 */
	public Network() {
		uploadSpeed = uploadSpeeds.get(tier - 1);
		downloadSpeed = downloadSpeeds.get(tier - 1);
	}
		/**
		 * Returns the upload speed
		 * @return upload speed of the current network
		 */
	public double getUploadSpeed() {

		return uploadSpeed;
	}
		/**
		 * Returns the download speed
		 * @return download speed of the current network
		 */
	public double getDownloadSpeed() {

		return downloadSpeed;
	}
		/**
		 * Returns the tier of hardware the player currently has
		 * @return current tier of the Network
		 */
	public int getTier() {

		return tier;
	}
		/**
		 * Upgrades the hardware that the player currently has, if it's
		 * possible, and updates the rest of the values to match
		 */
	public void upgrade() {

		if (canUpgrade) {
			tier++;
			//Sets canUpgrade to false if the player is at max tier
			if (tier == maxTier) {
				canUpgrade = false;
			}
			uploadSpeed = uploadSpeeds.get(tier - 1);
			downloadSpeed = downloadSpeeds.get(tier - 1);
			tierName = tierNames.get(tier-1);
		}
	}
	@Override
	public String toString(){
		return tierName + " [" + (int)downloadSpeed + " / " + (int)uploadSpeed + " Mbps]";
	}
}
