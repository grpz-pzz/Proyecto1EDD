/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author biancazullo
 */
public class List {
    Node<String> pFirst;
    Node<String> pLast; 
    int length; 
    public List(){
        this.pFirst = null;
        this.pLast = null;
        this.length = 0;
    }
    public void insert(String data){
        Node newNode = new Node(data);                        
        if (this.pFirst == null){
            this.pFirst = newNode;
            this.pLast = this.pFirst;
        }else{
            this.pLast.setNext(newNode);
            this.pLast = newNode;
             
        }
        this.length ++;
    }
    public Node first(){
        return this.pFirst;
    }       
    public Node last(){
        return this.pLast;
    }
    public int length(){
        return this.length;
    }
    public void delete(String m){
        Node n = this.pFirst;
        while (n != null){
            if (n.getData()==m){
                n = n.getNext();
            }
        }       
    }    
}
