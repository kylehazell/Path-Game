package com.mycompany.a3;



import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;


public class helpCommand extends Command {
	
	 // constructor
	 	
	public helpCommand(GameWorld gw) {
		super("help");
	}
	
	 // creates dialog box which shows key inputs in game
	
	@Override
	public void actionPerformed (ActionEvent ev) {
		Command ok = new Command("OK");
		String info = ""
				+ "a = Accelerate\n"
				+ "b = Brake\n"
				+ "l = Left turn\n"
				+ "r = Right turn\n"
				+ "f = Collide with foodstation\n"
				+ "g = Colide with spider\n"
				+ "t =  Makes the the clock tick"
				+ "  1-9 : Collide with Flag \n";
		Dialog.show("Help Page ", info, ok);
	
	}
}