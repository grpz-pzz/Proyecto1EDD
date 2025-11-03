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
public class List<T> {
    Node<T> pFirst;
    Node<T> pLast;
    int length;

    public List(){
        this.pFirst = null;
        this.pLast = null;
        this.length = 0;
    }

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

    public Node<T> first(){
        return this.pFirst;
    }

    public Node<T> last(){
        return this.pLast;
    }

    public int length(){
        return this.length;
    }

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

    public void printList(){
        Node<T> current = pFirst;
        while (current != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
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
    
    
}
