package com.mycompany.a3;

import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.ui.geom.Dimension;
import com.mycompany.a3.Spider;
import com.mycompany.a3.FoodStation;
import com.mycompany.a3.GameObject;

import java.util.Observable;


	
	// TODO: Auto-generated Javadoc

	/**
	 * The Class GameWorld.
	 */
public class GameWorld extends Observable { 
	
	private GameObjectCollection gObj;
	private int lives = 3, clock = 0;
	private int flags ;
	private int numFlags = 4;
	private boolean sound;
	private static double height;
	private static double width;
	private Sound flagSound;
	private Sound foodSound;
	private Sound spiderSound;
	private BGSound bgSound;
	private Sound lwSound;
	private boolean position;
	private boolean pause;
	
	
	public void Position() {
		if (position == true)
			position = false;
		else
			position = true;
	}
	
	public void disablePosition() {
		position = false;
	}
	
		
	public GameWorld() {
		
		gObj= new GameObjectCollection();
		this.clock= 0;
		this.lives= 3;
		this.sound=true;
		this.height = 0;
		this.width = 0;
		
		
	}
	public void setPause(boolean newPause) {
		pause = newPause;
	}
	public boolean getPause() {
		return pause;
	}
	public boolean getSound() {
		return sound;
	}
	public BGSound getBGSound()
	{
	return 	bgSound;
	}
	public void setBGSound(BGSound s)
	{
		this.bgSound =   s;
	}
	public void setSound(boolean sound) {
		this.sound = sound;
		this.setChanged();
		
		this.notifyObservers(this);
	}
	public int getClock() {
		return clock;
	}

	public void setClock(int clock) {
		this.clock = clock;
	}
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	/*public void pointpress(Point clickPoint, Point originalPoint) {
		IIterator tempObject = gameObjects.getIterator();
		while(tempObject.hasNext()) {
			if(tempObject.getNext() instanceof Fixed) {
				Fixed temp = (Fixed)tempObject.getCurrent();
				if(position && temp.isSelected()) {
					int newX = clickPoint.getX() - originalPoint.getX();
					int newY = clickPoint.getY() - originalPoint.getY();
					temp.setLocation(newX, newY);
					position = false;
					temp.setSelected(false);
				} else {	
					if(temp.contains(clickPoint, originalPoint)) 
						temp.setSelected(true);
					 else 
						temp.setSelected(false);
				}
			}
		}
		this.setChanged();
		this.notifyObservers(this);
	}*/
	
	public void init(){ //code here to create the initial game objects 
		

		
		
		popFlags();
		popAnt();
		popSpider();
		popFoodStations();
		this.setChanged();
		notifyObservers();
		
		
	} 
		// additional methods here to manipulate game objects and related game state data
	public void popFlags() {
		Random r = new Random();
		float locX = r.nextInt(1000);
		float locY = r.nextInt(1000);
	
		gObj.add(new Flag(getWidth(),getHeight(),60,222,100,1));
		gObj.add(new Flag(getWidth(),getHeight(),60,222,1000,2));
		gObj.add(new Flag(getWidth(),getHeight(),60,1200,1000,3));
		gObj.add(new Flag(getWidth(),getHeight(),60,1200,100,4));
		numFlags= 4;
		System.out.println(numFlags);
		
		this.setChanged();
				
	}
	//makes ants
	public void popAnt() {
		Ant ant = Ant.getAnt();
		gObj.add(ant);
		ant.setWidth(getWidth());
		ant.setHeight(getHeight());
		this.setChanged();
		
	}
	//makes spiders
	public void popSpider() {
		Random r = new Random();
		float locX = r.nextInt(2000);
		float locY = r.nextInt(1200);
		 int  sze = r.nextInt(60-30)+30;
		 int size = sze;
		Spider spider1 =new Spider(getWidth(),getHeight(),r.nextInt(2000),r.nextInt(1200),size,255,255,0);
		Spider spider0 =new Spider(getWidth(),getHeight(),locX,locY,size,255,255,0);
		gObj.add(spider1);
		gObj.add(spider0);
		this.setChanged();
	}
	//makes food stations
	public void popFoodStations() {
		Random r = new Random();
		int  sze = r.nextInt(80-50)+50;
		 int size = sze;
		FoodStation station0 = new FoodStation(getWidth(),getHeight(),500,500,size,5,5,5);
		FoodStation station1 = new FoodStation(getWidth(),getHeight(),1000,1000,r.nextInt(80-50)+50,5,5,5);
		gObj.add(station0);
		gObj.add( station1);
		this.setChanged();
	}
	//makes ant break
	public void brake() {
		Ant ant = Ant.getAnt();
	    ant.decreaseSpeed();
	    this.setChanged();
	}
	//makes ant move fast
	public void accelerate() {
		Ant ant = Ant.getAnt();
		ant.accelerate();
		this.setChanged();
		System.out.print(getWidth()+ " "+getHeight() );
     
	 }
	//makes ant move  to the left
	public void leftT() {
		Ant ant = Ant.getAnt();	
		ant.turnLeft();
		this.setChanged();
	        }
	//makes ant move  to the right
	public void rightT() {
		Ant ant = Ant.getAnt();
		 ant.turnRight();
		 this.setChanged();
	  }
	public void foodStationCollision(FoodStation station) {  
		   // GameWorld station1;
		    // and retrieve its capacity.
					 
		Ant ant = Ant.getAnt();
	
				      if(station.isEmpty()!=true) {
				         int   capacity = station.getCapacity();
				         ant.applyFoodGain(capacity);
				         station.setColor(0, 250, 0);
				         station.setCapacity(0);
				         if (getSound())
				         foodSound.play();
				            this.setChanged();
				        }
				           else {
				        	   System.out.print("no more food Stations");
				           }
				   // foodSound.play();
				    // break;
				    }
		
	
	public void antHitFlag(int flagNum) {
	    
	    //Update necessary
	    // data members for respective objects.
		Ant ant = Ant.getAnt();
	    
	            if(flagNum == ant.getlastFlagReached() + 1 ) {
	                ant.setLastFlagReached(flagNum);
	                if (getSound())
	                flagSound.play();
	                System.out.println("Your now at flag " + flagNum);
	             if(flagNum == numFlags)
	             {
	            	 System.out.println("Game over, you win! Total time: " + clock);
	            	
	            	 System.exit(0);
	              }
	            else {
	            	System.out.println("Flag cannaot be reached yet or you might be at the flag your calling ");
	            	
	            }
	            
	        } 
	           // foodSound.play();
	            this.setChanged();
	}
	
