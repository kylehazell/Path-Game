package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class rightCommand  extends Command {
private GameWorld gw;
	
		 // this steers the ant right

	public rightCommand(GameWorld gw) {
		super("Right");
		this.gw = gw;
	}

	public void actionPerformed (ActionEvent ev) {
				gw.rightT();
				gw.notifyObservers(gw.getCollection());
			}
}