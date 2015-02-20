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
package project04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */


public class PriorityQueue<E extends Comparable<E>> {

    private final ArrayList<E> states;
    private final ArrayList<Pair> heap;
    private final HashMap<E, Integer> hashTable;

    public PriorityQueue() {

        states = new ArrayList<>();
        heap = new ArrayList<>();
        heap.add(new Pair(null, -1));
        hashTable = new HashMap<>();
    }

    public boolean isEmpty() {

        return states.isEmpty();
    }

    public int size() {

        return states.size();
    }

    @Override
    public String toString() {

        return heap.toString();
    }

    public void add(E element) {

        Integer index = hashTable.get(element);

        if (index == null) {
            states.add(element);
            int setIndex = states.size() - 1;
            int heapIndex
                    = insertIntoHeap(element, setIndex);
            hashTable.put(element, heapIndex);
        } else {

            Pair oldPair = heap.get(index);
            E oldElement = oldPair.element;

            if (element.compareTo(oldElement) < 0) {

                int oldSetIndex = oldPair.setIndex;
                int heapIndex = updateInHeap(
                        new Pair(element, oldSetIndex),
                        index);
                hashTable.put(element, heapIndex);
            } else {
                
            }
        }
    }

    public E remove() {

        Pair delete = heap.get(1);
        int setIndex = delete.setIndex;
        E movedElement = states.get(states.size() - 1);
        states.set(setIndex, movedElement);
        states.remove(states.size() - 1);
        int heapIndex = hashTable.get(movedElement);
        heap.set(heapIndex, new Pair(movedElement, setIndex));


        Pair p = heap.get(heap.size() - 1);
        heap.set(1, p);
        hashTable.put(p.element, 1);


        heap.remove(heap.size() - 1);
        hashTable.remove(delete.element);


        if (heap.size() > 1) {
            moveDown(p, 1);
        }
        return delete.element;
    }

    private int updateInHeap(Pair p, int heapIndex) {
        return moveUp(p, heapIndex);
    }

    private int insertIntoHeap(E element, int setIndex) {
        int heapIndex = heap.size();
        Pair pair = new Pair(element, setIndex);
        heap.add(pair);                  // make room in heap
        return moveUp(pair, heapIndex);
    }

    private int moveUp(Pair pair, int heapIndex) {
        int tempIndex = heapIndex;
        E element = pair.element;
        boolean done = false;
        while (!done && tempIndex > 1) {
            Pair parentPair = heap.get(tempIndex / 2);
            E parentElement = parentPair.element;
            if (element.compareTo(parentElement) >= 0) {
                done = true;
            }
            if (!done) {
                heap.set(tempIndex, parentPair);
                hashTable.put(parentElement, tempIndex);
                tempIndex /= 2;
            }
        }
        heap.set(tempIndex, pair);
        hashTable.put(element, tempIndex);
        return tempIndex;
    }

    private int moveDown(Pair pair, int heapIndex) {
        int tempIndex = heapIndex;
        E element = pair.element;
        int childIndex = 2 * heapIndex;
        boolean done = false;
        while (!done && childIndex < heap.size()) {
            if (childIndex + 1 < heap.size()
                    && heap.get(childIndex + 1).element.compareTo(
                            heap.get(childIndex).element) < 0) {
                childIndex++;
            }
            if (heap.get(tempIndex).element.compareTo(
                    heap.get(childIndex).element) < 0) {
                done = true;
            }
            if (!done) {
                heap.set(tempIndex, heap.get(childIndex));
                hashTable.put(heap.get(childIndex).element,
                        tempIndex);
                heap.set(childIndex, pair);
                hashTable.put(pair.element, childIndex);
                tempIndex = childIndex;
                childIndex = 2 * childIndex;
            }
        }
        heap.set(tempIndex, pair);
        hashTable.put(element, tempIndex);
        return tempIndex;
    }

    private class Pair {

        public E element;
        public int setIndex;

        Pair(E element, int setIndex) {
            this.element = element;
            this.setIndex = setIndex;
        }

        @Override
        public String toString() {
            return element + "=" + setIndex;
        }

    }

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random();
        
        for (int i = 0; i < 100; i++) {
            
            priorityQueue.add(random.nextInt(50));            
        }
        
        System.out.println(priorityQueue);
    }
}
