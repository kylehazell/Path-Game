package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.mycompany.a3.Fixed;


public class FoodStation extends Fixed   {
	
	/** The capacity. */
	private  int capacity;
	
	/** The size. */
	private int size;
	private boolean selected;
	
	/**
	 * Instantiates a new food station.
	 *
	 * @param x the x
	 * @param y the y
	 * @param size the size
	 * @param r the r
	 * @param b the b
	 * @param g the g
	 */
	public FoodStation(int GWwidth, int GWheight, float x, float y, int size,int r, int b, int g ) {

	super(GWwidth,GWheight, size, x, y, r ,b,g);
	this.selected= false;
//this.setColor(ColorUtil.BLUE);
this.setSize(size);
super.setSize(size);
this.setCapacity(size);
	}
	
	/**
	 * Sets the capacity.
	 *
	 * @param capacity the new capacity
	 */
	public void setCapacity(int capacity) {
		// TODO Auto-generated method stub
		this.capacity = capacity;
		
	}
	
	/**
	 * Gets the capacity.
	 *
	 * @return the capacity
	 */
	public  int getCapacity()
	{
	 return capacity;	
		
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty()
	{
		if(getCapacity() == 0)
		{
			return true;
		}
		else {
		return false;
		}
		
	}
	
	

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = "capacity =" + capacity;
		return "FoodStation:"+ parentDesc + myDesc;
		
	}

	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		//int halfSize = getSize()/2; 
		int x =(int) ((int) getLocation().getX() + pCmpRelPrnt.getX() - super.getSize() / 2);
        int y =(int) ((int) getLocation().getY() + pCmpRelPrnt.getY() - super.getSize() / 2);
        g.setColor(ColorUtil.GREEN);	
       
       

        if (!isSelected()) {
        	 g.drawRect(x,  y, super.getSize(), super.getSize());
        	 g.fillRect(x,  y, super.getSize(), super.getSize());
        	 g.setColor(ColorUtil.rgb(0, 0, 0));
		     g.drawString(""+getCapacity(), x, y);
        }
		else {
			g.setColor(ColorUtil.YELLOW);
		    g.fillRect(x,  y, super.getSize(), super.getSize());
		    g.setColor(ColorUtil.rgb(0, 0, 0));
		     g.drawString(""+getCapacity(), x, y);
		    
		}
		g.setAlpha(250);
	}

	@Override
	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		selected = b;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return selected;
	}

	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int px = (int) pPtrRelPrnt.getX(); // pointer location relative to
		int py = (int) pPtrRelPrnt.getY(); //parent’s origin
		int xLoc = (int) ((int)this.getLocation().getX() + pCmpRelPrnt.getX());
		int yLoc = (int) ((int)this.getLocation().getY() + pCmpRelPrnt.getY());;// to parent’s origin
		if ( (px >= xLoc - getSize()/2) && (px <= xLoc+getSize() /  2) && (py >= yLoc - getSize()/2) && (py <= yLoc+getSize() /  2) )
			return true; 
		else
			return false;
		}
	 

	@Override
	public boolean collidesWith(GameObject otherObject) {
		// TODO Auto-generated method stub
		boolean result = false;
		float antCenterX = this.getX() + (getSize()/2);
		float antCenterY = this.getY() + (getSize()/2);
		float otherCenterX =  otherObject.getX() + (((GameObject) otherObject).getSize()/2);
		float otherCenterY = otherObject.getY() + (((GameObject) otherObject).getSize()/2);		

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
		
	}

	


	

}

