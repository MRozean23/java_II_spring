package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders 
{
	private Map<String, List<TacoImpl>> tacoMap = new HashMap<>();

    @Override
    public void createOrder(final String orderid) 
    {
    	this.tacoMap.put(orderid, new ArrayList<TacoImpl>());
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException 
    {
    	if(!tacoMap.containsKey(orderid))
    	{
    		throw new OrderDoesNotExistException("Does not Exist");
    	}
    	this.tacoMap.get(orderid).add(taco);
    }

    @Override
    public boolean hasNext() 
    {
        return !this.tacoMap.isEmpty();
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException 
    {
    	if(!tacoMap.containsKey(orderid))
    	{
    		throw new OrderDoesNotExistException("Does not Exist");
    	}
    	return this.tacoMap.remove(orderid);
    }

    @Override
    public int howManyOrders() 
    {
        return this.tacoMap.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException 
    {
    	if(!tacoMap.containsKey(orderid))
    	{
    		throw new OrderDoesNotExistException("Does not Exist");
    	}
    	return this.tacoMap.get(orderid);
    }
}
