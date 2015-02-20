/*         
 * The MIT License
 *
 * Copyright 2013 Semih Onay <semih.onay@bilgiedu.net>
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

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public  class BSTofComparable {

    BSTofComparable left;
    BSTofComparable right;
    Comparable<Object> data;

    /**
     * <b>Purpose :</b>
     * <p>
     * creating BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param data Vertex
     * @param left Left node
     * @param right Right node
     */
    @SuppressWarnings("unchecked")
    public  BSTofComparable(Comparable data, BSTofComparable left, BSTofComparable right) {

        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * <p>
     * <b><u>Purpose :</u></b>
     * to print data in string type.
     * <p>
     * <b><u>Contract</u></b>
     *
     * @return String in this form : Left-Vertex-Right
     */
    public  String printLVR() {

        String output = "";
        if (left != null) {
            output += "(" + left.printLVR();
        }
        if (data != null) {
            output += "(" + data + ")";
        }
        if (right != null) {
            output += "(" + right.printLVR();

        }
        return output;
    }

    /**
     * <b>Purpose :</b>
     * to search given input in BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param tree is a BinarySearchTree.
     * @param toFind input for search operation.
     * @return given input is in the tree or not.
     */
    public static boolean binarySearch(BSTofComparable tree, Comparable toFind) {

        if (tree.data == null || toFind == null) {
            return false;
        } else {

            if (tree.data == toFind) {
                return true;
            } else {

                if (tree.data.compareTo(toFind) < 0) {
                    return binarySearch(tree.right, toFind);
                }
                if (tree.data.compareTo(tree.left) > 0) {
                    return binarySearch(tree.left, toFind);
                }
            }
        }
        return false;
    }

    /**
     * <b><u>Purpose :</u></b>
     * to find a value which located at the most-left side in BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t is a BinarySearchTree
     * @return RightMost value in the tree
     */
    public static Comparable<Object> getRightMost(BSTofComparable t) {

        if (t.right == null) {
            return t.data;
        }
        return getRightMost(t.right);
    }

    /**
     * <b><u>Purpose :</u></b>
     * to find a value which located at the most-left side in BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t is a BinarySearchTree
     * @return LeftMost value in the tree
     *
     */
    public static Comparable<Object> getLeftMost(BSTofComparable t) {

        if (t.left == null) {
            return t.data;
        }
        return getLeftMost(t.left);
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to delete left-most value in BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t Binary Search Tree
     * @return Deleted left-most-valued Binary Search Tree
     */
    public static BSTofComparable deleteLeftMost(BSTofComparable t) {

        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t.right;
        } else {
            return new BSTofComparable(t.data, deleteLeftMost(t.left), t.right);
        }
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to insert given data into BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t Binary Search Tree.
     * @param toInsert input for insertion fucntion.
     * @return Binary Search Tree with given input as inserted.
     */
    public BSTofComparable insert(BSTofComparable t, Comparable toInsert) {

        if (t == null) {
            return new BSTofComparable(toInsert, null, null);
        } else if (t.data.equals(toInsert)) {
            return new BSTofComparable(toInsert, left, right);

        } else if (t.data.compareTo(toInsert) > 0) {

        } else if (t.data.compareTo(toInsert) < 0) {
            return new BSTofComparable(t.data, t.right, insert(t.left, toInsert));
        } else {
            return new BSTofComparable(t.data, t.left, insert(t.right, toInsert));
        }
        return t;
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to delete choosen value in tree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t is a BinarySearchTree
     * @param toDelete variable for deleting requested value in tree
     * @return
     */
    public static BSTofComparable delete(BSTofComparable t, Integer toDelete) {

        if (t == null) {
            return t;
        }
        if (toDelete == 0) {

            t = null;
        } else if (toDelete < 0) {
            t.left = null;
        } else {
            t.right = null;
        }
        return t;
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to balance right side of the BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t is a BinarySearchTree
     * @return balanced tree
     */
    public static BSTofComparable balanceRight(BSTofComparable t) {

        BSTofComparable temp = t.left;
        t.left = temp.right;
        temp.right = t;

        return temp;
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to balance left side of the given BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t is a BinarySearchTree
     * @return balanced tree
     */
    public static BSTofComparable balanceLeft(BSTofComparable t) {

        BSTofComparable temp = t.right;
        t.right = temp.left;
        temp.left = t;

        return temp;
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to find depth of a given tree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t Binary Search Tree.
     * @return Depth of a given BinarySearchTree.
     */
    public static int findDepth(BSTofComparable t) {

        if (t == null) {
            return 0;
        } else {
            return (1 + Math.min(findDepth(t.right), findDepth(t.left)));
        }
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to find height of a given BinarySearchTree
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t Binary Search Tree.
     * @return Height of a given tree.
     */
    public static int findHeight(BSTofComparable t) {

        if (t == null) {
            return 0;
        } else {
            return (1 + Math.max(findHeight(t.right), findHeight(t.left)));
        }
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to delete
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t Binary Search Tree
     * @return Binary Search Tree whose data deleted in RightMost
     */
    public static BSTofComparable deleteRightMost(BSTofComparable t) {

        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t.left;
        } else {
            return new BSTofComparable(t.data, deleteRightMost(t.right), t.left);
        }
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to find given BinarySearchTree is perfectly balanced or not.
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param t Binary Search Tree.
     * @return given Binary Search Tree is in perfectBST or not.
     */
    public static boolean isPerfectBST(BSTofComparable t) {
        return (findHeight(t) - findDepth(t) <= 1);
    }

    /**
     * <p>
     * <b>Purpose :</b>
     * to compare generic type of data
     * <p>
     * <b><u>Contract</u></b>
     *
     * @param o is a BinarySearchTree
     * @return returns comparison resul
     */
    public static Comparable compareTo(BSTofComparable o) { // check

        Comparable n = BSTofComparable.compareTo(o);
        return n;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int x = 2;
        BSTofComparable bst = new BSTofComparable(6,
                new BSTofComparable(5,
                        new BSTofComparable(3,
                                new BSTofComparable(9, null, null),
                                new BSTofComparable(10, null, null)),
                        new BSTofComparable(7, null,
                                new BSTofComparable(4, null, null))), null);

        System.out.println(bst.printLVR());
        System.out.println(BSTofComparable.findHeight(bst));
        System.out.println(BSTofComparable.getLeftMost(bst));
        System.out.println(BSTofComparable.getRightMost(bst));
        System.out.println(BSTofComparable.isPerfectBST(bst));
        System.out.println(BSTofComparable.binarySearch(bst, BSTofComparable.binarySearch(bst, 2)));
    }

}
