package com.mycompany.a3;

public interface IIterator {

	public boolean hasNext();
	
 
	public default  Object getNext() {
		// TODO Auto-generated method stub
		return null;
	}
	

	// Return the current element in the List
	public GameObject getCurrent();

}
