
import org.junit.Test;


@SuppressWarnings("unused")
public class InsertionSortTest  {

    @Test
    public void test() {

        int limit = 10000;							//set the maximum length of an array

		  						//Uncomment for user-interaction. When this line un-commented you've to enter limit on console. (It increases RunTime !)

        /*System.out.println( "Please enter the Array Lenght you want sort : " );
         Scanner scan = new Scanner(System.in);
         limit = scan.nextInt();
         scan.close();
         */
        int arr[] = new int[limit];
        int arr2[] = new int[limit];
        int arr3[] = new int[limit];
        int arr4[] = new int[limit];
        int arr5[] = new int[limit];

        InsertionSort.GenerateRandomList(arr);			//Generate random list-of-numbers
        InsertionSort.GenerateRandomList(arr2);		//Generate random list-of-numbers
        InsertionSort.GenerateRandomList(arr3);		//Generate random list-of-numbers
        InsertionSort.GenerateRandomList(arr4);		//Generate random list-of-numbers
        InsertionSort.GenerateRandomList(arr5);		//Generate random list-of-numbers

        System.out.println("Is the given list 'arr' SORTED ?: " + InsertionSort.isSorted(arr));			//Check given list is sorted
        System.out.println("Is the given list 'arr2' SORTED ?: " + InsertionSort.isSorted(arr2));			//Check given list is sorted
        System.out.println("Is the given list 'arr3' SORTED ?: " + InsertionSort.isSorted(arr3));			//Check given list is sorted
        System.out.println("Is the given list 'arr4' SORTED ?: " + InsertionSort.isSorted(arr4));			//Check given list is sorted
        System.out.println("Is the given list 'arr5' SORTED ?: " + InsertionSort.isSorted(arr5));			//Check given list is sorted
        System.out.println();

        System.out.println("Sorting....");
        /*To see elements in list uncomment

         for ( int i = 0; i < arr.length; i++ ) {
	      	
         System.out.print( " " + a[ i ] );
         }
         */
        System.out.println();

        InsertionSort.InsertSort(arr);			//Apply Insertion Sort
        InsertionSort.InsertSort(arr2);			//Apply Insertion Sort
        InsertionSort.InsertSort(arr3);			//Apply Insertion Sort
        InsertionSort.InsertSort(arr4);			//Apply Insertion Sort
        InsertionSort.InsertSort(arr5);			//Apply Insertion Sort

        System.out.println("Is the given list 'arr' SORTED NOW ?: " + InsertionSort.isSorted(arr));		//Check given list is sorted
        System.out.println("Is the given list 'arr2' SORTED NOW ?: " + InsertionSort.isSorted(arr2));		//Check given list is sorted
        System.out.println("Is the given list 'arr3' SORTED NOW ?: " + InsertionSort.isSorted(arr3));		//Check given list is sorted
        System.out.println("Is the given list 'arr4' SORTED NOW ?: " + InsertionSort.isSorted(arr4));		//Check given list is sorted
        System.out.println("Is the given list 'arr5' SORTED NOW ?: " + InsertionSort.isSorted(arr5));		//Check given list is sorted
        System.out.println();

        /*To see elements of list uncomment

         for ( int i = 0; i < arr.length; i++ ) {
	      	
         System.out.print( " " + a[ i ] );
         }
         */
    }
}
