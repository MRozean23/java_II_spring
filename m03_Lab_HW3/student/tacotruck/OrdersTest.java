package com.olympic.cis143.m03.student.tacotruck;

import com.olympic.cis143.m03.student.tacotruck.list.OrdersListImpl;
import com.olympic.cis143.m03.student.tacotruck.queue.OrdersQueueImpl;

public class OrdersTest {

    public static void main(String[] args) {
        OrdersTest ordersTest = new OrdersTest();
        ordersTest.testHasNextFalse();
        ordersTest.testCloseNextOrder();
    }

    public void testHasNextFalse() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);

        Orders ordersQueue = new OrdersQueueImpl();
        Orders ordersList = new OrdersListImpl();
        
        ordersQueue.addOrder(firstTaco);
        ordersList.addOrder(firstTaco);
        if (!ordersQueue.hasNext() && !ordersList.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should have one order in them.");
        }
        TacoImpl closedTaco = ordersQueue.closeNextOrder();
        TacoImpl closedTacoList = ordersList.closeNextOrder();
        
        if (closedTaco == null && closedTacoList == null) {
            throw new RuntimeException(":( testHasNextFalse fail: closed taco should not be null.");
        }
        if (!closedTaco.equals(firstTaco) && !closedTacoList.equals(firstTaco)) {
            throw new RuntimeException(":( testHasNextFalse fail: This should truely never happen.");
        }
        if (ordersQueue.hasNext() && ordersList.hasNext()) {
            throw new RuntimeException(":( testHasNextFalse fail: Orders should be empty.");
        }
        System.out.println(":) testHasNextFalse passed");
    }

    public void testCloseNextOrder() {
        TacoImpl firstTaco = new TacoImpl(TacoImpl.Protien.BEAN, true);
        TacoImpl secondTaco = new TacoImpl(TacoImpl.Protien.BEEF, true);

        Orders ordersQueue = new OrdersQueueImpl();
        Orders ordersList = new OrdersListImpl();
        
        ordersQueue.addOrder(firstTaco);
        ordersQueue.addOrder(secondTaco);
        ordersList.addOrder(firstTaco);
        ordersList.addOrder(secondTaco);
        
        TacoImpl shouldBeFirstTacoQueue = ordersQueue.closeNextOrder();
        TacoImpl shouldBeFirstTacoList = ordersList.closeNextOrder();
        if (ordersQueue.howManyOrders() != 1 && ordersList.howManyOrders() !=1) {
            throw new RuntimeException(":( testCloseNextOrder Failed: orders should only have one order left");
        }
        if (firstTaco.equals(shouldBeFirstTacoQueue)){
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first taco was first out.");
        }
        if (firstTaco.equals(shouldBeFirstTacoList)){
            System.out.println(":) testCloseNextOrder passed");
        } else {
            throw new RuntimeException(":( testCloseNextOrder Failed: should be the first taco was first out.");
        }
    }
}
