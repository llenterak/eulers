package org.sealoflove.zero.five;


import org.sealoflove.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task054 implements Task {

    String path = "/home/llenterak/IdeaProjects/eulers/euler/src/resources/p054.txt";


    private static byte MAX_LEVEL = 14;

    @Override
    public String getResult() {
        List<Game> games =  readDataFromFile();

        return "" + games.stream().filter(z -> z.player1.winsOver(z.player2)).count();
    }






    private List<Game> readDataFromFile() {
        List<Game> res = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEachOrdered(z -> {
                res.add(new Game(z));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }




    private class Game {
        public final Hand player1;
        public final Hand player2;
        public final String initialString;

        public Game(String input) {
            this.initialString = input;
            player1 = new Hand(input.substring(0, input.length() / 2));
            player2 = new Hand(input.substring(input.length() / 2 + 1));
//            System.out.println()
        }
    }

    private class Hand {
        public Card[] cards = new Card[5];
        public byte[] counts = new byte[15];

        public String toString() {
            String out = "";
            for (Card card : cards) {
                out = out + String.format("%2d%s ", card.level, card.color);
//                out = out + " " + card.level+card.color;
            }
            return out;
        }

        public Hand(String serialized) {
            String[] split = serialized.split(" ");
            try {
                Object[] objects = Stream.of(split)
                        .map(item -> new Card(getLevel(item.charAt(0)), item.charAt(1)))
                        .sorted()
                        .toArray();


                for (int i = 0; i < cards.length; i++) {
                    cards[i] = (Card) objects[i];
                    counts[cards[i].level]++;

                }
            } catch ( Exception exc) {
                throw new RuntimeException(exc);
            }

        }


/*
* High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
* */


        String[] levels = {"straight flush", "four kind", "full house", "flush", "Straight", "3 kind", "two pairs", "Pair", "Top"};


        
        public boolean winsOver(Hand o) {
            int[] deltas = new int[10];
            deltas[0] = this.getHighestStraightFlush() - o.getHighestStraightFlush();
            deltas[1] = this.getHighestFourOfAKind() - o.getHighestFourOfAKind();
            deltas[2] = this.getHighestFullHouse() - o.getHighestFullHouse();
            deltas[3] = this.getHighestFlush() - o.getHighestFlush();
            deltas[4] = this.getHighestStraight() - o.getHighestStraight();
            deltas[5] = this.getHighestThreeOfAKind() - o.getHighestThreeOfAKind();
            deltas[6] = this.getHighestTwoPair() - o.getHighestTwoPair();
            deltas[7] = this.getHighestPair() - o.getHighestPair();
            deltas[8] = this.getHighestTopCard() - o.getHighestTopCard();

            for (int i = 0; i <= 8; i++) {
                if (deltas[i] > 0) {
                    System.out.println( "+++" + this.toString() + " wins over " + o.toString() + " with " + levels[i]);
                    return true;
                }
                if (deltas[i] < 0) {
                    System.out.println("---" + o.toString() + " wins over " + this.toString() + " with " + levels[i]);
                    return false;
                }
            }
//            this.getHighestPair();
//            o.getHighestPair();
            throw new RuntimeException("should not get here");

        }

        private byte getHighestPair() {
            for (int i = counts.length - 1; i >= 0; i--) {
                if (counts[i] > 1)
                    return (byte)i;
            }
            return 0;

//            byte maxPair = 0;
//            for (int i = 0; i < cards.length - 1 ; i++) {
//                for (int j = i + 1; j <= i; j++) {
//                    if (cards[i].sameLevel(cards[i])) {
//                        if (cards[i].level > maxPair) {
//                            maxPair = cards[i].level;
//                        }
//                    }
//
//                }
//            }
//            return maxPair;
        }

        private byte getHighestTopCard() {
            byte max = 0;
            for (int i = 0; i < cards.length; i++) {
                if (cards[i].level > max)
                    max = cards[i].level;
            }
            return max;
        }

        private byte getHighestTwoPair() {
            int pairCounts = 0;
            int maxPair = 0;
            for (int i = counts.length - 1; i >= 0; i--) {
                if (counts[i] == 2) {
                    pairCounts ++;
                    if (maxPair < i)
                        maxPair = i;
                }
            }
            if (pairCounts == 2)
                return (byte) maxPair;
            else
                return 0;
//            byte maxPair = 0;
//            int pairsCount = 0;
//            for (int i = 0; i < cards.length - 1 ; i++) {
//                for (int j = i + 1; j <= i; j++) {
//                    if (cards[i].sameLevel(cards[i])) {
//                        if (cards[i].level > maxPair) {
//                            pairsCount++;
//                            maxPair = cards[i].level;
//                        }
//                    }
//
//                }
//            }
//            if (pairsCount > 1)
//                return maxPair;
//            return 0;
        }

        private byte getHighestThreeOfAKind() {
            for (byte i = 0; i < counts.length; i++)
                if (counts[i] >= 3)
                    return i;
            return 0;
        }

        private byte getHighestStraight() {
            for (int i = 0; i < cards.length - 1; i++) {
//                if (!cards[i].sameColor(cards[i+1]))
//                    return 0;
                if (cards[i+1].level - cards[i].level != 1)
                    return 0;
            }
            return cards[cards.length-1].level;
        }

        private byte getHighestFlush() {
            for (int i = 0; i < cards.length - 1; i++) {
                if (!cards[i].sameColor(cards[i+1]))
                    return 0;
//                if (cards[i+1].level - cards[i].level != 1)
//                    return 0;
            }
            return cards[cards.length-1].level;
        }

        private byte getHighestFullHouse() {
            boolean threeFound = false;
            boolean twoFound = false;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == 3)
                    threeFound = true;
                if (counts[i] == 2)
                    twoFound = true;
            }
            if (threeFound && twoFound) {
                return cards[cards.length-1].level;
            } else return 0;
        }

        private byte getHighestFourOfAKind() {
            for (byte i = 0; i < counts.length; i++) {
                if (counts[i] == 4)
                    return i;
            }
            return 0;
        }

        private byte getHighestStraightFlush() {
            for (int i = 0; i < cards.length - 1; i++) {
                if (!cards[i].sameColor(cards[i+1]))
                    return 0;
                if (cards[i+1].level - cards[i].level != 1)
                    return 0;
            }
            return cards[cards.length-1].level;
        }





        private byte getLevel(char c) {
            if (c <= '9' && c >= '2')
                return (byte) (c - '0');

            switch (c) {
                case 'T' : return 10;
                case 'J' : return 11;
                case 'Q' : return 12;
                case 'K' : return 13;
                case 'A' : return 14;
                default: throw new RuntimeException("" + c);
            }
        }

    }


    private class Card implements Comparable<Card> {

        public final byte level;
        public final char color;

        public Card(byte level, char color) {
            this.level = level;
            this.color = color;
        }

        private boolean sameLevel(Card other) {
            return other.level == this.level;
        }

        private boolean sameColor(Card other) {
            return other.color == this.color;
        }

        @Override
        public int compareTo(Card o) {
            if (o.level == this.level)
                return this.color - o.color;
            else return this.level - o.level;
        }
    }


}

