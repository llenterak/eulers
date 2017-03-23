package org.sealoflove.zero.six;


import org.apache.commons.math3.primes.Primes;
import org.apache.commons.math3.util.Pair;
import org.sealoflove.Task;
import org.sealoflove.zero.zero.Task003;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Task060 implements Task {



    private static final int LIMIT = 10000;


    public String getResult() {
        populatePrimesTill(LIMIT);

        return "" + buildCluster();
    }




    private int max(List<Integer> elements) {
        int max = 0;
        for (Integer element : elements)
            if (element > max)
                max = element;
        return max;
    }

    private Set<String> primeCombinations = new HashSet<>();

    private int buildCluster() {
        List<List<Integer>> candidates = new ArrayList<>();



        for (int i = 0; i < primes.length-2; i++) {
            if (i % 100 == 0)
                System.out.print(" " + i);
            for (int j = i+1; j < primes.length-1; j++) {
                String s1 = "" + primes[i];
                String s2 = "" + primes[j];
                if (isPrime(s1 + s2) && isPrime(s2 + s1)) {
                    primeCombinations.add(s1 + s2);
                    primeCombinations.add(s2 + s1);

                    candidates.add(Arrays.asList(primes[i], primes[j]));
                }
            }
        }

//        groups.addAll(pairs);
        for (int i = 0; i < 3; i++) {
            List<List<Integer>> groups = new ArrayList<>();
            for (List<Integer> candidate: candidates) {
                for (int j = primeToItsInt.get(max(candidate)); j < primes.length - 1; j++) {
                    if (!candidate.contains(primes[j])) {
                        List<Integer> internalCandidates = new ArrayList<>();
                        internalCandidates.addAll(candidate);
                        internalCandidates.add(primes[j]);

                        if (interestingGroup(internalCandidates)) {
                            groups.add(internalCandidates);
                            printList(internalCandidates);
                        }

                    }

                }
            }
            candidates = groups;
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> candidate : candidates) {
            if (candidate.size() == 5) {
                printList(candidate);
                int sum = candidate.stream().mapToInt(z -> z).sum();
                if (min > sum)
                    min = sum;
            }
        }


        return min;

    }

    private void printList(List<Integer> list) {
        System.out.println(list.stream()
                .map(Object::toString).collect(joining(", ")));
    }


    private boolean isPrime(String s) {
        long parsed = Long.parseLong(s);
        if (primes[primes.length-1] < parsed)
            return isPrimeStupid(parsed);
        else
            return primesSet.contains((int)parsed);
    }

    private boolean isPrimeStupid(long parsed) {
        double limit = Math.sqrt((double)parsed);
        for (long i = 2; i < limit + 1; i++) {
            if (parsed % i == 0)
                return false;
        }
        return true;
    }

    private boolean interestingGroup(List<Integer> group) {
        for (int i = 0; i < group.size()-1; i++) {
            for (int j = i+1; j < group.size(); j++) {
                String s1 = "" + group.get(i) + group.get(j);
                String s2 = "" + group.get(j) + group.get(i);
//                if (!isPrime(s1) || !isPrime(s2)) {
                if (!(primeCombinations.contains(s1) && primeCombinations.contains(s2))) {
                    return false;
                }
            }
        }
        return true;
    }




    private void populatePrimesTill(int n) {
//        int lastPrime = 0;
        List<Integer> primesListExternal = Task003.getPrimeNumbers(n);
        primes = new int[primesListExternal.size()];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = primesListExternal.get(i);
//            primes[i] = Primes.nextPrime(lastPrime+1);
//            lastPrime = primes[i];
        }
        primesSet = Arrays.stream(primes).boxed().collect(Collectors.toSet());
        populateMap();
        System.out.println("Finished populating");
    }


    private int[] primes;
    private Set<Integer> primesSet;



    private Map<Integer, Integer> primeToItsInt = new HashMap<>();




    private void populateMap() {
        for (int i = 0; i < primes.length; i++) {
            primeToItsInt.put(primes[i], i);
        }
    }


}
