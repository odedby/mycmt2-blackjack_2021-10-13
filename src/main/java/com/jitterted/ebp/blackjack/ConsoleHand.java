package com.jitterted.ebp.blackjack;

import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleHand {
    static String displayFirstCard(Hand hand) {
        return ConsoleCard.display(hand.cards().get(0));
    }

    public static String cardsAsString(Hand hand) {
        return hand.cards().stream()
                    .map(card -> ConsoleCard.display(card))
                    .collect(Collectors.joining(
                            ansi().cursorUp(6).cursorRight(1).toString()));
    }
}
