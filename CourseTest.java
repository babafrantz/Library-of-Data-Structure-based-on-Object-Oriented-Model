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
public class CourseTest {

    public CourseTest() {
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

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        assertFalse((2134567890) == (course1.hashCode()));
        assertEquals((-1665914953), (course1.hashCode()));
        assertFalse((1416089630) == (course2.hashCode()));
        assertEquals((-520609715), (course2.hashCode()));
        assertFalse((1775582038) == course3.hashCode());
        assertEquals(1399205, course3.hashCode());
        assertFalse(2069849908 == course4.hashCode());
        assertEquals(-1665914953, course4.hashCode());

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testEquals() {

        try {

            Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
            Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
            Course course3 = new Course();
            Course course4 = course1;
            Course course5 = null;
            Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
            Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
            Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
            Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

            assertFalse(course1.equals(course2));
            assertFalse(course2.equals(course3));
            assertTrue(course4.equals(course1));
            assertFalse(course4.equals(course3));
            assertFalse(course5.equals(course4));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testSortByID() {

        System.out.println("Test by SortByID");

        // Creating objects from different Student class Constructor
        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        // Creating an object of the SORTBYID class
        Course.SortbyID sortbyid = course1.new SortbyID();

        assertEquals(3, (sortbyid.compare(course1, course2)));
        assertEquals(-125, (sortbyid.compare(course3, course2)));
        assertEquals(-3, (sortbyid.compare(course6, course9)));

        //Adding Student objects to a list data structure. 
        ArrayList<Course> list = new ArrayList<>();

        list.add(course1);
        list.add(course2);
        list.add(course3);
        list.add(course6);
        list.add(course7);
        list.add(course8);

        //Adding student objects to a set data structure.
        Set<Course> setofcourses = new HashSet<>();

        setofcourses.add(course1);
        setofcourses.add(course2);
        setofcourses.add(course3);
        setofcourses.add(course6);
        setofcourses.add(course7);
        setofcourses.add(course8);

        Iterator<Course> custIterators = setofcourses.iterator();

        System.out.println("Set of Courses:\n");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Course> custIterator = list.iterator();

        System.out.println("Before Sorting list :\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, sortbyid);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting list:\n");
        for (Course Sorting : list) {
            System.out.println(Sorting);
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Sorting list by ID in the reverse");

        // Sorting the list using comparators in reverse order
        Collections.sort(list, sortbyid.reversed());

        for (Course s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testSortByCourseCode() {

        System.out.println("Test by SortByCourseCode");

        // Creating objects from different Student class Constructor
        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        // Creating an object of the SORTBYPROGRAM class
        Course.SortbyCourseCode sortbycoursecode = course1.new SortbyCourseCode();

        assertEquals(-6, (sortbycoursecode.compare(course1, course2)));
        assertEquals(-1, (sortbycoursecode.compare(course8, course2)));
        assertEquals(62, (sortbycoursecode.compare(course6, course9)));

        //Adding Student objects to a list data structure. 
        ArrayList<Course> list = new ArrayList<>();

        list.add(course1);
        list.add(course2);
        list.add(course6);
        list.add(course7);
        list.add(course8);
        list.add(course9);
        //Adding student objects to a set data structure.
        Set<Course> setofcourses = new HashSet<>();

        setofcourses.add(course1);
        setofcourses.add(course2);
        setofcourses.add(course6);
        setofcourses.add(course7);
        setofcourses.add(course8);
        setofcourses.add(course9);

        Iterator<Course> custIterators = setofcourses.iterator();

        System.out.println("Set of Courses:\n");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Course> custIterator = list.iterator();

        System.out.println("Before Sorting list:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, sortbycoursecode);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting list:\n");
        for (Course Sorting : list) {
            System.out.println(Sorting);
        }

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("Sorting list by program in the reverse");

        // Sorting the list using comparators in reverse order
        Collections.sort(list, sortbycoursecode.reversed());

        for (Course s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testCourseSortingComparator() {

        System.out.println("Test by EnrollmentSortingComparator");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        // Creating an object of the StudentSortingComparator Class
        Course.CourseSortingComparator coursesortingcomparator = course2.new CourseSortingComparator();

        assertEquals(-47, coursesortingcomparator.compare(course9, course1));
        assertEquals(-1, coursesortingcomparator.compare(course8, course6));
        assertEquals(6, coursesortingcomparator.compare(course2, course1));
        assertEquals(1, coursesortingcomparator.compare(course4, course8));
        assertEquals(-1, coursesortingcomparator.compare(course6, course7));

        ArrayList<Course> list = new ArrayList<>();

        list.add(course1);
        list.add(course2);
        list.add(course6);
        list.add(course7);
        list.add(course8);
        list.add(course9);

        //Adding student objects to a set data structure.
        Set<Course> setofcourses = new HashSet<>();

        setofcourses.add(course1);
        setofcourses.add(course2);
        setofcourses.add(course6);
        setofcourses.add(course7);
        setofcourses.add(course8);
        setofcourses.add(course9);

        Iterator<Course> custIterators = setofcourses.iterator();

        System.out.println("Set of Courses");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        Iterator<Course> custIterator = list.iterator();

        System.out.println("Before Sorting:\n");
        while (custIterator.hasNext()) {
            System.out.println(custIterator.next());
        }

        // sorting using Collections.sort(al, comparator); 
        Collections.sort(list, coursesortingcomparator);

        // after Sorting arraylist: iterate using enhanced for-loop 
        System.out.println("\n\nAfter Sorting:\n");
        for (Course Sorting : list) {
            System.out.println(Sorting);
        }
    }

    @Test
    public void testLinearSearch() {

        System.out.println("Test the LinearSearch");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        Course.LinearSearch linearsearch = course1.new LinearSearch();

        ArrayList<Course> list = new ArrayList<>();

        list.add(course1);
        list.add(course2);
        list.add(course3);
        list.add(course6);
        list.add(course7);
        list.add(course8);

        assertTrue(list == linearsearch.search(list, course1));
        assertTrue(list == linearsearch.search(list, course2));
        assertTrue(list == linearsearch.search(list, course6));
        assertTrue(list == linearsearch.search(list, course8));
        assertTrue(list == linearsearch.search(list, course7));
        assertTrue(list == linearsearch.search(list, course8));

    }

    @Test
    public void testBinarySearch() {

        System.out.println("Test the BinarySearch");

        System.out.println("----------------------------");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        Course.BinarySearch binarysearch = course1.new BinarySearch();

        Course.SortbyID sortbyid = course1.new SortbyID();

        ArrayList<Course> list = new ArrayList<>();

        list.add(course1);
        list.add(course2);
        list.add(course3);
        list.add(course6);
        list.add(course7);
        list.add(course8);

        Collections.sort(list, sortbyid);

        Iterator<Course> custIterators = list.iterator();

        System.out.println("Sorted List before binary search");
        while (custIterators.hasNext()) {
            System.out.println(custIterators.next());
        }

        System.out.println("-----------------------------");

        assertTrue(list == binarysearch.binarySearchOfList(list, course1));
        assertTrue(list == binarysearch.binarySearchOfList(list, course2));
        assertTrue(list == binarysearch.binarySearchOfList(list, course6));
        assertTrue(list == binarysearch.binarySearchOfList(list, course7));
        assertTrue(list == binarysearch.binarySearchOfList(list, course8));
        assertTrue(list == binarysearch.binarySearchOfList(list, course9));

    }

    @Test
    public void testSelectionSortCourse() {

        System.out.println("Test the SelectionSortStudent");

        System.out.println("----------------------------");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        Course.SelectionSortCourse selectionsortcourse = course1.new SelectionSortCourse();

        Course[] coursearrays = new Course[6];

        coursearrays[0] = course1;
        coursearrays[1] = course2;
        coursearrays[2] = course6;
        coursearrays[3] = course7;
        coursearrays[4] = course8;
        coursearrays[5] = course9;

        // Selection sorting the student class. 
        selectionsortcourse.selectionsort(coursearrays);

        System.out.println("After select sorting the Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < coursearrays.length; i++) {
            System.out.println(coursearrays[i]);
        }

        for (int i = 0; i < coursearrays.length; i++) {
            assertTrue(course2 == coursearrays[0]);
            assertTrue(course1 == coursearrays[1]);
            assertTrue(course6 == coursearrays[2]);
            assertTrue(course7 == coursearrays[3]);
            assertTrue(course8 == coursearrays[4]);
            assertTrue(course9 == coursearrays[5]);

        }
    }

    @Test
    public void testBubbleSort() {

        System.out.println("Test the bubblesortofStudents");

        System.out.println("----------------------------");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        Course[] coursearrays = new Course[6];

        coursearrays[0] = course1;
        coursearrays[1] = course2;
        coursearrays[2] = course6;
        coursearrays[3] = course7;
        coursearrays[4] = course8;
        coursearrays[5] = course9;

        Course.BubbleSort bubblesortenrollment = course1.new BubbleSort();

        bubblesortenrollment.bubblesortofcourses(coursearrays);

        System.out.println("After bubble sorting the Student Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < coursearrays.length; i++) {
            System.out.println(coursearrays[i]);

        }

        for (int i = 0; i < coursearrays.length; i++) {
            assertTrue(course2 == coursearrays[0]);
            assertTrue(course1 == coursearrays[1]);
            assertTrue(course6 == coursearrays[2]);
            assertTrue(course7 == coursearrays[3]);
            assertTrue(course8 == coursearrays[4]);
            assertTrue(course9 == coursearrays[5]);

        }

    }

    @Test
    public void testInsertSort() {

        System.out.println("Test the InsertsortofStudents");

        System.out.println("----------------------------");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");
        
        
        Course[] coursearrays = new Course[6];

        coursearrays[0] = course1;
        coursearrays[1] = course2;
        coursearrays[2] = course6;
        coursearrays[3] = course7;
        coursearrays[4] = course8;
        coursearrays[5] = course9;

        Course.InsertionSort insertionsortenrollment = course1.new InsertionSort();

        insertionsortenrollment.insertionSortOfCourse(coursearrays);

        System.out.println("After Insertion sorting the Enrollment Array ");
        System.out.println("--------------------------------");

        for (int i = 0; i < coursearrays.length; i++) {
            System.out.println(coursearrays[i]);

        }

        for (int i = 0; i < coursearrays.length; i++) {
            assertTrue(course2 == coursearrays[0]);
            assertTrue(course1 == coursearrays[1]);
            assertTrue(course6 == coursearrays[2]);
            assertTrue(course7 == coursearrays[3]);
            assertTrue(course8 == coursearrays[4]);
            assertTrue(course9 == coursearrays[5]);

        }

    }
    
    @Test
    public void testLinkedlist() {

        System.out.println("Test the Linkedlist Data structure");

        System.out.println("----------------------------");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        Course.LinkedList<Course> linkedlists = course1.new LinkedList<Course>();

        Course.Node first = course1.new Node(course1);

        Course.Node middle = course1.new Node(course2);

        Course.Node last = course1.new Node(course3);

        first.next = middle;
        middle.next = last;

        linkedlists.addFirst(first);
        linkedlists.AddLast(last);

        assertFalse(linkedlists.contains(course9));

        assertTrue(linkedlists.contains(course3));
        
        assertTrue(linkedlists.contains(course1));
        
        linkedlists.removeFirst();
        linkedlists.removeLast();
        
        assertFalse(linkedlists.contains(course9));

        assertFalse(linkedlists.contains(course3));
        
        assertFalse(linkedlists.contains(course1));

        linkedlists.printlist(first);

    }
    
    @Test
    public void testdoublyLinkedllist() {

        System.out.println("Test the doublyLinkedllist Data structure");

        System.out.println("----------------------------");

        Course course2 = new Course(125, "5JAW", "Java Web", "AUD800");
        Course course1 = new Course(128, "5DD", "Database Design", "AUD8000");
        Course course3 = new Course();
        Course course4 = course1;
        Course course5 = null;
        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");

        Course.doublyLinkedlist<Course> doublylinkedlists = course1.new doublyLinkedlist<Course>();

        Course.Node first = course1.new Node(course1);

        Course.Node middle = course1.new Node(course2);

        Course.Node last = course1.new Node(course3);

        first.next = middle;
        middle.next = last;

        doublylinkedlists.addFirst(first);
        doublylinkedlists.addlast(last);

        assertTrue(doublylinkedlists.contains(course1));

        assertTrue(doublylinkedlists.contains(course3));
        
        assertFalse(doublylinkedlists.contains(course2));
        
        
        doublylinkedlists.removeFirst();
        doublylinkedlists.removeLast();
        
        assertFalse(doublylinkedlists.contains(course1));

        assertFalse(doublylinkedlists.contains(course3));
        
        assertFalse(doublylinkedlists.contains(course2));
        
        

        

    }

}
