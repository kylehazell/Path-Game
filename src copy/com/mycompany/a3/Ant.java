package com.mycompany.a3;


	import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;

	//TODO: Auto-generated Javadoc
	/**
	* The Class Ant.
	*/
	public class Ant extends Movable implements  ISteerable {

		/** The max health. */
		//private int steeringDirection = 0;
	private int maxHealth ;
	Random rand = new Random();
	 /** The max speed. */
	 private int maxSpeed ;
	 
	 /** The food level. */
	 private int foodLevel ;
	 
	 /** The food consumtion rate. */
	 private int foodConsumtionRate;
	 
	 /** The health level. */
	 private int healthLevel;
	 
	 /** The last flag reached. */
	 private int lastFlagReached;
		private int min2 = 0;
		/** The location. */
		//private int size;
		private Point location;
		
		/** The speed. */
		private int speed ;
		private static Ant ant;
		private static int width;
		private static int height;
	   	
	// private boolean antDied = false;
	 
	//private int maxDamage = 15;
		 private  Ant(int GWwidth, int GWheight, int speed,int heading, int size,float x,float y, int r, int b, int g) {
			 super( GWwidth,GWheight, speed, heading, size,x,y, r,  b, g);
				
			 // TODO Auto-generated constructor stub		
				
				this.maxSpeed = 100;
				this.foodLevel = 200;
				this.foodConsumtionRate = 5;
				this.healthLevel = 10;
				this.lastFlagReached = 1;
				this.speed = speed;
				this.maxHealth =10;
				Ant.width= GWwidth;
				Ant.height= GWheight;
				setWidth(GWwidth);
				setHeight(GWheight);
				location = new Point(x,y);
			//	setLocation(location);
		  
		 //setSpeed(this.speed);
				
		 }
		// creates a new instance of ant
		 public void clear()
		 {
			 ant=null;
		 }
		 public static Ant getAnt() { 
			   
				Random rand = new Random();
			 int speedA =  rand.nextInt(80+50)-50;
			  int heading =rand.nextInt(50+20)-20;
			 if (ant == null)
				 ant =  new Ant(getWidth(),getHeight(),speedA,heading,80,222,100,0,0,255);
			 return ant;
			 }
		 
		    /**
	 	 * Gets the x.
	 	 *
	 	 * @return the x
	 	 */
	 	public float getX()
		     {
		     	
		     	return super.getX();
		     }

		     /**
	  	 * Gets the y.
	  	 *
	  	 * @return the y
	  	 */
	  	public float getY()
		     {
		     	
		     	return super.getY();
		     }
		     
		     /**
	  	 * Sets the y.
	  	 *
	  	 * @param y the new y
	  	 */
	  	public void setY(float y)
		     {
		     	
		     super.setY(y);
		     }
		     
	  	/**
	  	 * Sets the x.
	  	 *
	  	 * @param x the new x
	  	 */
	  	public void setX(float x)
		     {
		     	
		    	 super.setX(x);
		     }
		 
		 
		 
		 /**
		 * Gets the location.
		 *
		 * @return the location
		 */
		public Point getLocation()
		 {
		 	return location;
		 }
		
		
		 /**
		 * Gets the last flag reached.
		 *
		 * @return the last flag reached
		 */
		public int getlastFlagReached()
		    {
		        return lastFlagReached;
		    }
		    
		    /**
	 	 * Sets the last flag reached.
	 	 *
	 	 * @param lastFlagReached the new last flag reached
	 	 */
	 	public void setLastFlagReached(int lastFlagReached)
		    {
		        this.lastFlagReached = lastFlagReached;
		    }
		    
		 
		 /**
		 * Gets the maximum speed.
		 *
		 * @return the maximum speed
		 */
		public int getMaximumSpeed()
	 {
	     return maxSpeed;
	 }
	 
	 /**
	  * Sets the max speed.
	  *
	  * @param maximumSpeed the new max speed
	  */
	 public void setMaxSpeed(int maximumSpeed)
	 {
	     this.maxSpeed = maximumSpeed;
	 }
	 
	 /**
	  * Gets the food level.
	  *
	  * @return the food level
	  */
	 public int getFoodLevel()
	 {
	     return foodLevel;
	 }
	 
	 /**
	  * Sets the food level.
	  *
	  * @param foodLevel the new food level
	  */
	 public void setFoodLevel(int foodLevel)
	 {
	     this.foodLevel = foodLevel;
	 }

	 /**
	  * Gets the food consumption rate.
	  *
	  * @return the food consumption rate
	  */
	 public int getFoodConsumptionRate()
	 {
	     return foodConsumtionRate;
	 }
	 
	 /**
	  * Sets the food consumption rate.
	  *
	  * @param foodConsumtion the new food consumption rate
	  */
	 public void setFoodConsumptionRate(int foodConsumtion )
	 {
	     this.foodConsumtionRate = foodConsumtion;
	 }

	 
	 /**
	  * Gets the health level.
	  *
	  * @return the health level
	  */
	 public int getHealthLevel()
	 {
	     return healthLevel;
	 }
	 
	 /**
	  * Sets the health level.
	  *
	  * @param healthLevel the new health level
	  */
	 public void setHealthLevel(int healthLevel)
	 {
	     this.healthLevel = healthLevel;
	 }
	 
	 
	 
	 
	 /**
	  * Accelerates the ant. if the ant has damage it goes by only a percenatge of its orginal speed
	  *
	  * @return the int
	  */
	 public int accelerate() {
			
			
			float damagePercentage =  (float)healthLevel/(float)maxHealth;	
			float damagedSpeed = (damagePercentage * maxSpeed);
			if(super.getSpeed() <= 0 || getFoodLevel() == 0) {
				super.setSpeed(0);
				System.out.println(" Your Ant can longer move");
			}
			
			else if (super.getSpeed() >= damagedSpeed)  {
				super.setSpeed((int) Math.ceil(damagedSpeed));
			}
			else {
				super.setSpeed(super.getSpeed()+1);
			}
		return super.getSpeed();
		}
	 
	 /**
	  * Decrease speed.
	  *
	  * @return the int
	  */
	 public int decreaseSpeed(){
	 	
	 	if (super.getSpeed() > 0 ) 
	 	   {
	 	    super.setSpeed(super.getSpeed() - 1);
	 	    System.out.println(" speed decreased");
	 	   // else {
	 		}
	 	   else {
	 		   super.setSpeed(0);
	 	   
	 }
	 	return getSpeed();
	 }
	 
	 /**
	  * Apply s food gain to the ant .
	  *
	  * @param gainedFood the gained food
	  */
	 public void applyFoodGain(int gainedFood) {
	     int  foodLevel= gainedFood + getFoodLevel();
			if(foodLevel > 50) {
				
				setFoodLevel(50);
			}
			else {
				setFoodLevel(gainedFood + getFoodLevel());
			}
			
		}

	 
	 /**
	  *  makes the ant Move up and .
	  */
	 @Override
	 public void Move(Dimension dCmpSize, int time)
		{
		
			Point oldLocation = super.getLocation(); //get current location and store here
			
			Point newLocation = new Point(0,0); // new location initialized
			
			int properAngle = 90-super.getHeading(); //angle because coordinate plane is shifted
			Float deltaX = (float) 0;
			Float deltaY = (float) 0;
			int randomV=-5+rand.nextInt(5-(-5));
			
		

			deltaX = (float) (Math.cos(Math.toRadians(properAngle))*(super.getSpeed()*(time/1000))); 
			deltaY = (float) (Math.sin(Math.toRadians(properAngle)) * (super.getSpeed()*(time/1000)));
		
			newLocation.setX(deltaX + oldLocation.getX()); 
			newLocation.setY(deltaY+oldLocation.getY());
			/*if (newLocation.getX() >= dCmpSize.getWidth())
			{
				newLocation.setX(newLocation.getX() - dCmpSize.getWidth());
			}
			else if (newLocation.getX() <= 0.0)
			{
				newLocation.setX(dCmpSize.getWidth() - Math.abs(newLocation.getX()));
			}
			
			if (newLocation.getY() >=dCmpSize.getHeight())
			{
				newLocation.setY(newLocation.getY()- dCmpSize.getHeight());
			}
			else if (newLocation.getY() <= 0.0)
			{
				newLocation.setY(dCmpSize.getHeight() - Math.abs(newLocation.getY()));
				
			}*/
			
			//newLocation.setX(newLocation.getX());
			//newLocation.setY(newLocation.getY());
			super.setLocation(newLocation);
			super.setHeading(super.getHeading()+randomV);
			if (newLocation.getX() < 0  ||newLocation.getX() > dCmpSize.getWidth() || newLocation.getY()< 0 || newLocation.getY() > dCmpSize.getHeight() ) {        //checks if in bounds of height and width (size of map now)
				super.setHeading(super.getHeading()+180);
	        }
			
		
			
			
			
			 
		}

	 /**
	  * Life test. test to see if the aint is dead or not
	  *
	  * @return true, if successful
	  */
	 public boolean lifeTest()
	 {
	 	if(getHealthLevel() <=0 || getFoodLevel() <= 0 )
	 	{
	 		System.out.println("ANT IS DEAD");
	 		return false ;
	 	}
	 	else {
	 		return true;
	 	}
	 }

		/**
		 * Turn left.
		 */
		@Override
		public void turnLeft() {
			// TODO Auto-generated method stub
			super.setHeading(super.getHeading() + 20);
			
		}



		/**
		 *  Turns  right. to make  the heading change.
		 */
		@Override
		public void turnRight() {
			// TODO Auto-generated method stub
			super.setHeading(super.getHeading() - 20);
		}
		public void setWidth(int width) {
			Ant.width = width; 
		}
		public void setHeight(int height) {
			Ant.height = height; 
		}
		public static int getWidth() {
			return width; 
		}
		public static int getHeight() {
			return height; 
		}
		
		
		/**
		 * To string.
		 *
		 * @return the string
		 */
		public String toString() {
			String parentDesc = super.toString();
			String myDesc = "speed= " + super.getSpeed() +  " maxSpeed=" + ((float)healthLevel/(float)maxHealth)*(float)maxSpeed
			+ " foodLevel=" + foodLevel + " healthLevel=" + healthLevel  ;
			String retval = "Ant: "+ parentDesc+myDesc;
			return retval;
		}
		
		
		
	
	
		@Override
		public void draw(Graphics g, Point pCmpRelPrnt) {
			// TODO Auto-generated method stub
		int xLoc = (int) ((int)super.getLocation().getX() + pCmpRelPrnt.getX()- (getSize()/2 ));
		int yLoc = (int) ((int)super.getLocation().getY() + pCmpRelPrnt.getY() - (getSize()/2));
		
		 g.setColor(ColorUtil.rgb(250, 0, 0));
	
		g.drawArc(xLoc, yLoc, getSize(), getSize(), 0, 360);
		g.fillArc(xLoc, yLoc,getSize(), getSize(), 0, 360);
		
		
		}
	
		@Override
		public boolean collidesWith(GameObject otherObject) {
			// TODO Auto-generated method stub
			boolean result = false;
			float antCenterX = this.getX() + (getSize()/2);
			float antCenterY = this.getY() + (getSize()/2);
			float otherCenterX =  otherObject.getX();
			float otherCenterY =  otherObject.getY();		

			float distX = antCenterX - otherCenterX;
			float distY = antCenterY - otherCenterY;
			float distBetweenCentersSquare = ( distX * distX + distY * distY );
			
			int antRadius = getSize() /2;
			int otherRadius = getSize() /2;
			
			int radiiSquare = (antRadius * antRadius + 2 * antRadius * otherRadius + otherRadius * otherRadius);
			
			if(distBetweenCentersSquare <= radiiSquare) {
				result = true;
			}
			
			return result;
		}
		
		
		@Override
		public void handleCollision(GameObject otherObject, GameWorld gw) {
			// TODO Auto-generated method stub
			if(otherObject instanceof Spider) {
				gw.spiderCAnt((Spider) otherObject);
			}
			else if (otherObject instanceof Flag) {
				
				gw.antHitFlag(((Flag) otherObject).getseqN());
				
			}
	        else if (otherObject instanceof FoodStation) {
				gw.foodStationCollision((FoodStation) otherObject);
			}
		}


		
	}
