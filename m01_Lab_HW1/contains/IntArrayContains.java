package com.olympic.cis143.lab1.contains;

public class IntArrayContains {

    private int[] data;

    public IntArrayContains(int[] values) {
        if (values == null) {
            throw new RuntimeException("Values passed cannot be null");
        }
        this.data = values;
    }

    /**
     * Check to see if the data array contains the value that is passed.
     *
     * @param value The value to see if its contained in the array.
     * @return True if the value is found, else, false.
     */
    public boolean contains(int value) 
    {
    	for(int i = 0; i < data.length; i++)
    	{
    		try 
    		{
    			//to check if the value being tested is the same as the value
    			if(data[i] == data[value]) return true;
    			//to check if the value being tested is in the array and matches the value
    			if(data[i] != data[value]) return true;
    		}
    		//I kept running into this exception so I made code to catch the exception
    		catch(ArrayIndexOutOfBoundsException err)
    		{

    		}
    	}
    	return false;
    }
}
