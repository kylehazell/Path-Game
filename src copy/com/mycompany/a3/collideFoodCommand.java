package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class collideFoodCommand extends Command {
	private GameWorld gw;
	
	public collideFoodCommand(GameWorld gw) {
		super("Collide with Food Stations");
		this.gw = gw;
	}
	//makes ant collide with food station
	public void actionPerformed(ActionEvent event) {
		//gw.foodStationCollision();
		gw.notifyObservers(gw.getCollection());

	}
}