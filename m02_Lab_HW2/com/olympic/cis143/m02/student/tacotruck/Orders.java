package com.olympic.cis143.m02.student.tacotruck;

import java.util.ArrayDeque;
import java.util.Deque;

public interface Orders
{
	public Deque<TacoImpl> tacoQueue = new ArrayDeque<>();

    /**
     *
     * @param tacoOrder
     */
    public default void addOrder(TacoImpl tacoOrder) {
    	Orders.tacoQueue.add(tacoOrder);   	
    }

    /**
     * True if more tacos remain, else false.
     * @return
     */
    public default boolean hasNext() {

        return !Orders.tacoQueue.isEmpty();
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
    public default TacoImpl closeNextOrder() {
        return Orders.tacoQueue.poll();
    }

    /**
     * How many order remain in the tacoQueue
     *
     * @return How many orders are in the queue
     */
    public default int howManyOrders() {
        return Orders.tacoQueue.size();
    }

}
