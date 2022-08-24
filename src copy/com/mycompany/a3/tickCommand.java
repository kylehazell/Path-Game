package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class tickCommand extends Command {
	private GameWorld gw;
	
	public tickCommand(GameWorld gw) {
		super("tick");
		this.gw = gw;
	}
	// makes clock tic
	public void actionPerformed(ActionEvent event) {
		//gw.tick();
		gw.notifyObservers(gw.getCollection());
		
		
	}
}	