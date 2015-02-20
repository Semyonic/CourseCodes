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
package finalproject;

/**
 *
 * @author Semih Onay - 11176008 <semih.onay@bilgiedu.net>
 */
public class AvlTree {

    public AvlTree() {
        
    }
    
    public AvlNode node;

    /**
     *
     * @param node it's node of AVL
     */
    public AvlTree(AvlNode node) {
        this.node = node;
    }

    /**
     *
     * @return gets AVL node
     */
    public AvlNode getNode() {
        return node;
    }
    
    /**
     *
     * @param node sets AVL node
     */
    public void setNode(AvlNode node) {
        this.node = node;
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * is a method for rotating
     * <p>
     * <b><u>Contract</u></b>
     * @return rotates to left
     */
    public AvlNode RotateLeft(){
        return RotateLeft(node);
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * is a method for rotating
     * <p>
     * <b><u>Contract</u></b>
     * @return rotates to right
     */
    public AvlNode RotateRight(){
        return RotateRight(node);
    }

    
    /**
     ** <p>
     * <b>Purpose :</b>
     * to check AVL is balanced or not
     * <p>
     * <b><u>Contract</u></b>
     * @return state of a node for balancing
     */
    
    public int isBalanced(){
        return isBalanced(node);
    }

    /**
     ** <p>
     * <b>Purpose :</b>
     * to rotate AVL to right
     * <p>
     * <b><u>Contract</u></b>
     * @param node is an AVL node
     * @return rotated AVL
     */
    public AvlNode RotateRight(AvlNode node) {

        AvlNode root = node;
        AvlNode left = root.left;
        AvlNode right = root.right;
        root = new AvlNode(root.key, RotateRight(),right);
        left = new AvlNode(left.key, RotateLeft(), root);
        return right;
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * to rotate AVL to left
     * <p>
     * <b><u>Contract</u></b>
     * @param node is an AVL node
     * @return rotated AVL
     */
    public AvlNode RotateLeft(AvlNode node){
        
        AvlNode root = node;
        AvlNode left = root.left;
        AvlNode right = root.right;
        root = new AvlNode(root.key,RotateLeft(),left);
        right = new AvlNode(right.key,RotateRight(),root);
        return left;
    }

    /**
     ** <p>
     * <b>Purpose :</b>
     * to calculate height of an AVL
     * <p>
     * <b><u>Contract</u></b>
     * @param node is a AVL node
     * @return height of an AVL Tree
     */
    public int AvlHeight(AvlNode node){
        
        if(node != null){
        } else {
            return 0;
        }
        
        int HeightLeft;
        HeightLeft = AvlHeight(node.left);
        
        int HeightRight;
        HeightRight = AvlHeight(node.right);
        
        if(HeightLeft <= HeightRight){
            return HeightRight+1;
        }
        else {
            return HeightLeft +1;
        }
    }
    

    /**
     ** <p>
     * <b>Purpose :</b>
     * to check AVL is balanced or not
     * <p>
     * <b><u>Contract</u></b>
     * @param node is a AVL node
     * @return AVL is empty or not
     */
    public int isBalanced(AvlNode node) {
        
        if(AvlHeight(node.right) - AvlHeight(node.left) < 2) {
            if(AvlHeight(node.left) - AvlHeight(node.right) >=2){
                return -1;
            }
            else {
                return 0;
            }
        } else {
            return 1;
        }       
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * to find minimum value in AVL
     * <p>
     * <b><u>Contract</u></b>
     * @param node is a AVL node
     * @return finds minimum value in AVL
     */
    public AvlNode findMinimum(AvlNode node){
        
        if(null == node){
        } else {
            while(node.left != null){
                node = node.left;
            }
        }
        return node;
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * to delete minimum value in AVL
     * <p>
     * <b><u>Contract</u></b>
     * @param node is an AVL node
     * @return AVL whose minumum value 
     */
    public AvlNode deleteMinimum(AvlNode node){
        if(node == null){
            return node;
        }
        else if(node.left != null){
            node.left = deleteMinimum(node.left);
        }
        else {
            return node.right;
        }
        return node;
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * to insert a node into AVL
     * <p>
     * <b><u>Contract</u></b>
     * @param node is an AVL node
     * @param toInsert is a Node for insert
     * @return node inserted AVL
     */
    public AvlNode insertIntoAVL(AvlNode node, AvlNode toInsert){
        
        if(node == null){
            return toInsert;
        }
        if(node.key.Key > toInsert.key.Key){
            return new AvlNode(node.key, insertIntoAVL(node.left, toInsert), node.right);
        }
        else {
            return new AvlNode(node.key,node.left,insertIntoAVL(node.right, toInsert));
        }
        
    }

    /**
     ** <p>
     * <b>Purpose :</b>
     * to insert keyValue into AVL (This is a overloaded method)
     * <p>
     * <b><u>Contract</u></b>
     * @param key is a KeyValue for insert
     * @return keyValue inserted AVL Tree
     */
    public AvlNode insertIntoAVL(KeyValue key) {

        if(node == null){
            node = new AvlNode(key);
        }
        
        else {
            node = insertIntoAVL(node, new AvlNode(key));
        }
        
        if(isBalanced(node) != 0) {
            if(isBalanced(node) == 1){
                node = RotateLeft(node);
                return node;
            }
            
            else {
                node = RotateRight(node);
                return node;
            }
        } else {
            return node;
        }        
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * to delete keyValue from AVL
     * <p>
     * <b><u>Contract</u></b>
     * @param key is keyValue for delete
     * @return deleted keyValued AVL
     */
    public AvlNode deleteKeyFromTree(int key){
        
        if(node != null){
            node = deleteNodeFromTree(key, node);
        }
        
        else {
            return null;
        }
        
        if(isBalanced(node) != 0) {
            if(isBalanced(node) == 1){
                node = RotateLeft(node);
                return node;
            }
            else {
                node = RotateRight(node);
                return node;
            }
        } else {
            node = RotateLeft(node);
            return node;
        }
    }
    
    /**
     ** <p>
     * <b>Purpose :</b>
     * to delete a node from AVL (This a overloaded method)
     * <p>
     * <b><u>Contract</u></b>
     * @param toDelete node for delete
     * @param node is an AVL node
     * @return AVL tree whose value deleted
     */
    public AvlNode deleteNodeFromTree(int toDelete, AvlNode node){
        
        if(node == null){
            return null;
        }
        if(toDelete >= node.key.Key) {
            if(toDelete > node.key.Key){
                node.key = findMinimum(node.right).key;
                node.right = deleteMinimum(node.right);
            }
            else {
                node = (node.left !=null) ? node.left : node.right;
            }
        } else {
            node.left = deleteNodeFromTree(toDelete, node.left);
        }
        return node;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
