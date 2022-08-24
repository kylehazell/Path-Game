package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class accelerateCommand extends Command {
	private GameWorld gw;
	
	 // constructor
	 
	
	public accelerateCommand(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	 // Accelerates the players ant
	 
	@Override
	public void actionPerformed (ActionEvent ev) {
		gw.accelerate();
		gw.notifyObservers(gw.getCollection());
	}
}