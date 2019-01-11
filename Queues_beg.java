import java.io.*;
import java.util.*;

public class Queues_beg{
	public static void main(String args[]) {
		
		Queue queue = new Queue(1000);
		queue.enqueue(10); 
		queue.enqueue(20); 
		queue.enqueue(30); 
		queue.enqueue(40); 
		
		System.out.println(queue.dequeue() + 
				" dequeued from queue\n"); 
		
		System.out.println("Front item is " + 
							queue.front()); 
		
		System.out.println("Rear item is " + 
								queue.rear()); 
	} //end of main
	
	
	public static class Queue{
		
		//variables decalarion
		int front, rear, size;
		int capacity;
		int array[];
		
		//constructor when new object is created
		public Queue(int capacity) {
			
			//Maximum capacity of the queue
			this.capacity = capacity;
			
			//pointer pointing at top of queue
			front = 0;
			
			//pointer at tail of queue
			rear = capacity -1;
			
			//current size of the queue
			this.size = 0;
			
			//array again initialzed with capacity fresh
			array = new int[this.capacity];
		}
		
		//check if current size of queue is equal to its maximum capacity
		public boolean isFull(Queue queue) {
			if(queue.size == queue.capacity) {
				return true;
			}
			return false;
		}
		
		//check if queue is empty
		public boolean IsEmpty(Queue queue) {
			if(queue.size <= 0) return true; 
					else return false;
		}
		
		//method to enqueue i-e to push new element at the back or rear pointer 
		void enqueue(int item)
		{
			if(isFull(this)) {
				return;
			} else {
				
				//% this.capacity is very important else Array INDEX out OF BOUNDS EXCEPTION will occur !!
				//example rear is 999, then enqueud so 1000 %1001. means 1 always we get scaled values with respect to capacity
				
				this.rear = (this.rear + 1)%this.capacity; 
				this.array[this.rear]= item;
				this.size +=1;
				System.out.println(item+ " enqueued to queue");
			}
		}
		
		//method to dequeue i-e pop off the front item FIFO
		int dequeue()
		{
			if(IsEmpty(this)) {
				return -1;
			} else {
				int dequed_val = this.array[this.front];
				
				//shrunk the size of the array  an dmade the front to point to one level up !!
				
				//% this.capacity is very important else Array INDEX out OF BOUNDS EXCEPTION will occur !!
				//example front is 0 the increased to 1 the 1%1000 = 1;
				//size is reduced and front points to 1 means the first value always pointed
				//.dequed_val.two times dequeud then front =2, which is the very first value only
				
				this.front = (this.front + 1)%this.capacity;
				this.size = this.size - 1; 
				
				return dequed_val;
			}
		}
		
		// Method to get front of queue 
		int front() 
		{ 
			if (IsEmpty(this)) 
				return Integer.MIN_VALUE; 
			
			return this.array[this.front]; 
		} 
			
		// Method to get rear of queue 
		int rear() 
		{ 
			if (IsEmpty(this)) 
				return Integer.MIN_VALUE; 
			
			return this.array[this.rear]; 
		} 
	}
}//end of class main

