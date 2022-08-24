package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.charts.models.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class GameObject.
 */
public abstract class GameObject implements IDrawable, ICollider   {

/** The rand. */
Random rand = new Random();

/** The size. */
private int size;

/** The color. */
private int color;

/** The location. */
private Point location;

/** The x. */
private float x;

/** The y. */
private float y;
//default object

/**
 * Instantiates a new game object.
 */

public GameObject(int GWwidth, int GWheight,int size,float x,float y, int r, int b, int g){
	//Random rand = new Random();
	setColor(r,g,b);
	//this.location = new Point(x,y);
    this.size=size;
   
  
		

	this.location = new Point(x,y);
	setLocation(this.location);

}


/**
 * Gets the x.
 *
 * @return the x
 */
public float getX()
{
	
	return location.getX();
}

/**
 * Sets the y.
 *
 * @param y the new y
 */
public void setY(float y)
{
	
	location.setY(y);
}

/**
 * Sets the x.
 *
 * @param x the new x
 */
public void setX(float x)
{
	
	location.setX(x);
}

/**
 * Gets the y.
 *
 * @return the y
 */
public float getY()
{
	
	return location.getY();
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
 * Gets the color.
 *
 * @return the color
 */
public int getColor()
{
	
	return color;
}

/**
 * Sets the color.
 *
 * @param r the r
 * @param g the g
 * @param b the b
 */
public void setColor(int r, int g, int b)
{
	color = ColorUtil.rgb(r,g,b);
}


/**
 * Gets the size.
 *
 * @return the size
 */
public int getSize()
{
	
	return size;
}


/**
 * Sets the size.
 *
 * @param size the new size
 */
public void setSize( int size)
{
	
	size = this.size;
}

/**
 * Sets the location.
 *
 * @param d the d
 * @param e the e
 */
public void setLocation(float d, float e)
{
	location.setX((float) ((Math.round(d)*10.0)/10.0));
	location.setY((float) ((Math.round(e)*10.0)/10.0));
	
}

/**
 * Sets the location.
 *
 * @param newLoc the new location
 */
public void setLocation(Point newLoc)
{
	location.setX((float) ((Math.round(newLoc.getX())*10.0)/10.0));
	location.setY((float) ((Math.round(newLoc.getY())*10.0)/10.0));
	
}



/**
 * To string.
 *
 * @return the string
 */
public String toString()
{
	String retval = 
			" Location = " + location.getX() + "," + location.getY() 
			+ " Color = [" + ColorUtil.red(color) + "," +
			ColorUtil.green(color) +"," +
			ColorUtil.blue(color) + "]";
	return retval;
	
}


public abstract void draw(Graphics g, Point pCmpRelPrnt);







}

