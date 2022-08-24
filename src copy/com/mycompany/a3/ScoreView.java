package com.mycompany.a3;

import java.util.Observer;
import java.util.Observable;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
public class ScoreView extends Container implements Observer { 
	
private Label lives, clock, lastFlagReached, foodLevel, healthLevel  , sound ;
		//populates the score on tool bar
	public ScoreView() {
					this.clock = new Label("Time: ");
					this.clock.getAllStyles().setFgColor(ColorUtil.BLUE);
					//this.clock.getAllStyles().setPadding(RIGHT, 2);
					this.add(clock);
					
					
					this.lives = new Label("Lives Left:	");
					this.lives.getAllStyles().setFgColor(ColorUtil.BLUE);
					this.add(lives);
					
					this.lastFlagReached = new Label("Last Flag Reached:	");
					this.lastFlagReached.getAllStyles().setFgColor(ColorUtil.BLUE);
					this.add(lastFlagReached);
					
					this.foodLevel = new Label("Food Level:		");
					this.foodLevel.getAllStyles().setFgColor(ColorUtil.BLUE);
					this.add(foodLevel);
					
					this.healthLevel = new Label("Health Level:	 ");
					this.healthLevel.getAllStyles().setFgColor(ColorUtil.BLUE);
					this.add(healthLevel);
					
					this.sound = new Label("Sound:	 ");
					this.sound.getAllStyles().setFgColor(ColorUtil.BLUE);
					this.add(sound);
						
					this.setLayout(new FlowLayout(CENTER));
					
					
					
					
					
				
}
	
	
	
	
	
	
	
	public void update (Observable o, Object arg) { 
		// code here to update labels from the game/ant state data  
		GameWorld gw = (GameWorld) o;
		Ant ant = Ant.getAnt();
		
		clock.setText("Time:	" + gw.getClock());
		lives.setText("Lives Left:	 " + gw.getLives()); 
		lastFlagReached.setText("Last Flag Reached:	  " + ant.getlastFlagReached()); 
		foodLevel.setText("Food Level:		" + ant.getFoodLevel()); 
		healthLevel.setText("Health Level:	 " + ant.getHealthLevel()); 
		
		if (gw.getSound()) {
			
			sound.setText("Sound:	 " + "ON");
		} 
		else {
			
			sound.setText("Sound:	 " + "OFF");
		}
		
		System.out.println("---------------");
		
	}
	}

