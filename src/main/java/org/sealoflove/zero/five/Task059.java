package org.sealoflove.zero.five;


import org.sealoflove.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Task059 implements Task {

    String path = "/home/llenterak/IdeaProjects/eulers/euler/src/resources/p059_cipher.txt";


//    private static byte MAX_LEVEL = 14;


    String decode(char[] message) {
        for (char c1 = 'a'; c1 < 'z'; c1++) {
            for (char c2 = 'a'; c2 < 'z'; c2++) {
                for (char c3 = 'a'; c3 < 'z'; c3++) {
                    char[] key = {c1, c2, c3};
                    String decrypted = decrypt(message, key);
                    if (decrypted.contains("Gospel of "))
//                        candidates.add(decrypted);
                        return decrypted;
                }
            }
        }
        return "";
    }

    @Override
    public String getResult() {

        List<String> candidates = new ArrayList<>();
        char[] encoded = readDataFromFile();
        String decoded = decode(encoded);
        int sum = 0;
        for (char ch : decoded.toCharArray()) {
            sum += ch;
        }

//        for (String candidate : candidates) {
//            System.out.println(candidate);
//        }

        return "" + sum;
    }


    private String decrypt(char[] message, char[] key) {
        char[] copy = new char[message.length];
        for (int i = 0; i < message.length; i++) {
            copy[i] = (char)(message[i] ^ key[i % key.length]);
        }
        return String.valueOf(copy);
    }



    private char[] readDataFromFile() {
        List<String[]> res = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEachOrdered(z -> res.add( z.split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] array = res.stream().flatMap(z -> Arrays.stream(z).mapToInt(Integer::parseInt).boxed()).mapToInt(z -> z).toArray();
        char[] trueRes = new char[array.length];
        for  (int i = 0; i < array.length; i++) {
            trueRes[i] = (char)array[i];
        }
        return trueRes;
    }

}
