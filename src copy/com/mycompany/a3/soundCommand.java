package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;
import com.codename1.ui.CheckBox;
public class soundCommand extends Command {
	private CheckBox soundCheck;
	private GameWorld gw;
	public soundCommand(GameWorld gw, CheckBox soundD) {
		// TODO Auto-generated constructor stub
		super("Sound ON/OFF");
		this.gw = gw;
		this.soundCheck = soundD;
	}
//	turns sound off and on 
	public void actionPerformed(ActionEvent event)
	{
		if (soundCheck .isSelected())
		{
			System.out.println("Sound turned on");
			gw.setSound(true);
			gw.notifyObservers(gw.getCollection());
		}
		else
		{
			System.out.println("Sound turned off");
			gw.setSound(false);
			gw.notifyObservers(gw.getCollection());
		}
	}
}
