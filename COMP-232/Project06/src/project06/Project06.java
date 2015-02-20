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
package project06;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public class Project06 {

    int cutThePipeRecursive(int[] prices, int n) {

        if (n == 0) {
            return 0;
        }
        int maxRevenue = Integer.MIN_VALUE; // Minumum integer value = -2147483648

        for (int i = 1; i < n; i++) {

            maxRevenue = Math.max(maxRevenue, prices[i] + cutThePipeRecursive(prices, n - i - 1));
        }
        return maxRevenue;
    }

    int cutThePipeMemoized(int[] prices, int n) {

        int arr[] = new int[prices.length + 1];
        Arrays.fill(arr, Integer.MIN_VALUE); // Minumum integer value = -2147483648
        return memoizedHelper(prices, n, arr);
    }

    int memoizedHelper(int[] prices, int n, int[] arr) {

        if (arr[n] >= 0) {
            return arr[n];
        }
        int maxRevenue = 0;

        if (n != 0) {

            maxRevenue = Integer.MIN_VALUE; // Minumum integer value = -2147483648

            for (int i = 1; i <= n; i++) {

                maxRevenue = Math.max(maxRevenue, prices[i - 1] + memoizedHelper(prices, n - i, arr));
            }

            arr[n] = maxRevenue;
        }

        return maxRevenue;

    }

    public static void main(String[] args) {

        Project06 pj = new Project06();
        Random rnd = new Random();
        
        int[] prices = {9,1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] prices2 = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30, 34, 40, 44, 50, 54, 64, 74, 90};
        
        int[] prices3 = new int[50];
        int[] prices4 = new int[1000];
        
        
        //Short-cut to filling arrays
         Arrays.fill(prices3, rnd.nextInt(50));
         //Arrays.fill(prices4, rnd.nextInt(100));
        
         //Recursive Solutions O(n^2)
        System.out.println("Recursive Solution");
        System.out.println(pj.cutThePipeRecursive(prices, prices.length));
        System.out.println(pj.cutThePipeRecursive(prices2, prices2.length));
        //System.out.println(pj.cutThePipeRecursive(prices3, prices3.length));
        //System.out.println(pj.cutThePipeRecursive(prices4, prices4.length));
        //Takes long time to respond. Increasing exponentialy.
        
        System.out.println("");
        
        //Dynamic Programming Solutions
        System.out.println("Dynamic Programming Solution");
        System.out.println(pj.cutThePipeMemoized(prices, prices.length));
        System.out.println(pj.cutThePipeMemoized(prices2, prices2.length));
        System.out.println(pj.cutThePipeMemoized(prices3, prices3.length));
        //System.out.println(pj.cutThePipeMemoized(prices4, prices4.length));
        //Takes long time to respond but better than recursive way.
    }

}
