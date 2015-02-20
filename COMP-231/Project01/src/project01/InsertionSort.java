/*
 *
 #        _  _  _  _                                     _     _                        _  _  _  _
 #      _(_)(_)(_)(_)_                                  (_)   (_)                     _(_)(_)(_)(_)_
 #     (_)          (_)  _  _  _  _     _  _   _  _   _  _    (_) _  _  _            (_)          (_) _  _  _  _      _  _  _    _               _
 #     (_)_  _  _  _    (_)(_)(_)(_)_  (_)(_)_(_)(_) (_)(_)   (_)(_)(_)(_)_          (_)          (_)(_)(_)(_)(_)_   (_)(_)(_) _(_)_           _(_)
 #       (_)(_)(_)(_)_ (_) _  _  _ (_)(_)   (_)   (_)   (_)   (_)        (_)         (_)          (_)(_)        (_)   _  _  _ (_) (_)_       _(_)
 #      _           (_)(_)(_)(_)(_)(_)(_)   (_)   (_)   (_)   (_)        (_)         (_)          (_)(_)        (_) _(_)(_)(_)(_)   (_)_   _(_)
 #     (_)_  _  _  _(_)(_)_  _  _  _  (_)   (_)   (_) _ (_) _ (_)        (_)         (_)_  _  _  _(_)(_)        (_)(_)_  _  _ (_)_    (_)_(_)
 #       (_)(_)(_)(_)    (_)(_)(_)(_) (_)   (_)   (_)(_)(_)(_)(_)        (_)           (_)(_)(_)(_)  (_)        (_)  (_)(_)(_)  (_)    _(_)
 #                                                                                                                                _  _(_)
 #                                                                                                                               (_)(_)
 * The MIT License
 *
 * Copyright 2013 Semih Onay <semih.onay@bilgiedu.net>.
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
import java.util.Random;		//For Random number generation

/**
 * Data Definitions arr : -empty arr : LoN arr : int's followed by list LoN :
 * represents list-of-numbers max : represents maximum lenghth of an array.
 *
 * Contracts isSorted : LoN --> boole an InsertionSort: LoN --> LoN
 * GenerateRandomList : emptylist --> LoN
 *
 * Purposes isSorted : To check given LoN is sorted or NOT GenerateRandomList :
 * To generate random numbers and put them into the given empty-list
 * InsertionSort : To sort given UN-sorted array.
 *
 * Headers isSorted : public static boolean isSorted ( int[]arr )
 * GenerateRandomList : public static int GenerateRandomListOf ( int[]arr )
 * InsertionSort : public static void Insertionsort ( int[]arr )
 *
 */

/**
 * @author Semih Onay
 *
 */
@SuppressWarnings("unused")
public class InsertionSort {

    static long time = 0;										//Global variable for time measurement

    public static int[] GenerateRandomList(int[] arr) {			//Method generates Random numbers and puts them into given array.

        int range = 1000;											//range of a random numbers Ex: 0-99, 0-100, 0-1000 .... 0-n

        Random generate = new Random();

        for (int i = 0; i < arr.length; i++) {

            arr[ i] = generate.nextInt(range);                                  //Assign random number to the i.th element in array.
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {                                 //Method checks given array is SORTED or NOT.

        for (int i = 1; i < arr.length; i++) {

            if (arr[ i - 1] > arr[ i]) {                                        //Comparing i-1.th element with i.th element in array

                return false;
            }
        }
        return true;
    }

    public static void InsertSort(int[] arr) {

        long start = System.nanoTime();				//Time Measurement Start Point

        for (int i = 0; i < arr.length; i++) {

            int current_value = arr[ i]; 				//I prefer to use "current_value" rather than "pivot" & "temp|tmp"
            int j = i - 1;								//j : is the second index number of "while loop". I used 'i-1' for readability.		

            while (j >= 0 && arr[ j] > current_value) {				//Comparing values in array. Again used 'j-1' for code readability.

                arr[ j + 1] = arr[ j];					//Assign value

                j = j - 1;								//Decrase counter every turn
            }

            arr[ j + 1] = current_value;		   		//Insert correct number into correct order in array
        }
        time = System.nanoTime() - start;			//Stop Time Measurement
    }

    public static void main(String[] args) {


        int length = 100;						  	//value of a maximum length of an array

        //Uncomment for user-interaction. When this line un-commented you've to enter array limit on console. (It affects TimeMeasurement ! !)
        /*System.out.println( "Please enter the Array Lenght you want sort : " );
         Scanner scan = new Scanner( System.in );
         limit = scan.nextInt();
         scan.close();
         */
        int arr[] = new int[length];
        int arr2[] = new int[length];
        int arr3[] = new int[length];
        int arr4[] = new int[length];
        int arr5[] = new int[length];


        GenerateRandomList(arr);				//Generate random list-of-numbers
        GenerateRandomList(arr2);				//Generate random list-of-numbers
        GenerateRandomList(arr3);				//Generate random list-of-numbers
        GenerateRandomList(arr4);				//Generate random list-of-numbers
        GenerateRandomList(arr5);				//Generate random list-of-numbers

        System.out.println("Is the given list 'arr' SORTED ?: " + isSorted(arr));		//Check given list is sorted or not
        System.out.println("Is the given list 'arr2' SORTED ?: " + isSorted(arr2));		//Check given list is sorted or not
        System.out.println("Is the given list 'arr3' SORTED ?: " + isSorted(arr3));		//Check given list is sorted or not
        System.out.println("Is the given list 'arr4' SORTED ?: " + isSorted(arr4));		//Check given list is sorted or not
        System.out.println("Is the given list 'arr5' SORTED ?: " + isSorted(arr5));		//Check given list is sorted or not
        System.out.println();
        System.out.println("Sorting....");

        System.out.println();

        InsertSort(arr);							//Apply Insertion Sort
        InsertSort(arr2);						//Apply Insertion Sort
        InsertSort(arr3);						//Apply Insertion Sort
        InsertSort(arr4);						//Apply Insertion Sort
        InsertSort(arr5);

        System.out.println("Is the given list 'arr' SORTED NOW ?: " + isSorted(arr));			//Check given list order after InsertionSort
        System.out.println("Is the given list 'arr2' SORTED NOW ?: " + isSorted(arr2));			//Check given list order after InsertionSort
        System.out.println("Is the given list 'arr3' SORTED NOW ?: " + isSorted(arr3));			//Check given list order after InsertionSort
        System.out.println("Is the given list 'arr2' SORTED NOW ?: " + isSorted(arr4));			//Check given list order after InsertionSort
        System.out.println("Is the given list 'arr2' SORTED NOW ?: " + isSorted(arr5));			//Check given list order after InsertionSort
        System.out.println();
        System.out.println("Time Elapsed : " + time);

        /*To see elements of list uncomment
         for ( int i = 0; i < arr.length; i++ ) {
      	
         System.out.print( " " + arr[ i ] );
         }
         */
    }
}
