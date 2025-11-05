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
    public T get(int index) {
        if(index >= this.length)
            return null;
        
        Node<T> temp = this.pFirst;
        for(int i = 0; i < index; ++i) {
            temp = temp.getNext();
        }
        
        return temp.getData();
    }
    
    public void set(int index, T value) {
        if(index >= this.length)
            return;
        
        Node<T> n = this.pFirst;
        
        for(int i = 0; i <= index; i++)
        {
            n = n.getNext();
        }
        
        n.setData(value);
    }
    
    public int getIdxOf(T value) {
        if(this.pFirst == null)
            return -1;
        
        Node<T> temp = this.pFirst;
        int i = 0;
        
        while(temp != null) {
            if(temp.getData().equals(value))
                return i;
            
            temp = temp.getNext();
            i++;
        }
        
        return -1;
    }
    
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
