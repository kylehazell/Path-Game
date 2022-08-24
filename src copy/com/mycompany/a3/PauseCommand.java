package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;

public class PauseCommand extends Command {
	private Game g;
	
	public PauseCommand(Game game) {
		// TODO Auto-generated constructor stub
		super("Pause");
		this.g = game;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(!g.paused()) {
			g.pauseGame();
		}
		else {
			g.startGame();
		}
	}
	
	
}
