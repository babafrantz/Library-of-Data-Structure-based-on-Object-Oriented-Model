
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
public class Enrollment {

    int enrollmentID;
    String dateEnrolled;
    String grade;
    String semester;
    Course course;

    public Enrollment() {

    }

    public Enrollment(int enrollmentID, String dateEnrolled, String grade, String semester, Course course) {

        this.enrollmentID = enrollmentID;
        this.dateEnrolled = dateEnrolled;
        this.grade = grade;
        this.semester = semester;
        this.course = course;
    }

    public String getDateEnrolled() {
        return dateEnrolled;
    }

    public String getGrade() {
        return grade;
    }

    public String getSemester() {
        return semester;
    }

    public Course getCourse() {
        return course;
    }

    public void setDateEnrolled(String dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "enrollmentID=" + enrollmentID + ", dateEnrolled=" + dateEnrolled + ", grade=" + grade + ", semester=" + semester + ", course=" + course + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.enrollmentID);
        hash = 79 * hash + Objects.hashCode(this.dateEnrolled);
        hash = 79 * hash + Objects.hashCode(this.grade);
        hash = 79 * hash + Objects.hashCode(this.semester);
        hash = 79 * hash + Objects.hashCode(this.course);
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
        final Enrollment other = (Enrollment) obj;

        // We choose enrollmentID because no two enrollments can have the same enrollmentID
        if (this.enrollmentID != other.enrollmentID) {
            return false;
        }

