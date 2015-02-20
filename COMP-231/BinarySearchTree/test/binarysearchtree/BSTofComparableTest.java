/*            
 * The MIT License

 * Copyright 2014 Semih Onay <semih.onay@bilgiedu.net>
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
package binarysearchtree;

import static junit.framework.Assert.assertEquals;

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public class BSTofComparableTest {

    public BSTofComparableTest() {

        BSTofComparable tree;
        tree = new BSTofComparable(5,
                new BSTofComparable(4,
                        new BSTofComparable(1,
                                new BSTofComparable(8,
                                        new BSTofComparable(9,
                                                new BSTofComparable(19, null,
                                                        new BSTofComparable(21, null, null)), null), null), null),
                        new BSTofComparable(6, null, null)),
                new BSTofComparable(7, null, null));

        assertEquals(true, BSTofComparable.binarySearch(null, 8));
        assertEquals(tree, BSTofComparable.getLeftMost(tree));
        assertEquals(tree, BSTofComparable.getRightMost(tree));
        assertEquals(tree, BSTofComparable.findDepth(tree));
        assertEquals(tree, BSTofComparable.findHeight(tree));
        assertEquals(tree, BSTofComparable.isPerfectBST(tree));

    }
}
