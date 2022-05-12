package com.olympic.cis143.m03.student.tacotruck.list;

import java.util.ArrayList;

import com.olympic.cis143.m03.student.tacotruck.Orders;
import com.olympic.cis143.m03.student.tacotruck.TacoImpl;

public class OrdersListImpl implements Orders
{
	private ArrayList<TacoImpl> tacoList = new ArrayList<>();
    /**
    *
    * @param tacoOrder
    */
   public void addOrder(TacoImpl tacoOrder)
	{
	   this.tacoList.add(tacoOrder);
	}

   /**
    * True if more tacos remain, else false.
    * @return
    */
   public boolean hasNext()
   {
	   return ! this.tacoList.isEmpty();
   }

   /**
    * Note that this method will remove the first (in terms of FIFO)taco from the tacoQueue and return it.
    *
    * Once returned it should be permenantly removed.
    *
    * Outcome
    * ========
    * It will remove and return the FIFO record. This is tested in the test file.
    *
    * @return The taco.
    */
   public TacoImpl closeNextOrder()
   {
	   for(int i = 0; i < this.tacoList.size();)
	   {
		   return this.tacoList.remove(i);
	   }
	   return null;
   }

   /**
    * How many order remain in the tacoQueue
    *
    * @return How many orders are in the queue
    */
   public int howManyOrders()
   {
	   return this.tacoList.size();
   }
}