        return true;
    }

    public class SortbyID implements Comparator<Enrollment> {

        @Override
        public int compare(Enrollment t, Enrollment t1) {

            return t.enrollmentID - t1.enrollmentID;

        }

    }

    public class SortbySemester implements Comparator<Enrollment> {

        @Override
        public int compare(Enrollment t, Enrollment t1) {

            return t.semester.compareToIgnoreCase(t1.semester);

        }
    }

    public class EnrollmentSortingComparator implements Comparator<Enrollment> {

        @Override
        public int compare(Enrollment t, Enrollment t1) {

            // for comparison 
            int dateEnrollmentCompare = t.semester.compareToIgnoreCase(t1.semester);
            int IDCompare = t.enrollmentID - t1.enrollmentID;

            // 2-level comparison using if-else block 
            if (dateEnrollmentCompare == 0) {
                return ((IDCompare == 0) ? dateEnrollmentCompare : IDCompare);
            } else {
                return dateEnrollmentCompare;
            }
        }
    }

    // Linear search Algorithim
    public class LinearSearch {

        public ArrayList<Enrollment> search(ArrayList<Enrollment> myenrollments, Enrollment value) {

            //Searching for value
            for (int i = 0; i < myenrollments.size(); i++) {
                if (myenrollments.get(i).equals(value)) {
                    System.out.println("Element" + value + "is  found at index  :" + i);
                }

            }
            return myenrollments;

        }

    }

    // Binary Search Algorithim
    // This Algorithim assusmes a sorted list. 
    public class BinarySearch {

        public ArrayList<Enrollment> binarySearchOfList(ArrayList<Enrollment> enrollments, Enrollment Key) {

            int min = 0;
            int N = enrollments.size();
            int max = N - 1;
            do {
                int mid = (min + max) / 2;

                if (Key.enrollmentID > (enrollments.get(mid).enrollmentID)) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
                if (enrollments.get(mid).equals(Key)) {
                    System.out.println("Search Element found at index : " + mid);
                    break;
                }

                if (min > max) {
                    break;
                }
            } while (min <= max);
            System.out.println("----");
            return enrollments;

        }

    }

    // Selection Sort Algorithim
    public class SelectionSortStudent {

        public void selectionsort(Enrollment[] enrollmentarray) {

            System.out.println("The List before the selection sort is : ");

            for (int i = 0; i < enrollmentarray.length; i++) {
                System.out.println(enrollmentarray[i]);
            }

            for (int j = 0; j < enrollmentarray.length - 1; j++) {

                Enrollment currentMin = enrollmentarray[j];
                int currentMinIndex = j;

                for (int k = j + 1; k < enrollmentarray.length; k++) {

                    if (currentMin.enrollmentID > enrollmentarray[k].enrollmentID) {
                        currentMin = enrollmentarray[k];
                        currentMinIndex = k;
                    }

                }

                if (currentMinIndex != j) {
                    enrollmentarray[currentMinIndex] = enrollmentarray[j];
                    enrollmentarray[j] = currentMin;

                }

            }

        }
    }

    // Bubble Sort Algorithim
    public class BubbleSort {

        public void bubblesortofStudents(Enrollment[] enrollmentbubble) {

            Enrollment temp;
            System.out.println("The List before bubble sort is : " + enrollmentbubble);

            for (int i = 0; i < enrollmentbubble.length; i++) {
                System.out.println(enrollmentbubble[i]);
            }

            for (int j = 0; j < enrollmentbubble.length - 2; j++) {

                for (int k = 0; k < enrollmentbubble.length - 2; k++) {

                    if (enrollmentbubble[k].enrollmentID > enrollmentbubble[k + 1].enrollmentID) {

                        temp = enrollmentbubble[k + 1];
                        enrollmentbubble[k + 1] = enrollmentbubble[k];
                        enrollmentbubble[k] = temp;
                    }

                }
            }

        }
    }

    //Insertion sort Algorithim
    public class InsertionSort {

        public void insertionSortOfStudents(Enrollment[] insertionenrollmentarrays) {

            System.out.println("The Insertion sort array before sorting");

            for (int i = 0; i < insertionenrollmentarrays.length; i++) {
                Enrollment currentElement = insertionenrollmentarrays[i];
                int k;

                System.out.println(insertionenrollmentarrays[i]);
                for (k = i - 1; k >= 0 && insertionenrollmentarrays[k].enrollmentID > currentElement.enrollmentID; k--) {

                    insertionenrollmentarrays[k + 1] = insertionenrollmentarrays[k];
                }
                insertionenrollmentarrays[k + 1] = currentElement;
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

        Enrollment enrollee1 = new Enrollment(23456, "12-07-2017", "70%", "Second", new Course());

        System.out.println(enrollee1.toString());

        Enrollment enrollee2 = new Enrollment(34567, "13-08-2019", "80%", "Third", new Course());

        System.out.println(enrollee2.toString());

        Enrollment enrollee3 = new Enrollment();

        System.out.println(enrollee3.toString());

        Enrollment enrollee4 = enrollee1;

        System.out.println(enrollee4.toString());

        Enrollment enrollee5 = null;

        Enrollment enrollee6 = new Enrollment(23489, "12-07-2017", "90%", "First", new Course());

        System.out.println(enrollee6.toString());
        Enrollment enrollee7 = new Enrollment(23490, "12-07-2017", "50%", "Fifth", new Course());

        System.out.println(enrollee7.toString());
        Enrollment enrollee8 = new Enrollment(23491, "12-07-2017", "30%", "Sixth", new Course());

        System.out.println(enrollee8.toString());
        Enrollment enrollee9 = new Enrollment(23499, "12-07-2017", "400%", "Seventh", new Course());

        System.out.println(enrollee9.toString());
        
        //Creating the SortByID object

        Enrollment.SortbyID sortbyid = enrollee1.new SortbyID();

        System.out.println(sortbyid);
        
        // Creating the SortByProgram object

        Enrollment.SortbySemester sortbyprogram = enrollee2.new SortbySemester();

        System.out.println(sortbyprogram);
        
        // Creating the EnrollmentSortingComparator object

        Enrollment.EnrollmentSortingComparator enrollmentsortingcomparator = enrollee2.new EnrollmentSortingComparator();
        
        // Creating the linearsearch object

        Enrollment.LinearSearch linearsearch = enrollee1.new LinearSearch();
        
        // Creating the binarysearch object

        Enrollment.BinarySearch binarysearch = enrollee1.new BinarySearch();
        
        

    
}
}
