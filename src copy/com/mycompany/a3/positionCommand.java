package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class positionCommand extends Command {
	//private GameWorld gw;
	private MapView mv;
	public positionCommand(GameWorld gw,MapView mv) {
		// TODO Auto-generated constructor stub
		super("Position");
		//this.gw = gw;
		this.mv= mv;
	}
	public void actionPerformed(ActionEvent e)
	{
		//if (gw.getPause()) {
			mv.turnOnPosition();
		
	
		//gw.notifyObservers(gw.getCollection());
	}
}
