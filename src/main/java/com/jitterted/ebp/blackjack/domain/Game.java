package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.adapter.in.console.*;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

public class Game {

    private final Deck deck;

    private final Hand dealerHand = new Hand();
    private final Hand playerHand = new Hand();
    private boolean playerDone;

    public Game() {
        deck = new Deck();
    }

    public Game(Deck deck) { this.deck = deck; }

    public void initialDeal() {
        dealRoundOfCards();
        dealRoundOfCards();
    }

    public void dealRoundOfCards() {
        // why: players first because this is the rule
        playerHand.drawFrom(deck);
        dealerHand.drawFrom(deck);
        if (playerHand.isBlackJack()) playerBlackjacks();
    }

    public GameOutcome determineOutcome() {
        if (playerHand.isBusted()) {
            return GameOutcome.PLAYER_BUSTS;
        } else if (dealerHand().isBusted()) {
            return GameOutcome.DEALER_BUSTS;
        } else if (playerHand.pushes(dealerHand())) {
            return GameOutcome.PUSH;
        } else if (playerHand.isBlackJack()) {
            return GameOutcome.BLACKJACK;
        } else if (playerHand.beats(dealerHand())) {
            return GameOutcome.PLAYER_WINS;
        } else {
            return GameOutcome.DEALER_WINS;
        }
    }

    public void dealerTurn() {
        // Dealer makes its choice automatically based on a simple heuristic (<=16 must hit, =>17 must stand)
        if (!playerHand.isBusted()) {
            while (dealerHand().dealerMustDrawCard()) {
                dealerHand().drawFrom(deck);
            }
        }
    }

    public Hand dealerHand() {
        return dealerHand;
    }

    public Hand playerHand() {
        return playerHand;
    }

    public void playerHits() {
        playerHand.drawFrom(deck);
        playerDone = playerHand.isBusted();
    }

    public void playerStands() {
        playerDone = true;
    }

    public void playerBlackjacks() {
        playerDone = true;
    }

    public boolean isPlayerDone() {
        return playerDone;
    }

}
