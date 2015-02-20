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
package project05;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public  class Project05 {

    public static BigInteger fastExp(BigInteger x, BigInteger n) {

        if (n.equals(BigInteger.ZERO)) {

            return BigInteger.ONE;
        }
        else if (n.and(BigInteger.valueOf(1)).equals(BigInteger.ZERO)) {

            return fastExp(x.multiply(x), n.divide(BigInteger.valueOf(2)));
        } else {

            return x.multiply(fastExp(x, (n.subtract(BigInteger.ONE).and(BigInteger.valueOf(1)))));
        }
    }
    
    public static void main(String[] args) {
        
        MillerRabin ml = new MillerRabin();
        FermatTest ft = new FermatTest();
        Random rnd = new Random();

        BigInteger primeNum = new BigInteger(2049,rnd);
        
        //Primality Tests
        System.out.println(primeNum);
        System.out.println("Bit Length : " + primeNum.bitLength());
        //System.out.println(ft.fermatTest(primeNum, 20));
        //System.out.println(ml.millerRabin(primeNum, 2));
        System.out.println("-----------------");
        System.out.println("");
        
        BigInteger primeNum2 = Project05.fastExp(BigInteger.valueOf(2), BigInteger.valueOf(2048));
        System.out.println(primeNum2);
        System.out.println("Bit Lenght : " + primeNum2.bitLength());
        System.out.println("-----------------");
        System.out.println("");
        
        System.out.println("10 Large Prime Numbers");
        System.out.println("-----------------");
        
        BigInteger primes[] = new BigInteger[10];
        
        for (int i = 1; i < 10; i++) {
            
            primes[i] = fastExp(BigInteger.valueOf(2), BigInteger.valueOf(2048));
            
        }
        
        for (int i = 1; i < 10; i++) {
            
            System.out.println(primes[i]);
            System.out.println("Bit Lenght : " + primes[i].bitLength());
            System.out.println("-----------------");
        }
        
        System.out.println();
    }
}
