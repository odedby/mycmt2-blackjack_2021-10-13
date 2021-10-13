package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardDisplayTest {

    @Test
    void testDisplayTenAsString(){
        Card card = new Card(Suit.SPADES, Rank.TEN);
        String result = ConsoleCard.display(card);
        assertThat(result).isEqualTo("\u001B[30m┌─────────┐\u001B[1B\u001B[11D│10       │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♠    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│       10│\u001B[1B\u001B[11D└─────────┘");
    }

    @Test
    void displayNonTenAsString() {
        Card card = new Card(Suit.SPADES, Rank.ACE);
        String result = ConsoleCard.display(card);
        assertThat(result).isEqualTo("\u001B[30m┌─────────┐\u001B[1B\u001B[11D│A        │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│    ♠    │\u001B[1B\u001B[11D│         │\u001B[1B\u001B[11D│        A│\u001B[1B\u001B[11D└─────────┘");
    }
}
