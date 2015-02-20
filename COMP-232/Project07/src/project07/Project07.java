/*
 * The MIT License
 * Copyright 2014 Semih Onay <semih.onay@bilgiedu.net>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package project07;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public class Project07 {

    /**
     *
     */
    public static String soln = "GTCGTCGGAAGCCGGCCGAA";

    int findLCS(char[] arr1, int start1, char[] arr2, int start2, int lenghtLCS) {

        if (start1 >= arr1.length || start2 >= arr2.length) {
            return lenghtLCS;
        } else if (arr1[start1] == arr2[start2]) {
            return 1 + findLCS(arr1, start1 + 1, arr2, start2, start2 + 1);
        } else {
            return Math.max(findLCS(arr1, start1 + 1, arr2, start2, lenghtLCS), findLCS(arr1, start1 + 1, arr2, start2 + 1, lenghtLCS));
        }
    }

    //Naive Recursive Function
    String lcs(String a, String b) {

        int aLen = a.length();
        int bLen = b.length();

        if (aLen == 0 || bLen == 0) {
            return "";
        } else if (a.charAt(aLen - 1) == b.charAt(bLen - 1)) {
            return lcs(a.substring(0, aLen - 1), b.substring(0, bLen - 1)) + a.charAt(aLen - 1);
        } else {
            String x = lcs(a, b.substring(0, bLen - 1));
            String y = lcs(a.substring(0, aLen - 1), b);
            return (x.length() > y.length()) ? x : y;
        }
    }

    //Memoization Function
    String lcsMemo(String a, String b) {

        int[][] lengths = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                } else {
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
                }
            }
        }
        //Reads substring from matrix
        //StringBuilder is mutable sequence of characters
        StringBuilder buffer = new StringBuilder();
        for (int x = a.length(), y = b.length();
                x != 0 && y != 0;) {
            if (lengths[x][y] == lengths[x - 1][y]) {
                x--;
            } else if (lengths[x][y] == lengths[x][y - 1]) {
                y--;
            } else {
                assert a.charAt(x - 1) == b.charAt(y - 1);
                buffer.append(a.charAt(x - 1));
                x--;
                y--;
            }
        }

        return buffer.reverse().toString();
    }

    public String generateString(Random rng, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    /**
     *
     * @param args
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        Project07 pj7 = new Project07();
        String chars = "ATGCU";
        Random rnd = new Random();

        try {
            FileInputStream reader;
            reader = new FileInputStream("data.txt");

            try (DataInputStream input = new DataInputStream(reader)) {
                BufferedReader buffRead = new BufferedReader(new InputStreamReader(reader));
                String line;

                //System.out.println(pj7.lcsMemo(buffRead.readLine(), buffRead.readLine()));
                //Example given in book and here checking for correctnes.
                String comp;
                comp = pj7.lcsMemo(buffRead.readLine(), buffRead.readLine());
                System.out.println(comp.equals(soln));

                while ((line = buffRead.readLine()) != null) {
                    //System.err.println(pj7.lcs(line, line));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //Random String Generation
        //System.out.println(pj7.generateString(rnd, chars, 1000000));
        //System.out.println(pj7.generateString(rnd, chars, 1000000));
        //Memoized Version Tests
        //System.out.println(pj7.lcsMemo("", "")); // Base Case
        //System.out.println(pj7.lcsMemo("A", "A"));
        //System.out.println(pj7.lcsMemo("B", "A"));
        //System.out.println(pj7.lcsMemo("AAAAGAGACT","AAGTCAGTCA"));
        //System.out.println(pj7.lcsMemo("AAAAAAAAA","AAAAAGTCTA"));
        //System.out.println(pj7.lcsMemo("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA")); // Extreme Case
        //Recursive Tests
        //System.out.println(pj7.lcs("", ""));
        //System.out.println(pj7.lcs("A", "A"));
        //System.out.println(pj7.lcs("B","A"));
        //System.out.println(pj7.lcs("AAAAGAGACT","AAGTCAGTCA"));
        //System.out.println(pj7.lcs("AAAAAAAAA","AAAAAGTCTA"));
        //System.out.println(pj7.lcs("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
    }

}
