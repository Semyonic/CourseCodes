/* 
        _  _  _  _                                     _     _                        _  _  _  _                                                  
      _(_)(_)(_)(_)_                                  (_)   (_)                     _(_)(_)(_)(_)_                                                
     (_)          (_)  _  _  _  _     _  _   _  _   _  _    (_) _  _  _            (_)          (_) _  _  _  _      _  _  _    _               _  
     (_)_  _  _  _    (_)(_)(_)(_)_  (_)(_)_(_)(_) (_)(_)   (_)(_)(_)(_)_          (_)          (_)(_)(_)(_)(_)_   (_)(_)(_) _(_)_           _(_) 
       (_)(_)(_)(_)_ (_) _  _  _ (_)(_)   (_)   (_)   (_)   (_)        (_)         (_)          (_)(_)        (_)   _  _  _ (_) (_)_       _(_)   
      _           (_)(_)(_)(_)(_)(_)(_)   (_)   (_)   (_)   (_)        (_)         (_)          (_)(_)        (_) _(_)(_)(_)(_)   (_)_   _(_)     
     (_)_  _  _  _(_)(_)_  _  _  _  (_)   (_)   (_) _ (_) _ (_)        (_)         (_)_  _  _  _(_)(_)        (_)(_)_  _  _ (_)_    (_)_(_)       
       (_)(_)(_)(_)    (_)(_)(_)(_) (_)   (_)   (_)(_)(_)(_)(_)        (_)           (_)(_)(_)(_)  (_)        (_)  (_)(_)(_)  (_)    _(_)         
                                                                                                                                _  _(_)           
                                                                                                                               (_)(_)             
 * The MIT License
 *
 * Copyright 2013 Semih Onay <semih.onay@bilgiedu.net>.
 *
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

/**
 * 
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */


//Data Definitions
//BST
//  -empty
//  has node or has node and has left-right or with left-right sub-trees
//Examples

//BST((5)),(3)),(8)))
//BST((3)),(2)),(5)),(9)))

public class BSTofComparable {


    BSTofComparable left;
    BSTofComparable right;
    Comparable<Object> data;

    /**
     *
     * @param data vertex
     * @param left left node
     * @param right right node
     */

    @SuppressWarnings("unchecked")
    public BSTofComparable(Comparable data, BSTofComparable left, BSTofComparable right) {

        this.data = data;
        this.left = left;
        this.right = right;
    }

        
     /**
     *
     * @return String in this form : Left-Vertex-Right
     */
    public String printLVR() {

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
     *
     * @param tree Binary Search Tree.
     * @param toFind input for search.
     * @return given input is in the tree or not.
     */
    
    //Contract
    //
    //binarySearch: tree toFind --> boolean 
    //
    //Example
    //
    //binarySearch(tree,toFind) --> true
    //binarySearch(tree,toFind) --> false
    
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

    //Contract
    //
    //getRightMost: tree --> data
    //
    //Purpose
    //to get right-most data in tree
    
    //Examples
    //getRightMost(tree) --> (data)
    //getRightMost(null) --> null
    
    /**
     *
     * @param t
     * @return
     */
        
    public Comparable<Object> getRightMost(BSTofComparable t) {

        if (t.right == null) {
            return t.data;
        }
        return getRightMost(t.right);
    }

    //Contract
    //
    //getLefttMost: tree --> data
    //
    //Purpose
    //to get left-most data in tree
    
    //Examples
    //getLeftMost(tree) --> (data)
    //getLeftMost(null) --> null
    
    /**
     *
     * @param t
     * @return
     */
        
    public Comparable<Object> getLeftMost(BSTofComparable t) {

        if (t.left == null) {
            return t.data;
        }
        return getLeftMost(t.left);
    }

    /**
     *
     * @param t Binary Search Tree
     * @return Binary Search Tree
     */
    public BSTofComparable deleteLeftMost(BSTofComparable t) {

        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t.right;
        } else {
            return new BSTofComparable(t.data, deleteLeftMost(t.left), t.right);
        }
    }

    /**
     *
     * @param t Binary Search Tree.
     * @param toInsert input for insertion fucntion.
     * @return Binary Search Tree with given input as inserted.
     */
    public BSTofComparable insert(BSTofComparable t, Integer toInsert) {

        if (t == null) {
            return new BSTofComparable(toInsert, null, null);
        } else if (t.data.equals(toInsert)) {
            return new BSTofComparable(toInsert, left,right);

        } else if (t.data.compareTo(toInsert) > 0) {

        } else if (t.data.compareTo(toInsert) < 0) {
            return new BSTofComparable(t.data, t.right, insert(t.left, toInsert));
        } else {
            return new BSTofComparable(t.data, t.left, insert(t.right, toInsert));
        }
        return t;
    }

    /**
     *
     * @param t
     * @param toDelete
     * @return
     */
    public BSTofComparable delete(BSTofComparable t, Integer toDelete) {

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
     *
     * @param t Binary Search Tree.
     * @return Depth of a given tree.
     */
    public int findDepth(BSTofComparable t) {

        if (t == null) {
            return 0;
        } else {
            return (1 + Math.min(findDepth(t.right), findDepth(t.left)));
        }
    }
            

    /**
     *
     * @param t Binary Search Tree.
     * @return Height of a given tree.
     */
    public int findHeight(BSTofComparable t) {

        if (t == null) {
            return 0;
        } else {
            return (1 + Math.max(findHeight(t.right), findHeight(t.left)));
        }
    }

    /**
     *
     * @param t Binary Search Tree
     * @return Binary Search Tree whose data deleted in RightMost
     */
    public BSTofComparable deleteRightMost(BSTofComparable t) {

        if (t == null) {
            return null;
        } else if (t.right == null) {
            return t.left;
        } else {
            return new BSTofComparable(t.data, deleteRightMost(t.right), t.left);
        }
    }

    /**
     *
     * @param t Binary Search Tree.
     * @return given Binary Search Tree is in perfectBST or not.
     */

     public boolean isPerfectBST(BSTofComparable t) {
        return (findHeight(t) - findDepth(t) <= 1);
    }

    /**
     *
     * @param o
     * @return
     */
    public Comparable compareTo(BSTofComparable o) { // check
        
        Comparable n =o.compareTo(o);
        return n;
    }
    
    /**
     *
     * @param args
     */
    public  void main(String []args){
        
        
    }

}
