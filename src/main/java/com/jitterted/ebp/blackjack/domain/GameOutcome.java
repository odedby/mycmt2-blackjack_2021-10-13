package com.jitterted.ebp.blackjack.domain;

public enum GameOutcome {
    PLAYER_WINS("You beat the Dealer! 💵"),
    PLAYER_BUSTS("You Busted, so you lose.  💸"),
    PUSH("Push: Nobody wins, we'll call it even."),
    DEALER_WINS("You lost to the Dealer. 💸"),
    DEALER_BUSTS("Dealer went BUST, Player wins! Yay for you!! 💵"),
    BLACKJACK("BlackJack!!! 💵💵💵");

    private final String outcome;

    GameOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String outcome(){
        return this.outcome;
    }
}
