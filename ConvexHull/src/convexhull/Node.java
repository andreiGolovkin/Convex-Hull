/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;


/**
 *
 * @author Andrei Golovkin
 */
public class Node <T> {
    private Node next = null;
    private Node prev = null;
    
    private T data = null;
    
    public Node(T data) {
        this.data = data;
    }
    
    public void setNext(Node newNext) {
        next = newNext;
    }
    
    public void setPrev(Node newPrev) {
        prev = newPrev;
    }
    
    public Node getNext() {
        return next;
    }
    
    public Node getPrev() {
        return prev;
    }
    
    public T getData() {
        return data;
    }
    
    public boolean hasNext() {
        return next != null;
    }
    
    public boolean hasPrev() {
        return prev != null;
    }
}
