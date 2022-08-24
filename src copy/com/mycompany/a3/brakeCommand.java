package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class brakeCommand extends Command{
	private GameWorld gw;
	
	public brakeCommand(GameWorld gw) {
			super("Brake");
			this.gw = gw;
			
	}
			
	 //makes the ant slow down
			public void actionPerformed (ActionEvent ev) {
				gw.brake();
				gw.notifyObservers(gw.getCollection());
			}
		}