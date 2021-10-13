package com.jitterted.ebp.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class StubDeck extends Deck{

    public StubDeck(Card... cards) {
        this.cards = new ArrayList<Card>();
        for (int i=0; i<cards.length; i++) {
            this.cards.add(cards[i]);
        }
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public Card draw() {
        return super.draw();
    }
}
