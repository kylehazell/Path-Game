package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;

import java.lang.Math;
// TODO: Auto-generated Javadoc

/**
 * The Class Spider.
 */
public class Spider extends Movable    {
	
	/** The randomom function */
	Random rand = new Random();
	
	/** The upperbound. */
	int upperbound = 360;
	 
 	/** The min. */
	private int min = -180;
	private int min2 = 0;
     
     /** The max. */
   private int max = 360;
	
	/** The heading. */
	//private int heading = rand.nextInt(upperbound);
	
	/** The heading. */
	private  int heading = rand.nextInt(359) ;
	
	/** The Size. */
	private int Size ;
	
   
	
/**
 * Instantiates a new spider.
 *
 * @param x the x
 * @param y the y
 * @param size the size
 * @param r the r
 * @param g the g
 * @param b the b
 */
public Spider(int GWwidth, int GWheight,float x, float y,int size,int r,int g,int b) {
		
		super(GWwidth,GWheight, 50,0, size ,x,y, r, g, b);
		
		setSize(size);

		setColor(255,255,0); //yellow
		
   super.setHeading(heading);
}

/**
 * Gets the size.
 *
 * @return the size
 */
public int getSize() {
	return Size;
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
 * Sets the size.
 *
 * @param size the new size
 */
public void setSize(int size) {
	Size = size;
}



/**
 * the Move method that helps objects change location .
 */
@Override
public void Move(Dimension dCmpSize, int time) {
	// TODO Auto-generated method stub
	Random rand = new Random();
	 //int random = rand.nextInt(25 + 25) - 25;
	Point oldLocation = getLocation(); //get current location and store here
	
	Point newLocation = new Point(0,0); // new location initialized
	
	float properAngle = (float) 90-super.getHeading();//angle because coordinate plane is shifted
	Float deltaX = (float) 0;
	Float deltaY = (float) 0;
	
	int randomV=-5+rand.nextInt(5-(-5));

		deltaX = (float) (Math.cos(Math.toRadians(properAngle))*(super.getSpeed()*(time/1000))); 
		deltaY = (float) (Math.sin(Math.toRadians(properAngle)) * (super.getSpeed()*(time/1000)));
	
	newLocation.setX(deltaX + oldLocation.getX()); 
	newLocation.setY(deltaY+oldLocation.getY());

	//newLocation.setX(newLocation.getX());
	//newLocation.setY(newLocation.getY());
	
	super.setLocation(deltaX + oldLocation.getX(),deltaY+oldLocation.getY());
	super.setHeading(super.getHeading()+randomV);
	if (newLocation.getX() < 0  ||newLocation.getX() > dCmpSize.getWidth() || newLocation.getY()< 0 || newLocation.getY() > dCmpSize.getHeight() ) {        //checks if in bounds of height and width (size of map now)
		super.setHeading(super.getHeading()+180);
    }
}

/**
 * To string.
 *
 * @return the string
 */
public String toString()
{
	String parentDesc = super.toString();
	String myDesc = " size = " + Size;
	String retval = "Spider: "+ parentDesc+myDesc;
	
	return retval;
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
public void draw(Graphics g, Point pCmpRelPrnt) {
	// TODO Auto-generated method stub
	int xLoc = (int) ((int)this.getLocation().getX() + pCmpRelPrnt.getX());
	int yLoc = (int) ((int)this.getLocation().getY() + pCmpRelPrnt.getY());
	int[] xArr = { xLoc, (xLoc - getSize()), (xLoc + getSize()), xLoc };
	int[] yArr = { (yLoc + getSize()), (yLoc - getSize()), (yLoc - getSize()), (yLoc + getSize()) };
	 g.setColor(ColorUtil.BLACK);	
	int nPoints = 4;
	
	g.drawPolygon(xArr, yArr, nPoints);
	//g.drawString(""+, x, y,);
	


}



@Override
public void handleCollision(GameObject otherObject, GameWorld gw) {
	// TODO Auto-generated method stub
	
}












}
