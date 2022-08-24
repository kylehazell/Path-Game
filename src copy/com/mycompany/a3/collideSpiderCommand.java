package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class collideSpiderCommand  extends Command {
	private GameWorld gw;
	
	public collideSpiderCommand (GameWorld gw) {
		super("Collide with Spider");
		this.gw = gw;
	}
	//collides spider with ant 
	public void actionPerformed(ActionEvent event) {
	//	gw.spiderCAnt();
		gw.notifyObservers(gw.getCollection());
	}
	

}