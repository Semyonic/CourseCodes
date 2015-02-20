package project02;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		//List of Firstnames
		String names[]={"Semih","Taha","Chanell","Kip","Shawanda","Aldo","Mireya","Pamela","Nanette","Sharon","Lynette","Merrill","Salome","Carmelo",
				"Delisa","Detra","Marsha","Sherrell","Lori","Drema","Brock","Carolyne","Bart","Nita","Tamesha","Laurie","Niki","Liza","Gertrudis","Valeria",
				"Stefanie","Chanel","Suzann","Calandra","Modesto","Glenda","Janie","Susana","Kenyetta","Lauran","Karlene","Rosanne","Erin","Alpha","Ebonie",
				"Salena","Frederic","Casandra","Raye","Maria"};
		//List of Surnames
		String lastNames[]={"Onay","Hornbuckle","Paulus","Speno","Giambrone","Apo","Gowins","Duquette","Loera","Woodley","Braatz","Flanagan","Bortle",
				"Groover","Eagan","Real","Beres","Dimond","Bower","Farias","Dalley","Mcglynn","Copes","Mealing","Freire","Yule","Lucy","Scouten","Bruggeman",
				"Leventhal","Mckeller","Jager","Hanger","Sargeant","Frink","Abundis","Mcshan","Valvo","Witte","Sackett","Jurgens","Norell","Cromley","Cathey",
				"Pantano","Arter","Gaskamp","Angelo","Tamez"};
		
		Random randomizer = new Random();
		int min = 11176008;		//Minimum value of studentID to minimize replications
		int max = 11199999;		//Maximum value of studentID to minimize replications
		int maxin = 50;			//Maximum value of Random for randomName generation to minimize replications
		int minim = 1;			//Minimum value of Random for randomName generation to minimize replications
		int NameListLength = 49;		//The length of NameList
                
		//Brute Way - BoneHead
		Student[] student = new Student[50];
		Student student1 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student2 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student3 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student4 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student5 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student6 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student7 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student8 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student9 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student10 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student11 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student12 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student13 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student14 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student15 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student16 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student17 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student18 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student19 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student20 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student21 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student22 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student23 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student24 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student25 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student26 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student27 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student28 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student29 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student30 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student31 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student32 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student33 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student34 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student35 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student36 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student37 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student38 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student39 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student40 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student41 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student42 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student43 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student44 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student45 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student46 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student47 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student48 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student49 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		Student student50 = new Student(names[randomizer.nextInt(maxin-minim)+minim], lastNames[randomizer.nextInt(NameListLength)], randomizer.nextInt(max-min)+min);
		
		//Initializing objects
		student[0] = student1;
		student[1] = student2;
		student[2] = student3;
		student[3] = student4;
		student[4] = student5;
		student[5] = student6;
		student[6] = student7;
		student[7] = student8;
		student[8] = student9;
		student[9] = student10;
		student[10] = student11;
		student[11] = student12;
		student[12] = student13;
		student[13] = student14;
		student[14] = student15;
		student[15] = student16;
		student[16] = student17;
		student[17] = student18;
		student[18] = student19;
		student[19] = student20;
		student[20] = student21;
		student[21] = student22;
		student[22] = student23;
		student[23] = student24;
		student[24] = student25;
		student[25] = student26;
		student[26] = student27;
		student[27] = student28;
		student[28] = student29;
		student[29] = student30;
		student[30] = student31;
		student[31] = student32;
		student[32] = student33;
		student[33] = student34;
		student[34] = student35;
		student[35] = student36;
		student[36] = student37;
		student[37] = student38;
		student[38] = student39;
		student[39] = student40;
		student[40] = student41;
		student[41] = student42;
		student[42] = student43;
		student[43] = student44;
		student[44] = student45;
		student[45] = student46;
		student[46] = student47;
		student[47] = student48;
		student[48] = student49;
		student[49] = student50;
		
		//Student.InsertSort(student);				//Un-comment to sort with InsertionSort
		
		Student.QuickSort(student, 0, student.length);
                
		for (Student students : student) {			//Print QuickSorted StudentID's
			System.out.println(students.toString());
		}
        System.out.println("Running Time: "+Student.InsertionSortTime + "NS");	//Un-comment to see InsertionSort running time
		System.out.println("Running Time: "+Student.QuickSortTime + "NS");
	}
}