package org.sealoflove.zero.five;


import org.sealoflove.Task;

import java.math.BigInteger;

public class Task056 implements Task {


    //defines i to the power of j
    BigInteger[][] powers = new BigInteger[101][101];

    @Override
    public String getResult() {
        int max = 0;
        populatePowers();
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                int dgSum = getDigitSum(powers[i][j]);
                if (dgSum > max)
                    max = dgSum;
            }
        }
        return "" + max;
    }


    private void populatePowers() {

        //init
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                powers[i][j] = BigInteger.ZERO;
            }
        }

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (powers[i][j-1].equals(BigInteger.ZERO)) {
                    powers[i][j] = BigInteger.valueOf(i);
                } else {
                    powers[i][j] = BigInteger.valueOf(i).multiply(powers[i][j-1]);
                }
            }
        }



    }



    private int getDigitSum(BigInteger n) {
        String s = n.toString();
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += (c - '0');
        }
        return sum;
    }

}
