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

/**
 * 
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
    public  class MillerRabin {

        public int[] values = {2,3,5,7,11,13,17,19,23,29,31,37,41};
        
        public boolean primalityTest(BigInteger n, BigInteger a, int s, BigInteger d) {

            int i = 0;
            
            while (i < s) {

                BigInteger exp = BigInteger.valueOf(2).pow(i);
                exp = exp.multiply(d);
                BigInteger res = a.modPow(exp, n);

                if (res.equals(n.subtract(BigInteger.ONE)) || res.equals(BigInteger.ONE)) {
                    return true;
                }
            }
            return false;
        }
        
        public boolean millerRabin(BigInteger testValue, int bases){
            
            BigInteger d = testValue.subtract(BigInteger.ONE);
            int s = 0;
            
            while(d.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)){
                
                s++;
                d = d.divide(BigInteger.valueOf(2));
            }
            System.out.println("Base ");
            
            for(int i=0; i<bases; i++){
                
                //Composite
                BigInteger a = BigInteger.valueOf(values[i]);
                boolean r = primalityTest(testValue, a, s, d);
                System.out.println(values[i] + " ");
                
                if(!r){
                    return false;
                }
            }
            return true;
        }
    }