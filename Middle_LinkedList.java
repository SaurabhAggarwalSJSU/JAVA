
// Java program to find n'th node from end

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

public class Middle_LinkedList {
	Node head; // head of the list

	/* Linked List node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	
	void printMiddle() 
    { 
        Node slow_ptr = head;  //speed X1 times:
        Node fast_ptr = head;  //speed X2 times:
        
        if (head != null) 
        { 
            while (fast_ptr != null && fast_ptr.next != null) 
            { 
                fast_ptr = fast_ptr.next.next;  //twice the speed here X2:
                slow_ptr = slow_ptr.next; 
            } 
            System.out.println("The middle element is [" + 
                                slow_ptr.data + "] \n"); 
        } 
    } 
	
	public void printList() 
    { 
        Node tempNode = head; 
        while (tempNode != null) 
        { 
            System.out.print(tempNode.data+"->"); 
            tempNode = tempNode.next; 
        } 
        System.out.println("NULL"); 
    } 
	
	
	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		
		Node new_node = new Node(new_data);

		/* . Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Drier program to test above methods */
	public static void main(String[] args) {
		Middle_LinkedList llist = new Middle_LinkedList();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(35);

		llist.printList();
		llist.printMiddle();
		
	}
}
