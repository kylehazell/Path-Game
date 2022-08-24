package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.ui.geom.Dimension;
import com.mycompany.a3.GameObject;

//TODO: Auto-generated Javadoc
/**
* The Class Movable.
*/
public abstract class Movable extends GameObject{
	
	/** The random function. */
	//private Random rand = new Random();
  
  /** The heading. */
  private float heading;
  
  /** The speed. */
  private int speed; 
  
  /**
   * Instantiates a new movable.
   *
   * @param speed the speed
   * @param heading the heading
   * @param size the size
   * @param x the x
   * @param y the y
   * @param r the r
   * @param b the b
   * @param g the g
   */
  public Movable( int GWwidth, int GWheight,int speed,int heading, int size,float x,float y, int r, int b, int g)
		{
			
			super( GWwidth,GWheight,size, x, y, r, b, g);
			//speed = rand.nextInt(speed);
		//	heading = rand.nextInt(360);
			setHeading(heading);
			
			setSpeed(speed);
	     }

 
			/**
			 * Sets the location.
			 *
			 * @param loc the new location
			 */
			public void setLocation(Point loc){
			super.setLocation(loc);
			}
			
			/**
			 * Gets the location.
			 *
			 * @return the location
			 */
			public Point getLocation(){
				return super.getLocation();
				 }
				
			/*
			 * Changing new location x and y by using oldLocation x and y
			 * and adding delta X and delta Y
			 */
			
		
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
	  * Sets the speed.
	  *
	  * @param x the new speed
	  */
	 public void setSpeed(int x)
	{
		speed =  x;
	}
	
	 /**
	  * Gets the speed.
	  *
	  * @return the speed
	  */
	 public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * Gets the heading.
	 *
	 * @return the heading
	 */
	public int getHeading ()
	{
		return (int) heading ;
		
	}
	
	/**
	 * Sets the heading.
	 *
	 * @param this.heading2 the new heading
	 */
	public void setHeading(float heading2)
	{
		heading = heading2;
	}

  
  /*
   * the abstract method Move.
   */
  public abstract void Move(Dimension dCmpSize, int time);
  
  
  



/**
* To string.
*
* @return the string
*/
public String toString()
{
	String parentString = super.toString();
	String str =  " Heading  = " + heading;
	
	
	String retval = parentString + str;
	
	return retval;
}

}
