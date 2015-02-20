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
package project08;

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public class Project08 {

    public int numOfChars = 256;

    int naiveMethod(char[] T, char[] P) {

        for (int i = 0; i <= Math.min(T.length, P.length); i++) {

            if (P[i] == T[i + 1]) {
                System.out.println(i);
            }
        }
        return -1;
    }

    int charToIndex(char c, int[] invertE) {

        return invertE[(int) c];

    }

    int getNextState(char[] pattern, int m, int state, int x) {

        if (state < m && x == pattern[state]) {
            return state + 1;
        }

        int ns;

        for (ns = state; ns > 0; ns--) {

            if (pattern[ns - 1] == x) {

                for (int i = 0; i < ns - 1; i++) {

                    if (pattern[i] != pattern[state - ns + 1 + i]) {
                        break;
                    }

                    if (i == ns - 1) {
                        return ns;
                    }
                }

            }

        }

        return 0;
    }

    void transitionFunction(char[] pattern, int m, int[][] transition) {

        for (int state = 0; state <= m; state++) {
            for (int x = 0; x < numOfChars; x++) {
                transition[state][x] = getNextState(pattern, m, state, x);
            }
        }
    }

    void match(char[] pattern, char[] text) {

        int m = pattern.length;
        int n = text.length;
        int state = 0;
        int[][] transition = new int[m + 1][numOfChars];

        transitionFunction(pattern, m, transition);

        for (int i = 0; i < n; i++) {

            state = transition[state][text[i]];
            if (state == m) {
                System.out.println(i - m + 1);
            }
        }
    }

    int[] invertE(char[] sigma) {

        int[] output = new int[numOfChars];

        for (int i = 0; i < sigma.length; i++) {

            output[(int) sigma[i]] = i;
        }

        return output;
    }

    int findMatch(char[][] FSA, char[] text) {

        int state = 0;

        for (int i = 0; i < text.length; i++) {

            state = FSA[state][charToIndex(text[i], invertE(text))];

            if (state == FSA.length - 1) {
                return i;
            }
        }

        return -1;
    }

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        Project08 pj8 = new Project08();

        //int[][] FSA = new int[5][5];
        //FSA[0][0] = 1;
        //FSA[0][1] = 2;
        char[] alph0 = {' '};
        char[] alph = {'A', 'A', 'B', 'A', 'A', 'C', 'A', 'A', 'D','B','B','C','A'};
        char[] look = {'A', 'A', 'B', 'A'};

        //System.out.println(pj8.naiveMethod(alph0, look));
        System.out.println(pj8.naiveMethod(alph, look));
        //pj8.match(alph, look);
        //System.out.println(pj8.findMatch(FSA, look));
        //System.out.println(pj8.findMatch(FSA, alph));
    }

}
