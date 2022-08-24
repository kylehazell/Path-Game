package com.mycompany.a3;
import com.codename1.ui.Container;
import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;

import com.codename1.ui.layouts.FlowLayout;

import com.codename1.ui.Graphics;
import com.codename1.charts.models.Point;

//import com.codename1.charts.util.ColorUtil;

public class MapView extends Container implements Observer { 
	private GameWorld gameworld;
	private Game g;
	private GameObjectCollection objects;
	//private boolean pressed; 
	private boolean position;
	private boolean mvp;
	private Fixed fix;
	
	
	
	public MapView() {
		this.getAllStyles().setBgTransparency(255);
        this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
        this.setLayout(new FlowLayout(CENTER));
	}
	
	
	
	//updates the map
	public void update (Observable o, Object arg) { 
		((GameWorld)o).map();
		gameworld = ((GameWorld)o); 
        objects = gameworld.getCollection();
        
    
        repaint(); 
		  
	
	}
	
	@Override
	public void paint(Graphics g) { 
         super.paint(g); 
         Point  pCmpRelPrnt = new Point(this.getX(),this.getY());
         IIterator iterator = objects.getIterator();
        
         while (iterator.hasNext()){ 
            GameObject recentObj = (GameObject) iterator.getNext();
	

    			recentObj.draw(g, pCmpRelPrnt);
     
	}
}
	
	
	public boolean isMVP() {
		
		return mvp;
}
	public void setMVP(boolean p) {
		
		this.mvp= p;
}
	public void turnOnPosition() {
		
			position = true;
	}
	
	@Override
	public void pointerPressed(int x, int y)
	{
		if(!this.isMVP()) {
		return;	}
		
		
		if( fix == null && position == false) {
		int px = x - getParent().getAbsoluteX();
		int py = y - getParent().getAbsoluteY();
		
		Point pPtrRelPrnt = new Point(px, py);
		Point pCmpRelPrnt = new Point(getX(), getY());
			
			IIterator tempObject = objects.getIterator();
		while(tempObject.hasNext()) {
			GameObject curObj = (GameObject)tempObject.getNext();
	
				if(curObj instanceof Fixed)
				{
					Fixed temp = (Fixed)curObj;
				
					if(((Fixed)temp).contains(pPtrRelPrnt, pCmpRelPrnt)) 
					{
					
					fix = (Fixed)curObj;
					fix.setSelected(true);
					System.out.println("object picked");
					}
				}
				
		  }
		} 
			else if ( fix != null && position == true)
			{
				
				fix.setLocation(x - getParent().getAbsoluteX()-getX(),y - getParent().getAbsoluteY()-getY());
				fix.setSelected(false);
				fix=null;
				position = false;
				
			}
				
				
				 repaint();
				 System.out.println("object press");
		}
	
}
	


