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
    public Stack(){
        this.list = new List<>();
    }
    public void push(T element){
        this.list.insertFirst(element);
    }
    public T pop(){
        return this.list.deleteFirst();
    }
    public T peek(){
        Node<T> firstNode = this.list.first();
        if (firstNode != null){
            return firstNode.getData();
        }else{
            return null;
        }
    }
    public boolean isEmpty(){
            return this.list.length() == 0;
    }
}
