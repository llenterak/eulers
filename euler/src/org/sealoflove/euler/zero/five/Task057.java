package org.sealoflove.euler.zero.five;


import org.sealoflove.euler.Task;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Task057 implements Task {


    @Override
    public String getResult() {
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            calculateApproximation(i);
//            System.out.println(fractions[i-1]);
            if (digitsCount(fractions[i-1].nom) > digitsCount(fractions[i-1].denom))
                count++;
        }
//        System.out.println(calculateApproximation(1));
//        System.out.println(calculateApproximation(2));
//        System.out.println(calculateApproximation(3));
//        System.out.println(calculateApproximation(4));

        return "" + count;
    }


    private Fraction[] fractions = new Fraction[1000];

    private final Fraction ONE = new Fraction(1,1);
//    private final Fraction TWO = new Fraction(2,1);

    Fraction calculateApproximation(int precision) {
        if (precision == 1) {
            fractions[precision-1] = ONE.sum(new Fraction(1, 2));

        } else {
            fractions[precision-1] = ONE.sum(ONE.sum(fractions[precision-2]).inverse());
//            return ONE.sum(ONE.sum(calculateApproximation(precision - 1)).inverse());


//            return 1 + 1/(1 + calculateApproximation(precision - 1));
        }
        return fractions[precision-1];
    }


    private class Fraction {
        public final BigInteger nom;
        public final BigInteger denom;

        public Fraction(BigInteger nom, BigInteger denom) {
            this.nom = nom;
            this.denom = denom;
        }

        public Fraction (int nom, int denom) {
            this.nom = BigInteger.valueOf(nom);
            this.denom = BigInteger.valueOf(denom);
        }

        public Fraction(long nom, long denom) {
            this.nom = BigInteger.valueOf(nom);
            this.denom = BigInteger.valueOf(denom);
        }

        public Fraction sum(int n) {
            return new Fraction(this.denom.multiply(BigInteger.valueOf(n)).add(this.nom), this.denom);
        }

        public Fraction sum(Fraction other) {
            return new Fraction(this.nom.multiply(other.denom).add(other.nom.multiply(this.denom)), this.denom.multiply(other.denom));
        }

        public Fraction inverse() {
            return new Fraction(this.denom, this.nom);
        }
//        public double doubleValue() {
//            return (this.nom * 1.0) / this.denom;
//        }

        public String toString() {
            return this.nom + "/" + this.denom;
        }
    }


    private int digitsCount(BigInteger n) {
//        int count = 1;
//        while (n > 10) {
//            n = n / 10;
//            count++;
//        }
        return n.toString().length();
    }

}
