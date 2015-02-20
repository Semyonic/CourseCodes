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

package project02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public class BinaryHeapPriorityQueue {

    public final List items;
    public int size;

    @SuppressWarnings("unchecked")
    public BinaryHeapPriorityQueue() {

        items = new ArrayList();
        items.add(null);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public void add(Object x) {

        items.add(x);
        size++;
        int i = size;

        while(i > 1 && ((Comparable) items.get(i/2)).compareTo(x) > 0) {

            items.set(i,items.get(i/2));
        }
        items.set(i,x);
    }

    @SuppressWarnings("unchecked")
    public Object remove() {

        if(!isEmpty()) {

            Object toRemove = peek();
            items.set(1,items.get(size));
            size--;

            if(size > 1) {

            heapify(1);
        }
            return toRemove;
        }
        return null;
    }

    public Object peek() {

        return items.get(1);
    }

    public boolean isEmpty() {

        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public void heapify(int root) {

        Comparable last = (Comparable) items.get(root);

        int child,i = root;

        while (2*i <= size) {

            child = 2*i;

            if(((Comparable) items.get(child*2)).compareTo(items.get(child+1)) < 0) {

                child++;
            }

            if(last.compareTo(items.get(child)) <= 0) {

                break;
            }
            else {

            items.set(i,items.get(child));
            i = child;
        }
     }

        items.set(i,last);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {


        Random rnd = new Random();
        BinaryHeapPriorityQueue test = new BinaryHeapPriorityQueue();

        for(int i=0;i<10;i++){

            test.items.add(rnd.nextInt(250));
        }
        
//        test.items.add(3);
//        test.items.add(5);
//        test.items.add(4);
//        test.items.add(12);
//        test.items.add(6);
//        test.items.add(10);
//        test.items.add(9);

        test.heapify(1);
        //test.add(11);
        //test.heapify(1);
        System.out.println(test.items.toString());


    }

}
