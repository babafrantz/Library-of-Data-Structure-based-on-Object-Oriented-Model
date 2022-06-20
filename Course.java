
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yomol
 */
public class Course {

    int courseID;
    String courseCode;
    String coursename;
    String cost;

    public Course() {
    }

    public Course(int courseID, String CourseCode, String coursename, String cost) {
        this.courseID = courseID;
        this.courseCode = CourseCode;
        this.coursename = coursename;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseCode=" + courseCode + ", coursename=" + coursename + ", cost=" + cost + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.courseID);
        hash = 23 * hash + Objects.hashCode(this.courseCode);
        hash = 23 * hash + Objects.hashCode(this.coursename);
        hash = 23 * hash + Objects.hashCode(this.cost);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;

        // We choose to compare the course code attribute here because no two course can have the same course code.
        if (this.courseID != other.courseID) {
            return false;
        }

        return true;
    }

    public class SortbyID implements Comparator<Course> {

        @Override
        public int compare(Course t, Course t1) {

            return t.courseID - t1.courseID;

        }

    }

    public class SortbyCourseCode implements Comparator<Course> {

        @Override
        public int compare(Course t, Course t1) {

            return t.courseCode.compareToIgnoreCase(t1.courseCode);

        }
    }

    public class CourseSortingComparator implements Comparator<Course> {

        @Override
        public int compare(Course t, Course t1) {

            // for comparison 
            int CourseCodeCompare = t.courseCode.compareToIgnoreCase(t1.courseCode);
            int IDCompare = t.courseID - t1.courseID;

            // 2-level comparison using if-else block 
            if (CourseCodeCompare == 0) {
                return ((IDCompare == 0) ? CourseCodeCompare : IDCompare);
            } else {
                return CourseCodeCompare;
            }
        }
    }

    public class LinearSearch {

        public ArrayList<Course> search(ArrayList<Course> mycourse, Course value) {

            //Searching for value
            for (int i = 0; i < mycourse.size() - 1; i++) {
                if (mycourse.get(i).equals(value)) {
                    System.out.println("Element" + value + "is  found at index  :" + i);
                }
            }
            return mycourse;
            }
        }
    

    public class BinarySearch {

        public ArrayList<Course> binarySearchOfList(ArrayList<Course> list2, Course Key) {

            int min = 0;
            int N = list2.size();
            int max = N - 1;
            do {
                int mid = (min + max) / 2;

                if (Key.courseID > (list2.get(mid).courseID)) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
                if (list2.get(mid).equals(Key)) {
                    System.out.println("Search Element found at index : " + mid);
                    break;
                }

                if (min > max) {
                    break;
                }
            } while (min <= max);
            System.out.println("--------------");
            return list2;

        }

    }

   public class SelectionSortCourse {

        public void selectionsort(Course[] coursearray) {
            
            System.out.println("The List before the selection sort is : ");
            
            for(int i =0; i<coursearray.length; i++){
                System.out.println(coursearray[i]);
            }

            for (int j = 0; j < coursearray.length-1; j++) {

               Course currentMin = coursearray[j];
                int currentMinIndex = j;

                for (int k = j+1; k <coursearray.length; k++) {

                    if (currentMin.courseID> coursearray[k].courseID) {
                        currentMin = coursearray[k];
                        currentMinIndex = k;
                    }

                }
                
                if (currentMinIndex !=j){
                    coursearray[currentMinIndex]=coursearray[j];
                    coursearray[j]=currentMin;
                    
                }
                
            }

        }
    }
    
    public class BubbleSort {

        public void bubblesortofcourses(Course[] coursebubble) {

          Course temp;
            System.out.println("The List before bubble sort is : " + coursebubble);

            for (int i = 0; i < coursebubble.length; i++) {
                System.out.println(coursebubble[i]);
            }

            for (int j = 0; j < coursebubble.length - 2; j++) {
                
                for (int k = 0; k < coursebubble.length - 2; k++) {

                    if (coursebubble[k].courseID > coursebubble[k+1].courseID) {

                        temp = coursebubble[k+1];
                        coursebubble[k+1]=coursebubble[k];
                       coursebubble[k]=temp;
                    }

                }
            }

            
            }
        }
    //Insertion sort
    
    //Insertion sort Algorithim
    public class InsertionSort {

        public void insertionSortOfCourse(Course[] coursearrays) {
            
             System.out.println("The Insertion sort array before sorting");

            for (int i = 0; i < coursearrays.length; i++) {
                Course currentElement = coursearrays[i];
                int k;
               
                System.out.println(coursearrays[i]);
                for (k = i - 1; k >= 0 && coursearrays[k].courseID > currentElement.courseID; k--) {

                    coursearrays[k+1]=coursearrays[k];
                }
                coursearrays[k+1]= currentElement;
            }
        }

    }
    
    // The Linkedlist Algorithim
    
