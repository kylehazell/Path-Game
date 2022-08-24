package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideFlagCommand extends Command {
	private GameWorld gw;
	
	
	public CollideFlagCommand(GameWorld gw) {
		super("Collide with Flags");
		this.gw = gw;
	}
	// helps the user stay inbounds when choosing a flag
	public void actionPerformed(ActionEvent event) {
		Command ok = new Command("OK");
		TextField flagChoice = new TextField();
		Dialog.show("Enter Number :  ", flagChoice, ok);
		int  flagNum = Integer.parseInt(flagChoice.getText());
		
		
		if (flagNum >= 1 && flagNum <= 9 ) {
			gw.antHitFlag(flagNum);
			gw.notifyObservers(gw.getCollection());
		} 
		else {
			System.out.println("Please Enter Valid Number from 1 to 9 : ");
			boolean wrongResponse = true;
			while(wrongResponse) {
				Command ok1 = new Command("OK");
				TextField numberError = new TextField();
				Dialog.show("Please Enter Valid Number from 1 to 9 :  ", numberError, ok1);
				flagNum = Integer.parseInt(numberError.getText());
				
				if (flagNum >= 1 && flagNum  <= 9) {
					gw.antHitFlag(flagNum) ;
					gw.notifyObservers(gw.getCollection());
					wrongResponse= false;
				} 
				else {
					wrongResponse = true;
				}
			}
			
		}
	}
}
