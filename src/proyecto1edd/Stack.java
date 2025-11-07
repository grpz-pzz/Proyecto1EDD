/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author biancazullo
 * @param <T>
 */
public class Stack<T> {
    private final List<T> list;
    
    /**
     * creates stack data structure
     * with primitives made in list 
     */
    public Stack(){
        this.list = new List<>();
    }
    
    /**
     * inserts element on the first position of the list
     * @param element 
     */
    public void push(T element){
        this.list.insertFirst(element);
    }
    
    /**
     * deletes first element of the list 
     * @return deleted first
     */
    public T pop(){
        return this.list.deleteFirst();
    }
    
    /**
     * 
     * @return first element of the list
     */
    public T peek(){
        Node<T> firstNode = this.list.first();
        if (firstNode != null){
            return firstNode.getData();
        }else{
            return null;
        }
    }
    
    /**
     * returns true is list is empty
     * @return true or false 
     */
    public boolean isEmpty(){
            return this.list.length() == 0;
    }
}
