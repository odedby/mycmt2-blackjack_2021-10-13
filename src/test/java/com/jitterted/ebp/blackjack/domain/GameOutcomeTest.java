package com.jitterted.ebp.blackjack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameOutcomeTest {

    @Test
    public void testPlayerBustsAndLoses() {
        Deck deck = new StubDeck(
                new Card(Suit.SPADES, Rank.TEN),    //  Player card
                new Card(Suit.HEARTS, Rank.TEN),    //  Dealer card
                new Card(Suit.SPADES, Rank.EIGHT),  //  Player card
                new Card(Suit.SPADES, Rank.FIVE),   //  Dealer card
                new Card(Suit.CLUBS, Rank.SIX)      //  Player card
        );
        Game game = new Game(deck);
        game.initialDeal();
        game.playerHits();
        GameOutcome outcome = game.determineOutcome();

        Assertions.assertThat(outcome).isEqualTo(GameOutcome.PLAYER_BUSTS);
    }

    @Test
    public void testPlayerBeatsDealer() {
        Deck deck = new StubDeck(
                new Card(Suit.SPADES, Rank.TEN),    //  Player card
                new Card(Suit.HEARTS, Rank.TEN),    //  Dealer card
                new Card(Suit.SPADES, Rank.EIGHT),  //  Player card
                new Card(Suit.SPADES, Rank.FIVE),   //  Dealer card
                new Card(Suit.CLUBS, Rank.THREE),   //  Player card
                new Card(Suit.DIAMONDS, Rank.THREE) //  Dealer card
        );
        Game game = new Game(deck);
        game.initialDeal();
        game.playerHits();
        game.playerStands();
        game.dealerTurn();
        GameOutcome outcome = game.determineOutcome();

        Assertions.assertThat(outcome).isEqualTo(GameOutcome.PLAYER_WINS);
    }

    @Test
    public void testPlayerBlackJack() {
        Deck deck = new StubDeck(
                new Card(Suit.SPADES, Rank.TEN),    //  Player card
                new Card(Suit.HEARTS, Rank.TEN),    //  Dealer card
                new Card(Suit.SPADES, Rank.ACE),  //  Player card
                new Card(Suit.SPADES, Rank.FIVE)   //  Dealer card
        );
        Game game = new Game(deck);
        game.initialDeal();
        GameOutcome outcome = game.determineOutcome();

        Assertions.assertThat(outcome).isEqualTo(GameOutcome.BLACKJACK);
    }

    @Test
    public void testBothBlackJackAndPush() {
        Deck deck = new StubDeck(
                new Card(Suit.SPADES, Rank.TEN),    //  Player card
                new Card(Suit.HEARTS, Rank.TEN),    //  Dealer card
                new Card(Suit.SPADES, Rank.ACE),  //  Player card
                new Card(Suit.HEARTS, Rank.ACE)   //  Dealer card
        );
        Game game = new Game(deck);
        game.initialDeal();
        GameOutcome outcome = game.determineOutcome();

        Assertions.assertThat(outcome).isEqualTo(GameOutcome.PUSH);
    }
}
