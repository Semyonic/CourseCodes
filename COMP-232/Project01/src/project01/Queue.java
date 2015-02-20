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
package project01;
/**
 * 
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */
public class Queue implements Comparable<Object>{
   
    public int max_Size;
    public int top = 0;
    public int rear = 0;
    public int size = 0;
    public Object[] queue;

    
    public Queue(int size){
        
        max_Size = size;
        top = 0;
        rear = 0;
        queue[size] = new char[max_Size];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == max_Size;
    }
    
    public void insert(Object obj){
        
        if(!isFull()){
            
            size++;
            rear = (rear + 1)%max_Size;
            queue[rear] = obj;
        }
        else{
            System.out.println("Reached size");
        }
    }
    
    public void delete(){
        
        if(!isEmpty()){
            
            size--;
            top = (top + 1) % max_Size;
        }
        else{
            System.out.println("Reached empty");
        }
    }
    
    public void print(){
        
        System.out.println("Size = " + size + ", Rear = " + rear + ", Top = " + top + ", Queue = ");
        
        for (int i = 0; i < max_Size; i++){
            System.out.print("Queue[" + i + "]=" + queue[i] + ";");
        }
        
        System.out.println();
    }
    
    public static void main(String[] args){
     
        int size = 1000;
        Queue testQ = new Queue(size);
        
        for(int i=size;i<size;i++){
            
            testQ.insert(i);
        }
        
        testQ.delete();
        testQ.isEmpty();
        testQ.isFull();
        
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public String toString(Object o){
        
        return o.toString();
    }

}
