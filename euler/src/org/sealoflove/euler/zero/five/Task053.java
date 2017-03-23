package org.sealoflove.euler.zero.five;


import org.sealoflove.euler.Task;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task053 implements Task{


    private Map<Integer, BigInteger> factorials = populateFactorialsMap(0, 100);

    private static BigInteger ONE_MILLION = BigInteger.valueOf(1000*1000);



    @Override
    public String getResult() {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            count += countTermsAboveOneMillion(i);
        }
        return "" + count;
    }


    private int countTermsAboveOneMillion(int n) {
        int count = 0;
        for (int r = 0; r <= n; r++) {
            BigInteger comb = factorials.get(n).divide(factorials.get(r).multiply(factorials.get(n-r)));
            if (comb.compareTo(ONE_MILLION) > 0)
                count++;
        }
        return count;
    }

    private Map<Integer, BigInteger> populateFactorialsMap(int from, int until) {
        return IntStream.range(from, until + 1).boxed()
                .collect(Collectors.toMap(z -> z, this::_factorial));
    }


    private BigInteger _factorial(int n) {
        if (n == 1 || n == 0) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(n).multiply(_factorial(n-1));
        }
    }

}
