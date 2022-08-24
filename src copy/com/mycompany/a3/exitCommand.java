package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class exitCommand extends Command {

	public exitCommand() {
		super("exit");
	}
	// exist the game
	public void actionPerformed(ActionEvent event) {
		boolean exit = Dialog.show("Exit", "Do you want to exit out of the game?", "Exit", "Cancel");
		if(exit) {
			System.exit(0);
		}	
		
	}
}
