package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.mycompany.a3.GameObject;
// TODO: Auto-generated Javadoc

/**
 * The Class Fixed.
 */
public abstract class Fixed extends GameObject implements ISelectable {
	
	/** The location. */
	private Point location;
	private boolean selected;
	/** The size. */
	protected int size = rand.nextInt()%40+10;

	/**
	 * Instantiates a new fixed.
	 *
	 * @param size the size
	 * @param x the x
	 * @param y the y
	 * @param r the r
	 * @param b the b
	 * @param g the g
	 */
	public Fixed(int GWwidth, int GWheight,int size,float x,float y, int r, int b, int g) {
		// TODO Auto-generated constructor stub
	   super( GWwidth,  GWheight, size, x, y, r, b, g);
	}



	
	/**
	 * Sets the location.
	 *
	 * @param d the d
	 * @param e the e
	 */
	/*public void setLocation(double d, double e)
	{
		location.setX((float) ((Math.round(d)*10.0)/10.0));
		location.setY((float) ((Math.round(e)*10.0)/10.0));
		
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	/*public Point getLocation()
	{
		return location;
	}*/
	public abstract boolean  contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	/////////refactor this coddddddeeeeee!!!!!!!!!!!!!!
	public void setSelected(boolean s) {
		selected = s;
	}
	public boolean isSelected() {
		return selected;
	}

	
		// TODO Auto-generated constructor stub
	}
