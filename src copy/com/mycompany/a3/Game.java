package com.mycompany.a3;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Label; 
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent; 
import com.codename1.ui.CheckBox;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;

import java.util.Observer;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */

public class Game extends Form implements  Runnable{
	   
		private GameWorld gw; 
		private MapView mv;     
		private ScoreView sv;   	
		private UITimer timer;
		private rightCommand rightCommand;
		private SetButton right;
		private brakeCommand brakeCommand;
		private SetButton brake;
		private accelerateCommand aCommand;
		private SetButton accelerate;
		private leftCommand lCommand;
		private SetButton left;
		private PauseCommand pCommand;
		private SetButton pause;
		private boolean isPaused = false;
		
public Game(){ 
		gw = new GameWorld();             // create “Observable” GameWorld 
		mv = new MapView();     // create an “Observer” for the map
		sv = new ScoreView();            // create an “Observer” for the game/ant state data
		gw.addObserver(mv);              // register the map observer 
		gw.addObserver(sv);
		
		gw.init();
		//Top of IPad-------------------------------------------------------------
		Toolbar myToolbar = new Toolbar();
		this.setToolbar(myToolbar);	
		Container bottomButtons = new Container();
		bottomButtons.setLayout(new FlowLayout(CENTER));
		Label title = new Label("The Path ");		
		myToolbar.setTitleComponent(title);
		//////exit command///
		exitCommand exit = new exitCommand();
		myToolbar.addCommandToSideMenu(exit);
		///////sound button///
		CheckBox soundOn= new CheckBox ("Sound");
		soundOn.getAllStyles().setBgTransparency(255);
		soundOn.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundCommand sound = new soundCommand(gw,soundOn);
		soundOn.setCommand(sound);
		myToolbar.addComponentToSideMenu(soundOn);
		
		
		///////////about button//////
		aboutCommand about = new aboutCommand(gw);
		myToolbar.addCommandToSideMenu(about);
		helpCommand help = new helpCommand(gw); 
		myToolbar.addCommandToRightBar(help);	
		myToolbar.addCommandToSideMenu(help);
		this.setLayout(new BorderLayout());
		
		mv.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255,0,0)));
		this.add(BorderLayout.CENTER, mv);
		this.add(BorderLayout.NORTH, sv);
		
		gw.addObserver(mv);
		gw.addObserver(sv);
		//End of top of IPad-------------------------------------------------------------
		
		
		//Right side of IPad-------------------------------------------------------------
		Container rightSideButtons = new Container();
				rightSideButtons.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
				rightSideButtons.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.GRAY));
				rightSideButtons.getAllStyles().setBgColor(ColorUtil.BLUE);
			//Right turn button///////////////
				rightCommand = new rightCommand(gw);
				 right = new SetButton("right");
				right.setCommand(rightCommand);
				rightSideButtons.add(right);
				addKeyListener('r', rightCommand);				
				//Break button ////////////////
				brakeCommand = new brakeCommand(gw);
				 brake = new SetButton("break");
				brake.setCommand(brakeCommand);
				rightSideButtons.add(brake);
		
				
				this.add(BorderLayout.EAST, rightSideButtons);
		//End of right side of IPad---------------------------------------------------------
				
		
				//Left side of IPad--------------------------------------------------------
				Container LeftSideButtons = new Container();
				LeftSideButtons.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
				LeftSideButtons.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.GRAY));
				LeftSideButtons.getAllStyles().setBgColor(ColorUtil.BLUE);
				
				//accelerates ant
				 aCommand = new accelerateCommand(gw);
				 accelerate = new SetButton("accelerate");
				accelerate.setCommand(aCommand);
				LeftSideButtons.add(accelerate);
				myToolbar.addCommandToSideMenu(aCommand);
				
				
				//creates the turn Left command left button	
			    lCommand = new leftCommand(gw);
				left = new SetButton("left");
				left.setCommand(lCommand);
				LeftSideButtons.add(left);
				
				this.add(BorderLayout.WEST, LeftSideButtons);
				//End of left side of IPad---------------------------------------------------------
				
				
				//Bottom of IPad-------------------------------------------------------------
							

						
				///creates the collide with flag
				pCommand = new PauseCommand(this);
				pause= new SetButton("pause");
				pause.setCommand(pCommand);
				bottomButtons.add(pause);
				addKeyListener('p',  pCommand );
					
				//creates the collide with FoodStation button
				positionCommand pos = new positionCommand(gw,mv);
				SetButton possec = new SetButton(" Position");
				possec.setCommand(pos);
				bottomButtons.add(possec);
				addKeyListener('f',  pos);
				
				
				this.add(BorderLayout.SOUTH, bottomButtons);
				
				//Bottom of IPad-------------------------------------------------------------
				
	   	
		gw.notifyObservers(gw.getCollection());
		
		this.show();
		gw.createSound();
		revalidate(); 
		gw.setHeight(mv.getHeight());
		gw.setWidth(mv.getWidth());
		startGame();
		// code here to query MapView’s width and height and set them as world’s     
		// width and height
		
		// initialize world 
		}



@Override
public void run() {
	// TODO Auto-generated method stub
	Dimension dCmpSize= new Dimension(mv.getWidth(), mv.getHeight());
	gw.tick(dCmpSize,1000 );
	//mv.repaint();
	gw.notifyObservers(gw.getCollection());
}

	public void pauseGame() {
		// TODO Auto-generated method stub
		timer.cancel();
		this.setPaused(true);
		mv.setMVP(true);
		accelerate.setEnabled(!accelerate.isEnabled());
		brake.setEnabled(!brake.isEnabled());
		left.setEnabled(!left.isEnabled());
		right.setEnabled(!right.isEnabled());
		removeKeyListener('a', aCommand);
		removeKeyListener('r', rightCommand);
		removeKeyListener('l', lCommand);
		removeKeyListener('b', brakeCommand);
		pause.setText("Play");
		
		gw.getBGSound().pause();
		
	} 



public boolean paused() {
	// TODO Auto-generated method stub
	return isPaused; 
} 
public void setPaused(boolean isPaused ) {
	// TODO Auto-generated method stub
	this.isPaused= isPaused;
} 


public void startGame() {
	// TODO Auto-generated method stub
	
	timer = new UITimer(this);
	timer.schedule(300, true, this);	
	pause.setText("Pause");
	this.setPaused(false);
	accelerate.setEnabled(accelerate.isEnabled());
	brake.setEnabled(brake.isEnabled());
	left.setEnabled(left.isEnabled());
	right.setEnabled(right.isEnabled());
	addKeyListener('a', aCommand);
	addKeyListener('r', rightCommand);
	addKeyListener('l', lCommand);
	addKeyListener('b', brakeCommand);
	 if (gw.getSound())
	gw.getBGSound().play();
} 


} 
