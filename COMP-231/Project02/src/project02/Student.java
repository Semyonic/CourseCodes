package project02;
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


/**
 *
 * @author Semih Onay <semih.onay@bilgiedu.net>
 */

import java.util.Comparator;

/**
 *
 * Data Definitions: ArrayofObjects(AoO): can be empty or at least has 1 element
 *
 * Contract: Partitioning: AoO --> int QuickSort: AoO --> AoO InserionSort: AoO
 * --> AoO
 *
 * Header: public static QuickSort(AoO[],int start,int end){
 *
 * Template: public void QuickSort(array[],int str,int end){ if( start > end-1
 * ){ return; } int temp_position=Partitioning(...,....,....);
 *
 * //Recursively sorting two sub-arrays QuickSort(...,....,....);
 * QuickSort(...,.....,....); }
 */

public class Student implements Comparable<Student> {

    //Variables for time measurement
    static long InsertionSortTime = 0;
    static long QuickSortTime = 0;

    private String FirstName, LastName;

    /**
     *
     */
    public int StudentID;

    //Consturctor


    /**
     *
     * @param FirstName holds first-name of student
     * @param LastName holds last-name of student
     * @param StudentID holds student-ID
     */

    public Student(String FirstName, String LastName, int StudentID) {

        super();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.StudentID = StudentID;
    }

    //Getters and Setters

    /**
     *
     * @return FirstName of student
     */

    public String getFirstName() {

        return FirstName;
    }

    /**
     *
     * @param FirstName holds first-name of students
     * @return sets FirstName of student
     */
    public String setFirstName(String FirstName) {
        return this.FirstName = FirstName;
    }

    /**
     *
     * @return gets LastName of student
     */
    public String getLastName() {
        return LastName;
    }

    /**
     *
     * @param LastName LastName of student
     * @return sets LastName of student
     */
    public String setLastName(String LastName) {
        return this.LastName = LastName;
    }

    /**
     *
     * @return gets StudentID
     */
    public int getStudentID() {
        return StudentID;
    }

    /**
     *
     * @param StudentID sets students StudentID
     * @return sets StudentID
     */
    public int setStudentID(int StudentID) {
        return this.StudentID = StudentID;
    }

    //InsertionSort Method

    /**
     *
     * @param arr array of Students
     */

    public static void InsertSort(Student[] arr) {

        long startInsertionSort = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {

            Student current_value = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(current_value) > 0) {

                arr[j + 1] = arr[j];

                j -= 1;
            }

            arr[j + 1] = current_value;
        }
        InsertionSortTime = System.nanoTime() - startInsertionSort;
    }

    //Partion Method for QuickSorting
    /**
     *
     * @param array array of Students
     * @param start starting index
     * @param end length of array
     * @return partitions given Student array
     */

        public static int Partitioning(Student[] array, int start, int end) {


        int last = end - 1;
        int first = start;
        Student temp = array[start];

        while (first < last) {

            while (first < last && temp.StudentID <= array[last].StudentID) {
                last -= 1;
            }
            array[first].StudentID = array[last].StudentID;

            while (first < last && temp.StudentID > array[first].StudentID) {
                first += 1;
            }
            array[first].StudentID = temp.StudentID;
        }
        return first;
    }

    /**
     *
     * @param array Student array
     * @param start starting index
     * @param end length of array
     */
    public static void QuickSort(Student[] array, int start, int end) {

        long StartQuickSort = System.nanoTime();

        if (start > end - 1) {
            return;
        }
        int temp_position = Partitioning(array, start, end);

        //Recursively sorting two sub-arrays
        QuickSort(array, start, temp_position);
        QuickSort(array, temp_position + 1, end);
        QuickSortTime = System.nanoTime() - StartQuickSort;
    }

    /**
     *
     */
    public static Comparator<Student> StudentIDComparator
            = new Comparator<Student>() {

                @Override
                public int compare(Student student1, Student student2) {

                    student1.getStudentID();
                    student2.getStudentID();

                    return student1.compareTo(student2);
                }
            };

    @Override
    public int compareTo(Student compareStudent) {

        int compareID = compareStudent.getStudentID();
        return StudentID - compareID;
    }

    @Override
    public String toString() {

        return "Name:" + this.getFirstName() + " Surname:" + this.getLastName() + " StudentID: " + this.getStudentID();
    }
}
