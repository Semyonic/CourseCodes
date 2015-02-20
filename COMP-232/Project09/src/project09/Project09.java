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
package project09;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public class Project09 {

    public static String toCompare = "GTCGTCGGAAGCCGGCCGAA";
    public static String toCompare1 = "/'&;_%,!..)/(&%<'>=,&'),'<!";

    int findLCS(String[] arr1, int start1, String[] arr2, int start2, int lenghtLCS) {

        if (start1 >= arr1.length || start2 >= arr2.length) {
            return lenghtLCS;
        } else if (arr1[start1] == null ? arr2[start2] == null : arr1[start1].equals(arr2[start2])) {
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
            return "No Match";
        } else if (a.charAt(aLen - 1) == b.charAt(bLen - 1)) {
            return lcs(a.substring(0, aLen - 1), b.substring(0, bLen - 1)) + a.charAt(aLen - 1);
        } else {
            String x = lcs(a, b.substring(0, bLen - 1));
            String y = lcs(a.substring(0, aLen - 1), b);
            return (x.length() > y.length()) ? x : y;
        }
    }
    //Memoization Function
    String lcsMemo(String toCompare, String source) {

        long[][] lengths = new long[toCompare.length() + 1][source.length() + 1];

        for (int i = 0; i < toCompare.length(); i++) {
            for (int j = 0; j < source.length(); j++) {
                if (toCompare.isEmpty() || source.isEmpty()) {
                    return "Empty";
                }
                if (toCompare.charAt(i) == source.charAt(j)) {
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                } else {
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);
                }
            }
        }
        //Reads substring from matrix, StringBuilder is mutable sequence of characters
        StringBuilder buffer = new StringBuilder();
        for (Integer x = toCompare.length(), y = source.length();
                x != 0 && y != 0;) {
            if (Objects.equals(lengths[x][y], lengths[x - 1][y])) {
                x--;
            } else if (Objects.equals(lengths[x][y], lengths[x][y - 1])) {
                y--;
            } else {
                assert toCompare.charAt(x - 1) == source.charAt(y - 1);
                buffer.append(toCompare.charAt(x - 1));
                x--;
                y--;
            }
        }

        return buffer.reverse().toString();
    }
    /**
     *
     * @param rng
     * @param characters
     * @param length
     * @return
     */
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
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("Max Active Memory: " + Runtime.getRuntime().maxMemory());

        Project09 pj9 = new Project09();
        Random rnd = new Random();
        String chars = "!'^%&/()=?_-<>.,:;";
        String chars2 = "ATGC";
        String chars3 = "!'^%&/()=?_-<>.,:;qwertyuıopğüasdfghjklşizxcvbnmöç";
        int lngt1 = 1000000;
        int lngt2 = 50;

        //Random String Generation
        String pair1 = pj9.generateString(rnd, chars, lngt1);
        String pair2 = pj9.generateString(rnd, chars2, lngt1);
        String pair3 = pj9.generateString(rnd, chars, lngt2);
        String pair4 = pj9.generateString(rnd, chars2, lngt2);
        
        //File Read Operation
        try {
            FileInputStream reader;
            reader = new FileInputStream("data5.txt");

            try (DataInputStream input = new DataInputStream(reader)) {
                BufferedReader buffRead = new BufferedReader(new InputStreamReader(reader));
                String line;

                while ((line = buffRead.readLine()) != null) {
                    System.err.println(pj9.lcsMemo(line, "Semih"));
                }
            }
        } catch (IOException e) {
            System.err.println("Empty");
        }
        //Write randomly generated DNA-Sequence or Character-Sequence to file
//        try {
//
//			String content = pj9.generateString(rnd, chars2, 1000000);
//			File file = new File("data6.txt");
//			// if file doesnt exists, then create it
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//            try (BufferedWriter bw = new BufferedWriter(fw)) {
//                bw.write(content);
//            }
//
//			System.out.println("Done");
//
//		} catch (IOException e) {
//		}
//        try (Scanner sc = new Scanner(new File("data3.txt"), "UTF-8")) {
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//            }
//            if (sc.ioException() != null) {
//                throw sc.ioException();
//            }
//        }

        //Memoized Method
//        System.err.println(pj9.lcsMemo("", ""));
//        System.err.println(pj9.lcsMemo("A", "A"));
//        System.err.println(pj9.lcsMemo("B", "A"));
//        System.err.println(pj9.lcsMemo(pair1, "semih"));
//        System.err.println(pj9.lcsMemo(pair4, pair4));
//        System.err.println(pj9.lcsMemo(pair1, pair3));
//        System.err.println(pj9.lcsMemo(pair2, pair4));

//        //Naive Method
//        System.out.println(pj9.lcs("", ""));
//        System.out.println(pj9.lcs("A", "A"));
//        System.out.println(pj9.lcs("B", "A"));
//        System.out.println(pj9.lcs(pair1, pair3));
        System.out.println(pj9.lcs(pair2, pair4));
    }

}
