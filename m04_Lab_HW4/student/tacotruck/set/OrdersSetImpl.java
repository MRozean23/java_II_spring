package com.olympic.cis143.m04.student.tacotruck.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

public class OrdersSetImpl  implements Orders 
{
	private Set<TacoImpl> tacoSet = new HashSet<TacoImpl>();
	
    @Override
    public void addOrder(TacoImpl tacoOrder) 
    {
    	this.tacoSet.add(tacoOrder);
    }

    @Override
    public boolean hasNext() 
    {
        return !this.tacoSet.isEmpty();
    }

    @Override
    public TacoImpl closeNextOrder() 
    {
    	Iterator<TacoImpl> tacoIterator = this.tacoSet.iterator();
    	TacoImpl taco = null;
    	if(tacoIterator.hasNext())
    	{
    		taco = tacoIterator.next();
        	this.tacoSet.remove(taco);
    	}
    	else
    	{
    		return null;
    	}
        return taco;
    }

    @Override
    public int howManyOrders() 
    {
        return this.tacoSet.size();
    }
}
