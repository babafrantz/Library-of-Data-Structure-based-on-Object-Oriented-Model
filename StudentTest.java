/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yomol
 */
public class StudentTest {

    public StudentTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("End of testing ");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testHashCode() {

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;

        assertFalse((2134567890) == (student1.hashCode()));
        assertEquals((1416089630), (student1.hashCode()));
        assertFalse((1416089630) == (student2.hashCode()));
        assertEquals((1775582038), (student2.hashCode()));
        assertFalse((1775582038) == student3.hashCode());
        assertEquals(2069849908, student3.hashCode());
        assertFalse(2069849908 == student4.hashCode());
        assertEquals(1416089630, student4.hashCode());

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testEquals() {

        try {

            Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
            Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
            Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
            Student student4 = student1;
            Student student5 = null;

            assertFalse(student1.equals(student2));
            assertFalse(student2.equals(student3));
            assertTrue(student4.equals(student1));
            assertFalse(student4.equals(student3));
            assertFalse(student5.equals(student4));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testSortByID() {

        System.out.println("Test by SortByID");

        // Creating objects from different Student class Constructor
        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        // Creating an object of the SORTBYID class
        Student.SortbyID sortbyid = student1.new SortbyID();

        assertEquals(2222, (sortbyid.compare(student1, student2)));
        assertEquals(7742, (sortbyid.compare(student3, student2)));
        assertEquals(-3, (sortbyid.compare(student6, student9)));

        //Adding Student objects to a list data structure. 
        ArrayList<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student6);
        list.add(student7);
        list.add(student8);

        //Adding student objects to a set data structure.
        Set<Student> setofstudent = new HashSet<Student>();

        setofstudent.add(student1);
        setofstudent.add(student2);
        setofstudent.add(student3);
        setofstudent.add(student6);
        setofstudent.add(student7);
        setofstudent.add(student8);

        Iterator<Student> custIterators = setofstudent.iterator();

        System.out.println("Set of Students:\n");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Student> custIterator = list.iterator();

        System.out.println("Before Sorting list :\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, sortbyid);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting list:\n");
        for (Student Sorting : list) {
            System.out.println(Sorting);
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Sorting list by ID in the reverse");

        // Sorting the list using comparators in reverse order
        Collections.sort(list, sortbyid.reversed());

        for (Student s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testSortByProgram() {

        System.out.println("Test by SortByProgram");

        // Creating objects from different Student class Constructor
        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        // Creating an object of the SORTBYPROGRAM class
        Student.Sortbyprogram sortbyprogram = student2.new Sortbyprogram();

        assertEquals(11, (sortbyprogram.compare(student1, student2)));
        assertEquals(2, (sortbyprogram.compare(student3, student2)));
        assertEquals(2, (sortbyprogram.compare(student6, student9)));

        //Adding Student objects to a list data structure. 
        ArrayList<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student6);
        list.add(student7);
        list.add(student8);

        //Adding student objects to a set data structure.
        Set<Student> setofstudent = new HashSet<Student>();

        setofstudent.add(student1);
        setofstudent.add(student2);
        setofstudent.add(student3);
        setofstudent.add(student6);
        setofstudent.add(student7);
        setofstudent.add(student8);

        Iterator<Student> custIterators = setofstudent.iterator();

        System.out.println("Set of Students:\n");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Student> custIterator = list.iterator();

        System.out.println("Before Sorting list:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, sortbyprogram);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting list:\n");
        for (Student Sorting : list) {
            System.out.println(Sorting);
        }

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Sorting list by program in the reverse");

        // Sorting the list using comparators in reverse order
        Collections.sort(list, sortbyprogram.reversed());

        for (Student s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testStudentSortingComparator() {

        System.out.println("Test by StudentSortingComparator");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        // Creating an object of the StudentSortingComparator Class
        Student.StudentSortingComparator studentsortingcomparator = student2.new StudentSortingComparator();

        assertEquals(-12, studentsortingcomparator.compare(student9, student1));
        assertEquals(-1, studentsortingcomparator.compare(student8, student3));
        assertEquals(-11, studentsortingcomparator.compare(student2, student1));
        assertEquals(10, studentsortingcomparator.compare(student4, student8));
        assertEquals(14, studentsortingcomparator.compare(student6, student7));

        ArrayList<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student6);
        list.add(student7);
        list.add(student8);

        //Adding student objects to a set data structure.
        Set<Student> setofstudent = new HashSet<>();

        setofstudent.add(student1);
        setofstudent.add(student2);
        setofstudent.add(student3);
        setofstudent.add(student6);
        setofstudent.add(student7);
        setofstudent.add(student8);

        Iterator<Student> custIterators = setofstudent.iterator();

        System.out.println("Set of Students");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Student> custIterator = list.iterator();

        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, studentsortingcomparator);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting:\n");
        for (Student Sorting : list) {
            System.out.println(Sorting);
        }
    }

    @Test
    public void testLinearSearch() {

        System.out.println("Test the LinearSearch");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        Student.LinearSearch linearsearch = student1.new LinearSearch();

        ArrayList<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student6);
        list.add(student7);
        list.add(student8);

        assertTrue(list == linearsearch.search(list, student1));
        assertTrue(list == linearsearch.search(list, student2));
        assertTrue(list == linearsearch.search(list, student3));
        assertTrue(list == linearsearch.search(list, student6));
        assertTrue(list == linearsearch.search(list, student7));
        assertTrue(list == linearsearch.search(list, student8));

    }

    @Test
    public void testBinarySearch() {

        System.out.println("Test the BinarySearch");

        System.out.println("----------------------------");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        Student.BinarySearch binarysearch = student1.new BinarySearch();
        Student.SortbyID sortbyid = student1.new SortbyID();

        ArrayList<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student6);
        list.add(student7);
        list.add(student8);

        Collections.sort(list, sortbyid);

        Iterator<Student> custIterators = list.iterator();

        System.out.println("Sorted List before binary search");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        System.out.println("-----------------------------");

        assertTrue(list == binarysearch.binarySearchOfList(list, student1));
        assertTrue(list == binarysearch.binarySearchOfList(list, student2));
        assertTrue(list == binarysearch.binarySearchOfList(list, student3));
        assertTrue(list == binarysearch.binarySearchOfList(list, student6));
        assertTrue(list == binarysearch.binarySearchOfList(list, student7));
        assertTrue(list == binarysearch.binarySearchOfList(list, student8));

    }

    @Test
    public void testSelectionSortStudent() {

        System.out.println("Test the SelectionSortStudent");

        System.out.println("----------------------------");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        Student.SelectionSortStudent selectionsortstudent = student1.new SelectionSortStudent();

        Student[] studentarrays = new Student[6];

        studentarrays[0] = student1;
        studentarrays[1] = student2;
        studentarrays[2] = student3;
        studentarrays[3] = student6;
        studentarrays[4] = student7;
        studentarrays[5] = student8;

        // Selection sorting the student class. 
        selectionsortstudent.selectionsort(studentarrays);

        System.out.println("After select sorting the Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < studentarrays.length; i++) {
            System.out.println(studentarrays[i]);
        }

        for (int i = 0; i < studentarrays.length; i++) {
            assertTrue(student2 == studentarrays[0]);
            assertTrue(student1 == studentarrays[1]);
            assertTrue(student3 == studentarrays[2]);
            assertTrue(student6 == studentarrays[3]);
            assertTrue(student7 == studentarrays[4]);

        }
    }

    @Test
    public void testBubbleSort() {

        System.out.println("Test the bubblesortofStudents");

        System.out.println("----------------------------");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        Student[] studentarrays = new Student[6];

        studentarrays[0] = student1;
        studentarrays[1] = student2;
        studentarrays[2] = student3;
        studentarrays[3] = student6;
        studentarrays[4] = student7;
        studentarrays[5] = student8;

        Student.BubbleSort bubblesortstudent = student1.new BubbleSort();

        bubblesortstudent.bubblesortofStudents(studentarrays);

        System.out.println("After bubble sorting the Student Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < studentarrays.length; i++) {
            System.out.println(studentarrays[i]);

        }

        for (int i = 0; i < studentarrays.length; i++) {
            assertTrue(student2 == studentarrays[0]);
            assertTrue(student1 == studentarrays[1]);
            assertTrue(student3 == studentarrays[2]);
            assertTrue(student6 == studentarrays[3]);
            assertTrue(student7 == studentarrays[4]);

        }

    }

    @Test
    public void testInsertSort() {

        System.out.println("Test the InsertsortofStudents");

        System.out.println("----------------------------");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        Student[] studentarrays = new Student[6];

        studentarrays[0] = student1;
        studentarrays[1] = student2;
        studentarrays[2] = student3;
        studentarrays[3] = student6;
        studentarrays[4] = student7;
        studentarrays[5] = student8;

        Student.InsertionSort insertionsortstudent = student1.new InsertionSort();

        insertionsortstudent.insertionSortOfStudents(studentarrays);

        System.out.println("After Insertion sorting the Student Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < studentarrays.length; i++) {
            System.out.println(studentarrays[i]);

        }

        for (int i = 0; i < studentarrays.length; i++) {
            assertTrue(student2 == studentarrays[0]);
            assertTrue(student1 == studentarrays[1]);
            assertTrue(student3 == studentarrays[2]);
            assertTrue(student6 == studentarrays[3]);
            assertTrue(student7 == studentarrays[4]);

        }

    }

    @Test
    public void testLinkedlist() {

        System.out.println("Test the Linkedlist Data structure");

        System.out.println("----------------------------");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        Student.LinkedList<Student> linkedlists = student1.new LinkedList<Student>();

        Student.Node first = student1.new Node(student1);

        Student.Node middle = student1.new Node(student2);

        Student.Node last = student1.new Node(student3);

        first.next = middle;
        middle.next = last;

        linkedlists.addFirst(first);
        linkedlists.AddLast(last);

        assertFalse(linkedlists.contains(student9));

        assertTrue(linkedlists.contains(student3));
        
        assertTrue(linkedlists.contains(student1));
        
        linkedlists.removeFirst();
        linkedlists.removeLast();
        
        assertFalse(linkedlists.contains(student9));

        assertFalse(linkedlists.contains(student3));
        
        assertFalse(linkedlists.contains(student1));

        linkedlists.printlist(first);

    }
    
    @Test
    public void testdoublyLinkedllist() {

        System.out.println("Test the doublyLinkedllist Data structure");

        System.out.println("----------------------------");

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());
        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());
        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());
        Student student4 = student1;
        Student student5 = null;
        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());

        Student.doublyLinkedlist<Student> doublylinkedlists = student1.new doublyLinkedlist<Student>();

        Student.Node first = student1.new Node(student1);

        Student.Node middle = student1.new Node(student2);

        Student.Node last = student1.new Node(student3);

        first.next = middle;
        middle.next = last;

        doublylinkedlists.addFirst(first);
        doublylinkedlists.addlast(last);

        assertTrue(doublylinkedlists.contains(student1));

        assertTrue(doublylinkedlists.contains(student3));
        
        assertFalse(doublylinkedlists.contains(student2));
        
        
        doublylinkedlists.removeFirst();
        doublylinkedlists.removeLast();
        
        assertFalse(doublylinkedlists.contains(student1));

        assertFalse(doublylinkedlists.contains(student3));
        
        assertFalse(doublylinkedlists.contains(student2));
        
        

        

    }

}
