/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 * generic data structure code for a list 
 * @author biancazullo
 * @param <T>
 */
public class List<T> {
    Node<T> pFirst;
    Node<T> pLast;
    int length;
    public List(){
        this.pFirst = null;
        this.pLast = null;
        this.length = 0;
    }
    /** 
     * inserts data into the list
     * @param data 
     */
    public void insert(T data){
        Node newNode = new Node(data);
        if (this.pFirst == null){
            this.pFirst = newNode;
            this.pLast = this.pFirst;
        } else {
            this.pLast.setNext(newNode);
            this.pLast = newNode;
        }
        this.length++;
    }
    
    /**
     * primitive to return first node
     * @return first 
     */
    public Node<T> first(){
        return this.pFirst;
    }
    
    /**
     * primitive to return last node of the list
     * @return last 
     */
    public Node<T> last(){
        return this.pLast;
    }
    
    /**
     * primitive of length of the list
     * @return length 
     */
    public int length(){
        return this.length;
    }
    
    /**
     * finds and deletes element of the list 
     * @param m 
     */
    public void delete(T m){
        Node<T> current = pFirst;
        Node<T> previous = null;
        while (current != null){
            if (current.getData().equals(m)){
                if (previous == null){
                    this.pFirst = current.getNext();
                    if (pFirst == null){ 
                        pLast = null;
                    }
                } else {
                    previous.setNext(current.getNext());
                    if (current == this.pLast) 
                        this.pLast = previous;
                }
                length--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }
    
    /**
     * prints list to console 
     */
    public void printList(){
        Node<T> current = pFirst;
        while (current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
    
    /**
     * inserts an element at the first position of the list
     * for the stack structure
     * @param data 
     */
    public void insertFirst(T data){
        Node newNode = new Node(data);
        if (this.pFirst == null){
            this.pFirst = newNode;
            this.pLast = newNode;
        }else{
            newNode.setNext(this.pFirst);
            this.pFirst = newNode;
        }
        this.length++;
    }
    
    /**
     * deletes first element of the list
     * for the stack structure
     * @return 
     */
    public T deleteFirst(){
        if (this.pFirst == null){
            return null;
        }
        T data = this.pFirst.getData();
        this.pFirst= this.pFirst.getNext();
        this.length--;
        
        if (this.pFirst == null){
            this.pLast = null;
        }
        return data;
    }
    
    /**
     * to find an element of the list
     * @param m
     * @return 
     */
    public boolean contains(T m){
        Node<T> current = pFirst;
        while (current != null){
            if (current.getData().equals(m)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    } 
    
    /**
     * converts data to string
     * @return data as a string
     */
    public String asString() {
        String s = "[";
        Node<T> n = this.pFirst;
        while(n != null) {
            s += n.getData();
            s += ", ";
            n = n.getNext();
        }
        
        s = s.substring(0, s.length() - 2);
        s += "]";
        return s;
    }
}
