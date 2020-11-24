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
public class Selector <T> {
    private Node start, current, finish;
    private int size = 0;
    
    public Selector() {
        start = null;
        finish = null;
        current = null;
    }
    
    public void push(T newElement) {
        Node newNode = new Node<T>(newElement);
        if (current == null) {
            start = newNode;
            finish = newNode;
            current = newNode;
        } else {
            finish.setNext(newNode);
            newNode.setPrev(finish);
            finish = finish.getNext();
        }
        
        size++;
    }
    
    public void pop() {
        if (finish != null) {
            if (finish.hasPrev()) {
                finish = finish.getPrev();
            } else {
                start = null;
                finish = null;
                current = null;
            }
            size--;
        }
    }
    
    public void goToStart() {
        current = start;
    }
    
    public void goToEnd() {
        current = finish;
    }
    
    public T last() {
        return (T) finish.getData();
    }
    
    public T first() {
        return (T) start.getData();
    }
    
    public boolean hasNext() {
        return current != null && current.hasNext();
    }
    
    public boolean hasPrev() {
        return current != null && current.hasPrev();
    }
    
    public boolean isEmpty() {
        return current == null;
    }
    
    public void next() {
        if (this.hasNext()) {
            current = current.getNext();
        }
    }
    
    public void prev() {
        if (this.hasPrev()) {
            current = current.getPrev();
        }
    }
    
    public T getData() {
        return (T) current.getData();
    }
    
    public int size() {
        return size;
    }
}
