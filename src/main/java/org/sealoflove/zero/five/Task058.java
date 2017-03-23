package org.sealoflove.zero.five;


import org.sealoflove.Task;

public class Task058 implements Task {

    long diagonals = 0;
    long primes = 0;


    @Override
    public String getResult() {
        int limit = 2;
        long cursor = 3;
        do {
//            System.out.print(" " + cursor);
            appendToStuff(cursor);
            cursor += limit;
//            System.out.print(" " + cursor);
            appendToStuff(cursor);
            cursor += limit;
            limit++;

//            System.out.print(" " + cursor);
            appendToStuff(cursor);
            cursor += limit;
//            System.out.print(" " + (cursor-1));
            appendToStuff(cursor-1);
//            System.out.print(" size=" + (limit) + " cursor=" + cursor);
//            System.out.println("ratio: " + (primes.size()*1.0 / diagonals.size()));

            if (primes * 1.0 / diagonals < 0.1)
                break;
            cursor += limit;
            limit++;



        } while (limit < 1000000);
        return "" + (limit-2);
    }

    private void appendToStuff(long n) {
        diagonals++;
        if (n < 0) {
            throw new RuntimeException();
        }
        if (isPrime(n)) {
            primes++;
        }
    }

    private boolean isPrime(long n) {
        long limit = (long)Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

}
