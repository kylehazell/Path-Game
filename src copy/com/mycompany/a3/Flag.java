package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.mycompany.a3.Fixed;

/**
 * The Class Flag.
 */
public class Flag extends Fixed   {
	
	/** The sequence number. */
	private int sequenceNumber;
	private boolean selected;
	/*public Flag(){
		super();
	this.sequenceNumber=1;	
		
		
		
	}*/ /**
	 * Instantiates a new flag.
	 *
	 * @param size the size
	 * @param x the x
	 * @param y the y
	 * @param seqN the seq N
	 */
	//create generic flag class
	public Flag(int GWwidth, int GWheight,int size , float x, float y, int seqN ) {
		super(GWwidth,GWheight,60, x, y, 0 ,255,0);
		//this.setSize(baseSize);
		//this.setColor(ColorUtil.BLUE, seqN, seqN);
		this.selected= false;
		setseqN(seqN);
		this.size= size;
		
	}

   public int getseqN() {
	   
	  return sequenceNumber;

	   
   }
   public void setseqN(int num) {
	   
	 this.sequenceNumber= num;  
   }
   
	 /**
 	 * To string.
 	 *
 	 * @return the string
 	 */
 	@Override
		public String toString() {
		String parentDesc = super.toString();
		String myDesc = " size="+ this.size + " seqNum= "+ this.sequenceNumber ;
		return "Flag: "+ parentDesc + myDesc;

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
		int[] xArr = { xLoc, (xLoc -  super.getSize()), (xLoc +  super.getSize()), xLoc };
		int[] yArr = { (yLoc +  super.getSize()), (yLoc -  super.getSize()), (yLoc -  super.getSize()), (yLoc + super.getSize()) };
		g.setColor(ColorUtil.BLUE);
		int nPoints = 4;
		
		g.setAlpha(50);
		if (!isSelected()) {
			  
		g.drawPolygon(xArr, yArr, nPoints);	
		 g.fillPolygon(xArr, yArr, nPoints);
		 g.setColor(ColorUtil.BLACK);
		  g.drawString(""+getseqN(), xLoc,yLoc);
		 
		}
		  else {
		 g.setColor(ColorUtil.YELLOW);
		 g.fillPolygon(xArr, yArr, nPoints);
		 g.setColor(ColorUtil.BLACK);
		  g.drawString(""+getseqN(), xLoc,yLoc);
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
	public void handleCollision(GameObject otherObject, GameWorld gw) {
		// TODO Auto-generated method stub
		setColor(ColorUtil.MAGENTA, 0, 0);
	}


	



	


	



	



}