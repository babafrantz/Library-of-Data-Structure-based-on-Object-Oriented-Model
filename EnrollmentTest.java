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
public class EnrollmentTest {

    public EnrollmentTest() {
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

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "2nd", new Course());

        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "3rd", new Course());

        Enrollment enrollee3 = new Enrollment();

        Enrollment enrollee4 = enrollee1;

        Enrollment enrollee5 = null;

        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "1st", new Course());

        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "5th", new Course());

        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "6th", new Course());

        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "7th", new Course());

        assertFalse((2134567890) == (enrollee1.hashCode()));
        assertEquals((-1004723722), (enrollee1.hashCode()));
        assertFalse((1416089630) == (enrollee2.hashCode()));
        assertEquals((53838799), (enrollee2.hashCode()));
        assertFalse((1775582038) == enrollee3.hashCode());
        assertEquals(-1794587189, enrollee3.hashCode());
        assertFalse(2069849908 == enrollee4.hashCode());
        assertEquals(-1004723722, enrollee4.hashCode());

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testEquals() {

        try {

            Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
            Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
            Enrollment enrollee3 = new Enrollment();
            Enrollment enrollee4 = enrollee1;
            Enrollment enrollee5 = null;
            Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
            Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
            Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
            Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

            assertFalse(enrollee1.equals(enrollee2));
            assertFalse(enrollee2.equals(enrollee3));
            assertTrue(enrollee4.equals(enrollee1));
            assertFalse(enrollee4.equals(enrollee3));
            assertFalse(enrollee5.equals(enrollee4));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testSortByID() {

        System.out.println("Test by SortByID");

        // Creating objects from different Student class Constructor
        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        // Creating an object of the SORTBYID class
        Enrollment.SortbyID sortbyid = enrollee1.new SortbyID();

        assertEquals(-11111, (sortbyid.compare(enrollee1, enrollee2)));
        assertEquals(-34567, (sortbyid.compare(enrollee3, enrollee2)));
        assertEquals(-10, (sortbyid.compare(enrollee6, enrollee9)));

        //Adding Student objects to a list data structure. 
        ArrayList<Enrollment> list = new ArrayList<>();

        list.add(enrollee1);
        list.add(enrollee2);
        list.add(enrollee3);
        list.add(enrollee6);
        list.add(enrollee7);
        list.add(enrollee8);

        //Adding student objects to a set data structure.
        Set<Enrollment> setofenrollment = new HashSet<>();

        setofenrollment.add(enrollee1);
        setofenrollment.add(enrollee2);
        setofenrollment.add(enrollee3);
        setofenrollment.add(enrollee6);
        setofenrollment.add(enrollee7);
        setofenrollment.add(enrollee8);

        Iterator<Enrollment> custIterators = setofenrollment.iterator();

        System.out.println("Set of Enrollments:\n");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Enrollment> custIterator = list.iterator();

        System.out.println("Before Sorting list :\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, sortbyid);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting list:\n");
        for (Enrollment Sorting : list) {
            System.out.println(Sorting);
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Sorting list by ID in the reverse");

        // Sorting the list using comparators in reverse order
        Collections.sort(list, sortbyid.reversed());

        for (Enrollment s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testSortByProgram() {

        System.out.println("Test by SortByProgram");

        // Creating objects from different Student class Constructor
        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        // Creating an object of the SORTBYPROGRAM class
        Enrollment.SortbySemester sortbyprogram = enrollee1.new SortbySemester();

        assertEquals(-1, (sortbyprogram.compare(enrollee1, enrollee2)));
        assertEquals(-1, (sortbyprogram.compare(enrollee8, enrollee2)));
        assertEquals(-13, (sortbyprogram.compare(enrollee6, enrollee9)));

        //Adding Student objects to a list data structure. 
        ArrayList<Enrollment> list = new ArrayList<>();

        list.add(enrollee1);
        list.add(enrollee2);
        list.add(enrollee6);
        list.add(enrollee7);
        list.add(enrollee8);
        list.add(enrollee9);
        //Adding student objects to a set data structure.
        Set<Enrollment> setofenrollment = new HashSet<>();

        setofenrollment.add(enrollee1);
        setofenrollment.add(enrollee2);
        setofenrollment.add(enrollee6);
        setofenrollment.add(enrollee7);
        setofenrollment.add(enrollee8);
        setofenrollment.add(enrollee9);

        Iterator<Enrollment> custIterators = setofenrollment.iterator();

        System.out.println("Set of Enrollments:\n");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Enrollment> custIterator = list.iterator();

        System.out.println("Before Sorting list:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, sortbyprogram);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting list:\n");
        for (Enrollment Sorting : list) {
            System.out.println(Sorting);
        }

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Sorting list by program in the reverse");

        // Sorting the list using comparators in reverse order
        Collections.sort(list, sortbyprogram.reversed());

        for (Enrollment s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testStudentSortingComparator() {

        System.out.println("Test by EnrollmentSortingComparator");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        // Creating an object of the StudentSortingComparator Class
        Enrollment.EnrollmentSortingComparator enrollmentsortingcomparator = enrollee2.new EnrollmentSortingComparator();

        assertEquals(19, enrollmentsortingcomparator.compare(enrollee9, enrollee1));
        assertEquals(13, enrollmentsortingcomparator.compare(enrollee8, enrollee6));
        assertEquals(1, enrollmentsortingcomparator.compare(enrollee2, enrollee1));
        assertEquals(-4, enrollmentsortingcomparator.compare(enrollee4, enrollee8));
        assertEquals(12, enrollmentsortingcomparator.compare(enrollee6, enrollee7));

        ArrayList<Enrollment> list = new ArrayList<>();

        list.add(enrollee1);
        list.add(enrollee2);
        list.add(enrollee6);
        list.add(enrollee7);
        list.add(enrollee8);
        list.add(enrollee9);

        //Adding student objects to a set data structure.
        Set<Enrollment> setofenrollment = new HashSet<>();

        setofenrollment.add(enrollee1);
        setofenrollment.add(enrollee2);
        setofenrollment.add(enrollee6);
        setofenrollment.add(enrollee7);
        setofenrollment.add(enrollee8);
        setofenrollment.add(enrollee9);

        Iterator<Enrollment> custIterators = setofenrollment.iterator();

        System.out.println("Set of Enrollment");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Enrollment> custIterator = list.iterator();

        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, enrollmentsortingcomparator);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting:\n");
        for (Enrollment Sorting : list) {
            System.out.println(Sorting);
        }
    }

    @Test
    public void testLinearSearch() {

        System.out.println("Test the LinearSearch");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());
        Enrollment.LinearSearch linearsearch = enrollee1.new LinearSearch();

        ArrayList<Enrollment> list = new ArrayList<>();

        list.add(enrollee1);
        list.add(enrollee2);
        list.add(enrollee3);
        list.add(enrollee6);
        list.add(enrollee7);
        list.add(enrollee8);

        assertTrue(list == linearsearch.search(list, enrollee1));
        assertTrue(list == linearsearch.search(list, enrollee2));
        assertTrue(list == linearsearch.search(list, enrollee6));
        assertTrue(list == linearsearch.search(list, enrollee8));
        assertTrue(list == linearsearch.search(list, enrollee7));
        assertTrue(list == linearsearch.search(list, enrollee8));

    }

    @Test
    public void testBinarySearch() {

        System.out.println("Test the BinarySearch");

        System.out.println("----------------------------");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());
        Enrollment.BinarySearch binarysearch = enrollee1.new BinarySearch();

        Enrollment.SortbyID sortbyid = enrollee1.new SortbyID();

        ArrayList<Enrollment> list = new ArrayList<>();

        list.add(enrollee1);
        list.add(enrollee2);
        list.add(enrollee3);
        list.add(enrollee6);
        list.add(enrollee7);
        list.add(enrollee8);

        Collections.sort(list, sortbyid);

        Iterator<Enrollment> custIterators = list.iterator();

        System.out.println("Sorted List before binary search");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        System.out.println("-----------------------------");

        assertTrue(list == binarysearch.binarySearchOfList(list, enrollee1));
        assertTrue(list == binarysearch.binarySearchOfList(list, enrollee2));
        assertTrue(list == binarysearch.binarySearchOfList(list, enrollee6));
        assertTrue(list == binarysearch.binarySearchOfList(list, enrollee7));
        assertTrue(list == binarysearch.binarySearchOfList(list, enrollee8));
        assertTrue(list == binarysearch.binarySearchOfList(list, enrollee9));

    }

    @Test
    public void testSelectionSortStudent() {

        System.out.println("Test the SelectionSortStudent");

        System.out.println("----------------------------");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        Enrollment.SelectionSortStudent selectionsortstudent = enrollee1.new SelectionSortStudent();

        Enrollment[] enrollmentarrays = new Enrollment[6];

        enrollmentarrays[0] = enrollee1;
        enrollmentarrays[1] = enrollee2;
        enrollmentarrays[2] = enrollee6;
        enrollmentarrays[3] = enrollee7;
        enrollmentarrays[4] = enrollee8;
        enrollmentarrays[5] = enrollee9;

        // Selection sorting the student class. 
        selectionsortstudent.selectionsort(enrollmentarrays);

        System.out.println("After select sorting the Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < enrollmentarrays.length; i++) {
            System.out.println(enrollmentarrays[i]);
        }

        for (int i = 0; i < enrollmentarrays.length; i++) {
            assertTrue(enrollee1 == enrollmentarrays[0]);
            assertTrue(enrollee6 == enrollmentarrays[1]);
            assertTrue(enrollee7 == enrollmentarrays[2]);
            assertTrue(enrollee8 == enrollmentarrays[3]);
            assertTrue(enrollee9 == enrollmentarrays[4]);
            assertTrue(enrollee2 == enrollmentarrays[5]);

        }
    }

    @Test
    public void testBubbleSort() {

        System.out.println("Test the bubblesortofStudents");

        System.out.println("----------------------------");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        Enrollment[] enrollmentarrays = new Enrollment[6];

        enrollmentarrays[0] = enrollee1;
        enrollmentarrays[1] = enrollee2;
        enrollmentarrays[2] = enrollee6;
        enrollmentarrays[3] = enrollee7;
        enrollmentarrays[4] = enrollee8;
        enrollmentarrays[5] = enrollee9;

        Enrollment.BubbleSort bubblesortenrollment = enrollee1.new BubbleSort();

        bubblesortenrollment.bubblesortofStudents(enrollmentarrays);

        System.out.println("After bubble sorting the Student Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < enrollmentarrays.length; i++) {
            System.out.println(enrollmentarrays[i]);

        }

        for (int i = 0; i < enrollmentarrays.length; i++) {
            assertTrue(enrollee1 == enrollmentarrays[0]);
            assertTrue(enrollee6 == enrollmentarrays[1]);
            assertTrue(enrollee7 == enrollmentarrays[2]);
            assertTrue(enrollee8 == enrollmentarrays[3]);
            assertTrue(enrollee2 == enrollmentarrays[4]);
            assertTrue(enrollee9 == enrollmentarrays[5]);

        }

    }

    @Test
    public void testInsertSort() {

        System.out.println("Test the InsertsortofStudents");

        System.out.println("----------------------------");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());
        Enrollment[] enrollmentarrays = new Enrollment[6];

        enrollmentarrays[0] = enrollee1;
        enrollmentarrays[1] = enrollee2;
        enrollmentarrays[2] = enrollee6;
        enrollmentarrays[3] = enrollee7;
        enrollmentarrays[4] = enrollee8;
        enrollmentarrays[5] = enrollee9;

        Enrollment.InsertionSort insertionsortenrollment = enrollee1.new InsertionSort();

        insertionsortenrollment.insertionSortOfStudents(enrollmentarrays);

        System.out.println("After Insertion sorting the Enrollment Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < enrollmentarrays.length; i++) {
            System.out.println(enrollmentarrays[i]);

        }

        for (int i = 0; i < enrollmentarrays.length; i++) {
            assertTrue(enrollee1 == enrollmentarrays[0]);
            assertTrue(enrollee6 == enrollmentarrays[1]);
            assertTrue(enrollee7 == enrollmentarrays[2]);
            assertTrue(enrollee8 == enrollmentarrays[3]);
            assertTrue(enrollee9 == enrollmentarrays[4]);
            assertTrue(enrollee2 == enrollmentarrays[5]);

        }

    }
    
    
    @Test
    public void testLinkedlist() {

        System.out.println("Test the Linkedlist Data structure");

        System.out.println("----------------------------");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        Enrollment.LinkedList<Enrollment> linkedlists = enrollee1.new LinkedList<Enrollment>();

        Enrollment.Node first = enrollee1.new Node(enrollee1);

        Enrollment.Node middle = enrollee1.new Node(enrollee2);

        Enrollment.Node last = enrollee1.new Node(enrollee3);

        first.next = middle;
        middle.next = last;

        linkedlists.addFirst(first);
        linkedlists.AddLast(last);

        assertFalse(linkedlists.contains(enrollee9));

        assertTrue(linkedlists.contains(enrollee3));
        
        assertTrue(linkedlists.contains(enrollee1));
        
        linkedlists.removeFirst();
        linkedlists.removeLast();
        
        assertFalse(linkedlists.contains(enrollee9));

        assertFalse(linkedlists.contains(enrollee3));
        
        assertFalse(linkedlists.contains(enrollee1));

        linkedlists.printlist(first);

    }
    
    @Test
    public void testdoublyLinkedllist() {

        System.out.println("Test the doublyLinkedllist Data structure");

        System.out.println("----------------------------");

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());
        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());
        Enrollment enrollee3 = new Enrollment();
        Enrollment enrollee4 = enrollee1;
        Enrollment enrollee5 = null;
        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        Enrollment.doublyLinkedlist<Enrollment> doublylinkedlists = enrollee1.new doublyLinkedlist<Enrollment>();

        Enrollment.Node first = enrollee1.new Node(enrollee1);

        Enrollment.Node middle = enrollee1.new Node(enrollee2);

        Enrollment.Node last = enrollee1.new Node(enrollee3);

        first.next = middle;
        middle.next = last;

        doublylinkedlists.addFirst(first);
        doublylinkedlists.addlast(last);

        assertTrue(doublylinkedlists.contains(enrollee1));

        assertTrue(doublylinkedlists.contains(enrollee3));
        
        assertFalse(doublylinkedlists.contains(enrollee2));
        
        
        doublylinkedlists.removeFirst();
        doublylinkedlists.removeLast();
        
        assertFalse(doublylinkedlists.contains(enrollee1));

        assertFalse(doublylinkedlists.contains(enrollee3));
        
        assertFalse(doublylinkedlists.contains(enrollee2));
        
        

        

    }

}
