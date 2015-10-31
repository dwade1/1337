package mainGame;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class Header {
	private JButton playerIcon, proxies, shop, jobs;
	private Label playerInfo;
	private Player player;
	
	public Header(Container container, GridBagConstraints constraints, ActionListener listener, Player player){
		
		//Creates the player icon in the top right corner
		playerIcon = new JButton();
		playerIcon.addActionListener(listener);
		playerIcon.setActionCommand("load PlayerWindow");
		constraints.fill = GridBagConstraints.BOTH; //Allows the icon to be scaled horizontally and vertically
		constraints.gridx = 0; //Sets the x position
		constraints.gridy = 1; //Sets the y position
		container.add(playerIcon, constraints); //Adds the player icon to the pane
		
		//Creates a Label to display player information
		//"Name: " + player.getName() + "\n" + "Rank: " + player.getRank() + "\n" + player.getCash()
		playerInfo = new Label();
		constraints.gridy = 1;
		container.add(playerInfo, constraints);
		
		//Creates a Proxy button that displays proxy info and will go to the setup page when pressed
		proxies = new JButton();
		proxies.addActionListener(listener);
		//TODO: add proxy information to player, so it can be pulled here
		proxies.setActionCommand("load Proxies");
		constraints.gridx = 1;
		constraints.gridy = 0;
		container.add(proxies, constraints);
		
		//Creates a shop button to take the player to the shop screen
		shop = new JButton();
		shop.addActionListener(listener);
		constraints.gridx = 2;
		container.add(shop, constraints);
		
		//Creates a job button to take the player to the job screen
		jobs = new JButton("Jobs");
		jobs.addActionListener(listener);
		constraints.gridx = 3;
		container.add(jobs, constraints);
		
		//TODO: Add context specific buttons (Consoles on home screen, other information on other pages)
	}
	
	private void update(){
		playerInfo.setText(generatePlayerInfo());
		proxies.setText(generateProxyInfo());
		//TODO: Update context buttons
	}
	
	private String generatePlayerInfo(){
		
		String name = player.getName();
		String rank = String.valueOf(player.getRank());
		String cash = String.valueOf(player.getCash());
		
		return "Name: " + name + "\n" + "Rank: " + rank + "\n" + "Cash: " + cash;
	}
	
	private String generateProxyInfo(){
		return "Proxies: 0 \n Offline";
	}
}