	public void spiderCAnt(Spider s) {
		 
		Ant ant = Ant.getAnt();
	//	IIterator objectIt = gObj.getIterator();
		Random r = new Random();
		float locX = r.nextInt(2100);
		float locY = r.nextInt(1000);
		int  sze = r.nextInt(50-30)+30;
	    int size = sze;
		    
	  
			
		       
		            
		                ant.setHealthLevel(ant.getHealthLevel() - 1);
		                boolean LT = ant.lifeTest();
		                if(LT == false)
		                {	 
		                	antLives();
		                System.out.println("ant is dead");		                
		                ant.setColor(25, 0, 5);
		                ant.decreaseSpeed();
		                ((GameObjectCollection) gObj).remove(s);
		              Spider newSpider = new Spider(getWidth(),getHeight(),0,0,size,255,255,0);
		              gObj.add(newSpider);
		             
		                }
		                else {
		                	
		                	ant.setColor(135,206,235);
			                ant.decreaseSpeed();
			                gObj.remove(s);
			              Spider newSpider = new Spider(getWidth(),getHeight(),locX,locY,size,255,255,0);
			              gObj.add(newSpider);
		                	
		                }   
		                if (getSound())
		                spiderSound.play();
		                this.setChanged();
		        }
	    
		
      
	public void collsion() {
	
		IIterator iter = gObj.getIterator();
		
		// check if moving caused any collisions
		iter = gObj.getIterator();
		while(iter.hasNext())
		{
			ICollider curObj = (ICollider)iter.getNext(); 
			// get a collidable object
			// check if this object collides with any OTHER object
			IIterator iter2 = gObj.getIterator();
			while(iter2.hasNext())
			{
				GameObject otherObj = (GameObject) 
						iter2.getNext(); 
				// get a collidable object
				// check for collisiond
				if(otherObj!=curObj){
					// make sure it's not the SAME object
					if(curObj.collidesWith(otherObj)){
						curObj.handleCollision(otherObj,this);
					}
					}
				}
				}
			}
		
	
	
	
	
	
	
           
	public void antLives() {
		Ant ant = Ant.getAnt();
		lives--;
		 if (getSound())
		 lwSound.play();
		if(lives == 0)
		{
			System.out.print("Game Over You Have No More Lives!!");
			System.exit(0);
		}
		else 
		{
			System.out.print("You lost one your lives the game will now restart !!");
			gObj.clear();
			ant.clear();
			init();
			ant.setFoodLevel(600);
		}	
	}
	public void map() {
		IIterator objectIt = gObj.getIterator();
		while (objectIt.hasNext()) {
			
			GameObject recent = (GameObject)objectIt.getNext();
			System.out.println(recent.toString());
		    System.out.println();
	}
	}
	public void exit() {
		System.exit(0);
	}
	
	public void display() {
		Ant ant = Ant.getAnt();
		
	System.out.print("Lives: " + this.lives + " Clock Value: " + this.clock + " Highest Flag: " +  ant.getlastFlagReached() + " food Level: ");
	System.out.println(ant.getFoodLevel() + "  Health Level: "+ ant.getHealthLevel() );
	}
	public void tick(Dimension dCmpSize, int time) {
		
		Ant ant = Ant.getAnt();
			//increment the clock by one
		//Iterate through the game objects
		IIterator objectIt = gObj.getIterator();
		while ( objectIt.hasNext() ) { 
			GameObject recent = (GameObject)objectIt.getNext();
	    	if (recent instanceof Ant) {
	    		 //ant = (Ant)recent;
	    	      ant.Move(dCmpSize, time);
	    	      ant.setFoodLevel(ant.getFoodLevel()-1);
	    	      this.setChanged();
	    	}
	    	 
	    	else if(recent instanceof Spider) {
	 	        	Spider spider = (Spider) recent;
	 	            spider.Move(dCmpSize,time);
	 	           this.setChanged();
	    }
	    	collsion();     
	    	
	    	 } clock++;
			 boolean LT = ant.lifeTest();
             if(LT == false)
             {	 
            	 antLives();	 
             }
             this.setChanged();
     		notifyObservers();
			 
	}
	
//additional methods here to   
// manipulate world objects and   
//   related game state data


	
	
	public GameObjectCollection getCollection() {
		return this.gObj;
	}

   
	 public void setWidth(int width) {
			this.width = width; 
		}
		public void setHeight(int height) {
			this.height = height; 
		}
		public static int getWidth() {
			return (int) width; 
		
		}
		public static int getHeight() {
			return (int) height; 
		}
		public void createSound() {
			flagSound = new Sound("flag.wav");
			spiderSound = new Sound("Spider.wav");
			foodSound = new Sound("food.wav");
			lwSound = new Sound("losewin.wav");
			bgSound = new BGSound("BGSound.wav");
		
          }   
		/*public void OffSound() {
			bgSound.pause();
		}
		public void OnSound() {
			if(getSound())
				bgSound.play();
		}*/
		
		
}



