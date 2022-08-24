package com.mycompany.a3;

import java.util.ArrayList;


public class GameObjectCollection implements ICollection {
	public ArrayList<GameObject> theCollection;
	
	 // constructor
	 
	public GameObjectCollection() {
		this.theCollection = new ArrayList<GameObject>();
	}
	//removes items 
	 @Override
	public void remove(GameObject newObject) {
		// TODO Auto-generated method stub
		this.theCollection.remove(newObject);
	}
///adds objects
	@Override
	public void add(GameObject newObject) {
		// TODO Auto-generated method stub
		this.theCollection.add( newObject);
	}
	

	
	 // gets the iterator
	 
	@Override
	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new GameObjectArrayIterator();
	}
	public void clear() {
		this.theCollection.clear();
	}

	private class GameObjectArrayIterator implements IIterator {
		private int currElementIndex;
		
		 // constructor
		 
		public GameObjectArrayIterator() {
			currElementIndex = -1;
		}
		
		 //checks to see if the list has an object in the next position
		 
		public boolean hasNext() {
			if (theCollection.size() <= 0) {
				return false;
			}
			if (currElementIndex == theCollection.size() - 1) {
				return false;
			}
			return true;
		}
		
		
		
		public Object getNext() {
			currElementIndex ++;
			return(theCollection.get(currElementIndex));
		}

		@Override
		public GameObject getCurrent() {
			// TODO Auto-generated method stub
			return theCollection.get(currElementIndex);
		}

		
}

	
	
	
	}

