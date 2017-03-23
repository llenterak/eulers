package org.sealoflove.euler.zero.five;


import org.sealoflove.euler.Task;

import java.math.BigInteger;

public class Task055 implements Task {



    @Override
    public String getResult() {
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (isLychrel(i))
                count++;
        }

        return "" + count;
    }


    private final static int LIMIT = 50;

    private boolean isLychrel(int n) {
        BigInteger cumul = BigInteger.valueOf(n);
        int i = 0;
        while (i < LIMIT) {
            BigInteger flipped = flip(cumul);
            cumul = cumul.add(flipped);
            if (isPalindrome(cumul))
                return false;
            i++;
        }
        return true;
    }


    private BigInteger flip(BigInteger n) {
        String rev = n.toString();
        char[] chars = new char[rev.length()];
        for (int i = 0; i < rev.length(); i++) {
            chars[i] = rev.charAt(rev.length() - i - 1);
        }

        return new BigInteger(String.valueOf(chars));
    }

    private boolean isPalindrome(BigInteger bg) {
        String s = bg.toString();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i-1))
                return false;
        }
        return true;
    }

}
