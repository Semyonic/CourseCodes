/*
 * 
            
 * The MIT License
 * Copyright 2014 Semih Onay <semih.onay@bilgiedu.net>.
 *
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

package finalproject;

import java.util.Random;

/**
 *
 * @author Semih Onay - 11176008 <semih.onay@bilgiedu.net>
 */
public class AvlTest {
    
    public AvlTest(){
        
        Random random = new Random();
        AvlTree avl = new AvlTree();
        
        avl.insertIntoAVL(null);
        avl.insertIntoAVL(new KeyValue(random.nextInt(), random.nextInt()));
        avl.insertIntoAVL(new KeyValue(random.nextInt(), random.nextInt()));
        avl.insertIntoAVL(new KeyValue(random.nextInt(), random.nextInt()));
        avl.deleteKeyFromTree(random.nextInt());
        avl.deleteKeyFromTree(random.nextInt());
        avl.deleteKeyFromTree(random.nextInt());
        avl.AvlHeight(avl.node);
        
        //Test for 100 elements
        for(int i=0;i<100;i++){
            
            avl.insertIntoAVL(new KeyValue(random.nextInt(),random.nextInt()));
        }
        //Test for 1.000 elements
        for(int i=0;i<1000;i++){
            
        }
        //Test for 10.000 elements
        for(int i=0;i<10000;i++){
            
            avl.insertIntoAVL(new KeyValue(random.nextInt(),random.nextInt()));
        }
        //Test for 100.000 elements
        for(int i=0;i<100000;i++){
            
            avl.insertIntoAVL(new KeyValue(random.nextInt(),random.nextInt()));
        }
        //Test for 1.000.000 elements
        for(int i=0;i<1000000;i++){
            
            avl.insertIntoAVL(new KeyValue(random.nextInt(), random.nextInt()));
        }
    }
    
}
