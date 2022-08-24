package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;


public class aboutCommand extends Command {
	

	
	 
	public aboutCommand(GameWorld gw) {
		super("about");
	}
	
	 // creates a dialog box of what the program is about
	 

	public void actionPerformed (ActionEvent ev) {
	
		Command ok = new Command("ok");
		String info = "Kyle Hazell \n CSC133 \n  welcome the the path game 2.0 \n";
		Dialog.show("Welcome to the  about page click info below for more information", info, ok);
		

}
}