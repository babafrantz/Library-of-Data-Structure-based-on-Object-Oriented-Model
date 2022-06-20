
import java.io.IOException;
import static java.nio.file.Files.size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yomol
 */
public class Student extends Person {

    public static final int DEFAULT_STUDENTID = 0;
    public static final String PROGRAM = "Cert Three";
    public static final String DATEREGISTERED = "January";

    int studentID;
    String program;
    String dateRegistered;
    final Enrollment enrollment;

    public Student() {
        this(DEFAULT_STUDENTID, PROGRAM, DATEREGISTERED, new Enrollment());

    }

    public Student(int studentID, String program, String dateRegistered, Enrollment enrollment) {
        this(NAME, EMAIL, TELNUM, new Address(), studentID, program, dateRegistered, enrollment);

    }

    public Student(String name, String email, String telnum, Address address, int studentID, String program, String Registered, Enrollment enrollment) {
        super(name, email, telnum, address);
        this.studentID = studentID;
        this.program = program;
        this.enrollment = enrollment;
        this.dateRegistered = Registered;

    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.studentID);
        hash = 83 * hash + Objects.hashCode(this.program);
        hash = 83 * hash + Objects.hashCode(this.dateRegistered);
        hash = 83 * hash + Objects.hashCode(this.enrollment);
        return hash;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", program=" + program + ", dateRegistered=" + dateRegistered + ", enrollment=" + enrollment + '}';
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
        final Student other = (Student) obj;

        // We choose studentID because no two students can have the same studentID
        return Objects.equals(this.studentID, other.studentID);
    }

    // Overriding the Comparator method 
    // Sorting by field StudentID
    public class SortbyID implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {

            return t.studentID - t1.studentID;

        }

    }

    public class Sortbyprogram implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {

            return t.program.compareToIgnoreCase(t1.program);

        }
    }

    public class StudentSortingComparator implements Comparator<Student> {

        @Override
        public int compare(Student t, Student t1) {

            // for comparison 
            int ProgramCompare = t.program.compareToIgnoreCase(t1.program);
            int IDCompare = t.studentID - t1.studentID;

            // 2-level comparison using if-else block 
            if (ProgramCompare == 0) {
                return ((IDCompare == 0) ? ProgramCompare : IDCompare);
            } else {
                return ProgramCompare;
            }
        }
    }

    // Linear search Algorithim
    public class LinearSearch {

        public ArrayList<Student> search(ArrayList<Student> mystudents, Student value) {

            //Searching for value
            for (int i = 0; i < mystudents.size(); i++) {
                if (mystudents.get(i).equals(value)) {
                    System.out.println("Element" + value + "is  found at index  :" + i);
                }

            }
            return mystudents;

        }

    }

    // Binary Search Algorithim
    // This Algorithim assusmes a sorted list. 
    public class BinarySearch {

	

        public ArrayList<Student> binarySearchOfList(ArrayList<Student> list2, Student Key) {

            int min = 0;
            int N = list2.size();
            int max = N - 1;
            do {
                int mid = (min + max) / 2;

                if (Key.studentID > (list2.get(mid).studentID)) {
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
            System.out.println("----");
            return list2;

        }

    }
    
    // Selection Sort Algorithim

    public class SelectionSortStudent {

        public void selectionsort(Student[] studentarray) {
            
            System.out.println("The List before the selection sort is : ");
            
            for(int i =0; i<studentarray.length; i++){
                System.out.println(studentarray[i]);
            }

            for (int j = 0; j < studentarray.length-1; j++) {

                Student currentMin = studentarray[j];
                int currentMinIndex = j;

                for (int k = j+1; k <studentarray.length; k++) {

                    if (currentMin.studentID > studentarray[k].studentID) {
                        currentMin = studentarray[k];
                        currentMinIndex = k;
                    }

                }
                
                if (currentMinIndex !=j){
                    studentarray[currentMinIndex]=studentarray[j];
                    studentarray[j]=currentMin;
                    
                }
                
            }

        }
    }

    // Bubble Sort Algorithim
    public class BubbleSort {

        public void bubblesortofStudents(Student[] studentbubble) {

            Student temp;
            System.out.println("The List before bubble sort is : " + studentbubble);

            for (int i = 0; i < studentbubble.length; i++) {
                System.out.println(studentbubble[i]);
            }

            for (int j = 0; j < studentbubble.length - 2; j++) {
                
                for (int k = 0; k < studentbubble.length - 2; k++) {

                    if (studentbubble[k].studentID > studentbubble[k+1].studentID) {

                        temp = studentbubble[k+1];
                        studentbubble[k+1]=studentbubble[k];
                       studentbubble[k]=temp;
                    }

                }
            }

            
            }
        }

    

    //Insertion sort Algorithim
    public class InsertionSort {

        public void insertionSortOfStudents(Student[] studentarrays) {
            
             System.out.println("The Insertion sort array before sorting");

            for (int i = 0; i < studentarrays.length; i++) {
                Student currentElement = studentarrays[i];
                int k;
               
                System.out.println(studentarrays[i]);
                for (k = i - 1; k >= 0 && studentarrays[k].studentID > currentElement.studentID; k--) {

                    studentarrays[k+1]=studentarrays[k];
                }
                studentarrays[k+1]= currentElement;
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

    // Main Method
    public static void main(String[] args) {

        // Creating objects with different Constructors and calling ToString method

        Student student1 = new Student(3456, "Masters degree", "12-06-2017", new Enrollment());

        System.out.println(student1.toString());

        Student student2 = new Student(1234, "Bachelors degree", "13-07-2019", new Enrollment());

        System.out.println(student2.toString());

        Student student3 = new Student(8976, "Diploma degree", "18-10-2020", new Enrollment());

        System.out.println(student3.toString());

        Student student4 = student1;
        
        System.out.println(student4.toString());

        Student student5 = null;
        
         

        Student student6 = new Student(8978, "Cert Three", "18-12-2020", new Enrollment());
        
         System.out.println(student6.toString());
        Student student7 = new Student(8979, "Cert Four", "16-11-2020", new Enrollment());
        
         System.out.println(student7.toString());
        Student student8 = new Student(8980, "Cert Five", "15-10-2020", new Enrollment());
        
         System.out.println(student8.toString());
        Student student9 = new Student(8981, "Associate Degreee", "18-9-2020", new Enrollment());
        
         System.out.println(student9.toString());

       
        
         // Creating the SortByID object
        Student.SortbyID sortbyid = student1.new SortbyID();

       // Creating the SortByProgram Comparator Class

        Student.Sortbyprogram sortbyprogram = student2.new Sortbyprogram();

       // Creating the StudentSortingComparator Comparator Class

        Student.StudentSortingComparator studentsortingcomparator = student2.new StudentSortingComparator();

        System.out.println(studentsortingcomparator);
     // Creating the Linear Search Class
        Student.LinearSearch linearsearch = student1.new LinearSearch();

        
        
        // Creating the Binary Search Class
        Student.BinarySearch binarysearch = student1.new BinarySearch();

    
        // Creating the Selection sort search
       Student.SelectionSortStudent selectionsortstudent = student1.new SelectionSortStudent();

       

    }

}