    public class Node<T>{
        public T value;
        public Node next;
        public Node previous;
        
        public Node(T value){
            this.value = value;
        }
        public T getValue(){
            return value;
        }
        public Node getNext(){
            return next;
        }
        
        public void setValue(T value){
            this.value=value;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
    }
    
    public class LinkedList<T>{
        Node<T> head;
        Node<T> tail;
        int count = 0;
        
        public Node<T> getHead(){
            return head;
        }
        public void setHead(Node<T> head){
            this.head=head;
        }
        public Node<T> getTail(){
            return tail;
        }
        public void setTail(Node<T> tail){
            this.tail=tail;
        }
        
        public Node<T> addFirst(Node<T> node){
            
            Node<T> temp = head;
            
            head = node;
            
            head.next = temp;
            
            count++;
            
            if(count == 1){
                tail = head;
            }
            return node;
        }
        
        public Node<T> AddLast(Node<T> node){
            
            if(count == 0){ // no nodes
                head = node;
            }
            else{
                tail.next = node;
            }
            tail=node;
            count++;
            return node;
        }
        
        public void removeFirst(){
            
            if(count !=0){
                
                head = head.next;
                count --;
                
                if (count == 0){
                    tail=null;
                }
              
            }
               
        }
        
        public boolean contains(T item){
            Node<T> current = head;
            
            while(current !=null){
                
                if(current.value.equals(item)){
                    return true;
                }
                current = current.next;
            }
            
             return false;
        }
        
        public void removeLast(){
            if (count!=0){
                
                if(count==1){
                    head=null;
                    tail=null;
                }
                else{
                    Node<T> current = head;
                    
                    while (current.next !=tail){
                        current = current.next;
                    }
                    current.next =null;
                    tail = current;
                }
                count--;
            }
        }
        
        public void printlist(Node node){
            while (node!=null){
                
                System.out.println(node.getValue());
                node = node.getNext();
                
            }
        }
        
        public void add(int index, Node<T> node){
            
            if(index==0)addFirst(node);
            else if(index>=count++)AddLast(node);
            else{
                Node<T> current =head;
                for(int i=1; i<index; i++)
                    current = current.next;
                Node<T> temp = current.next;
                current.next = new Node<T>((T) node);
                (current.next).next =temp;
                count++;
            }
        }
        
    }
    
    public class doublyLinkedlist<T>{
        
        Node<T> head;
        Node<T> tail;
        int count =0;
        
        public void addFirst(Node<T> node){
            Node<T> temp = head;
            head=node;
            head.next=temp;
            if(count == 0){
                tail=head;
            }
            else{
                temp.previous = head;
            }
            count++;
        }
        
        public void addlast(Node<T> node){
            if(count == 0){
                head = node;
            }
            else {
                tail.next = node;
                node.previous=tail;
            }
            tail = node;
            count++;
        }
        
        public void removeFirst(){
            
            if(count!=0){
                head=head.next;
                count--;
                if(count==0){
                    tail=null;
                }
                else{
                    head.previous = null;
                }
            }
        }
        
        public void removeLast(){
            
            if(count!=0){
                if(count==1){
                    head=null;
                    tail=null;
                }
                else{
                    tail.previous.next=null;
                    tail=tail.previous;
                }
                count--;
            }
        }
        
        public boolean contains(T item){
            Node<T> current = head;
            while(current !=null){
                if(current.value.equals(item)){
                    return true;
                    
                }
                current=current.next;
            }
            return false;
        }
        
    }


    

    public static void main(String[] args) {

        Course course1 = new Course(125, "5JAW", "Java Web", "AUD800");

        System.out.println(course1.toString());

        Course course2 = new Course(128, "5DD", "Database Design", "AUD8000");

        System.out.println(course2.toString());

        Course course3 = new Course();

        System.out.println(course3.toString());

        Course course4 = course1;

        System.out.println(course4.toString());

        Course course5 = null;

        Course course6 = new Course(129, "5SDA", "System Architecture", "AUD800");
        
        System.out.println(course6.toString());
        
        Course course7 = new Course(130, "5TST", "Software Testing", "AUD750");
        
        System.out.println(course7.toString());
        
        Course course8 = new Course(131, "4JAB", "Basic Java", "AUD850");
        
        System.out.println(course8.toString());
        
        Course course9 = new Course(132, "55JAM", "Java Android", "AUD900");
        
        System.out.println(course9.toString());

        Course.SortbyID sortbyid = course1.new SortbyID();

        Course.SortbyCourseCode sortbycourse = course2.new SortbyCourseCode();

        Course.CourseSortingComparator coursesortingcomparator = course2.new CourseSortingComparator();

        
        Course.LinearSearch linearsearch = course1.new LinearSearch();

        
       
        Course.SelectionSortCourse selectionsortstudent = course1.new SelectionSortCourse();

        
       

    }

}
