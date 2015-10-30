/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproblems;

/**
 *
 * @author Gunnar
 */
public class Node {
    int value;
    Node next;
    
    Node(int value) {
        this.value = value;
        this.next = null;
    }
    
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    public void setNext(Node n) {
        this.next = n;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public int getValue() {
        return this.value;
    }
}
