package com.olympic.cis143.m02.student.cards;

import java.util.Collections;
import java.util.Stack;

public interface Deck
{
	public Stack<Card> deck = new Stack<>();
	
	 public default void DeckImpl(final boolean jokers) {
	        this.createDeck(jokers);
	    }

	    /**
	     * Private. THis is the place where you will need to create a deck of cards. 
	     * You can iterate through either enums in Card.
	     *
	     * Some rules:
	     * ============
	     * 1. Note the boolean jokers parameter. If true add the Jokers to the 
	     * deck with a Card.Suite.NONE.
	     * 2. Do not create cards, other than jokers, with a Card.Suite.NONE.
	     *
	     * Outcome
	     * ========
	     * if jokers == true, 54 cards will be created.
	     * if jokers == false, 52 cards are created.
	     *
	     * @param jokers True if you want jokers added to the deck.
	     */
	    private void createDeck(final boolean jokers) 
	    {
	    	for(Card.Suit suit : Card.Suit.values())
	    	{
	    		for(Card.Value value : Card.Value.values())
	    		{
	    			if(!(suit == Card.Suit.NONE) && !(value == Card.Value.JOKER))
	    			{
	    				Deck.deck.add(new Card(suit, value));
	    			}
	    					
	    		}
	    	}
	    	if(jokers)
	    	{
	    		Deck.deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
	    		Deck.deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
	    	}
	    }

	    /**
	     * Gets the deck.
	     * @return The deck.
	     */
	    public default Stack<Card> getDeck() 
	    {
	        return Deck.deck;
	    }
	    /**
	     * Randomize and shuffle the deck of cards.
	     */
	    public default void shuffle() 
	    {
	    	Collections.shuffle(Deck.deck);
	    }

	    /**
	     * True if the deck has cards remaining else false.
	     * @return
	     */
	    public default boolean hasNext() 
	    {
	    	return !Deck.deck.empty();
	    }

	    /**
	     * Always call the hasNext() method before calling this method.
	     * This method should get the next card in the deck.
	     *
	     * Outcome
	     * =======
	     * The method will remove the next from the deck and return it in the method.
	     *
	     * If the deck is empty it should through a RuntimeException.
	     * @return
	     */
	    public default Card dealCard() 
	    {
	    	return Deck.deck.pop();
	    }
}
