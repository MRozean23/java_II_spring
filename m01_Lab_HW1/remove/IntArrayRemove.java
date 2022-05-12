package com.olympic.cis143.lab1.remove;

import java.util.ArrayList;
import java.util.Arrays;

import com.olympic.cis143.lab1.contains.IntArrayContains;

@SuppressWarnings("unused")
public class IntArrayRemove {

    private int[] data;

    public IntArrayRemove(int[] values) {
        if (values == null) {
            throw new RuntimeException("Values passed cannot be null");
        }
        this.data = values;
    }

    public int[] getData() {
        return this.data;
    }

    /**
     * This method will remove the value passed to it. If the value does not exist in the array, nothing is done.s
     *
     * Note that, for this exercise, a value can only exist, at a maximum, one time within an array.
     *
     * @param value The value to remove.
     */
    public void remove(int value) 
    {
    	//Need a variable to test both scenarios
		boolean wasFound = false;
	
		for(int i = 0, j = 0; i < this.data.length; i++, j++)
		{
			//First test to see if the value is not the data array
			if(value != this.data[i])
			{
				//Created a new array to store the values
				int noRemoveInt[] = Arrays.copyOf(this.data, this.data.length);
				//Update the data array to show the new values
				this.data = noRemoveInt;
			}
			//Second test to see if the value is in the array
			else if(value == this.data[j])
			{
				//New array built with all of the data elements, with 1 less element
				int removeInt[] = Arrays.copyOf(this.data, this.data.length - 1);
				j++;
				wasFound = true;
				
				if(wasFound == true)
				{
					//If the value was found within the array the value is replaced with a data element that isn't equal to the value
					removeInt[i] = data[j];
					this.data = removeInt;
				}
			}

		}
	}
}
