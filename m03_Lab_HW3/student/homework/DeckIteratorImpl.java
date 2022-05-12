package com.olympic.cis143.m03.student.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DeckIteratorImpl implements Deck
{
	private ArrayList<Card> deck = new ArrayList<>();
	private Iterator<Card> iteratorDeck = this.deck.iterator();
	
	public DeckIteratorImpl(final boolean jokers) 
	{
        this.createDeck(jokers);
    }
	
    private void createDeck(final boolean jokers) 
    {
    	for(Card.Suit suit : Card.Suit.values())
    	{
    		for(Card.Value value : Card.Value.values())
    		{
    			if(!(suit == Card.Suit.NONE) && !(value == Card.Value.JOKER))
    			{
    				this.deck.add(new Card(suit, value));
    			}
    		}
    	}
    	if(jokers)
    	{
    		this.deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
    		this.deck.add(new Card(Card.Suit.NONE, Card.Value.JOKER));
    	}
    }

	@Override
	public List<Card> getDeck()
	{
		return this.deck;
	}

	@Override
	public void shuffle()
	{
		Collections.shuffle(this.deck);
	}

	@Override
	public boolean hasNext()
	{
		return !this.iteratorDeck.hasNext();
	}

	@Override
	public Card dealCard()
	{
		return this.iteratorDeck.next();
	}

}
