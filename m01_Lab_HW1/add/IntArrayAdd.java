package com.olympic.cis143.lab1.add;

import java.util.Arrays;

public class IntArrayAdd {

    private int[] data;

    public IntArrayAdd() {
        this.data = new int[0];
    }

    public int[] getData() {
        return this.data;
    }

    /**
     * This method will need to add an element to the end of an array.
     *
     * @param value The value to be added.
     */
    public void add(int value)
    {
    	//Make a new array with the same data in the data array with 1 extra element
    		int newData[] = Arrays.copyOf(this.data, this.data.length + 1);

    		for(int i = 0; i < this.data.length; i++)
    		{
    			newData[i] = this.data[i];
    		}
    		//To keep the array in the bounds when adding the value to the end of the array
    		newData[newData.length - 1] = value;
    		//Update the data array to the new values
    		this.data = newData;
    } 	
}
    
