package project02;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

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

public class QuickSortTest {

	@Test
	public void testQuickSort() {
		
		Student[] stu = new Student[5];
		
		Student student3 = new Student("Zehra", "Yıldız", 11176005);
		Student student0 = new Student("Semih", "Onay", 11176008);
		Student student2 = new Student("Deniz", "Özkan", 11176006);
		Student student1 = new Student("Taha", "Onay", 11176007);
		Student student4 = new Student("Selim", "Olgun", 11176004);
		
		stu[0] = student3;
		stu[1] = student0;
		stu[2] = student2;
		stu[3] = student1;
		stu[4] = student4;
		
		
		
		Student[] stu2 = new Student[5];
		Student stud0 = new Student("Semih", "Onay", 11176008);
		Student stud1 = new Student("Taha", "Onay", 11176007);
		Student stud2 = new Student("Deniz", "Özkan", 11176006);
		Student stud3 = new Student("Zehra", "Yıldız", 11176005);
		Student stud4 = new Student("Selim", "Olgun", 11176004);
		
		stu2[0] = stud0;
		stu2[1] = stud1;
		stu2[2] = stud2;
		stu2[3] = stud3;
		stu2[4] = stud4;
		
		Student.QuickSort(stu, 0, stu.length);
		assertArrayEquals(stu, stu2);
		


    }

}
