package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class leftCommand extends Command {
	private GameWorld gw;

	
	 
	public leftCommand(GameWorld gw) {
		super("Left");
		this.gw = gw;
	}
	
	 // steers the ant left
	
	@Override
	public void actionPerformed (ActionEvent ev) {
		gw.leftT();
		gw.notifyObservers(gw.getCollection());
	}
}