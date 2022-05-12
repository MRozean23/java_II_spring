package com.olympic.cis143.lab1.equals;

public class IntArrayEquals {

    private int[] data;

    public IntArrayEquals(int[] values) {
        if (values == null) {
            throw new RuntimeException("Values passed cannot be null");
        }
        this.data = values;
    }

    /**
     * This method will return false is the array:
     * 1. is null
     * 2. Arrays have different lengths
     * 3. Data within the array is not the same and in the same order
     *
     * If the above conditions are true, the method returns true.
     * @param compareMe The integer array to compare the internal array with.
     * @return True if equal else false.
     */
    public boolean equals(int[] compareMe) 
    {   
    	
    	
    		//return false if the array is null
        	if(compareMe == null || this.data == null) return false;
        	//return false if the arrays lengths do not equal each other
        	if(data.length != compareMe.length) return false;
        	
        	//simple loop to get all the elements of the array loaded
        	for(int i = 0; i < data.length; i++)
        	{
        		//return false if the elements in the arrays do not match
        		if(data[i] != compareMe[i]) return false;
        	}
    	//if all conditions are met the array returns true
    	return true;
    }
}
