import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

//BST Class
class BST {

	// more data items can be stored at the node of the tree:
	int item;

	// Tree is implemented by recursion only:
	BST left;
	BST right;

} // end of BST class

public class BST_Operations {

	/*
	 * public static void main(String args[]) { System.out.print("tree methods"); }
	 */

	// insert operations:
	public BST insert(BST root, int item) {

		// only one item then return that item only as the root
		// no insertion opertaion taskes place here:
		if (root == null) {
			BST newNode = new BST();
			newNode.item = item;

			newNode.left = null;
			newNode.right = null;

			root = newNode;
			return root;
		}

		// left
		// Tree is implemented by recursion only:
		else if (item <= root.item) {
			root.left = insert(root.left, item);
			return root;
		}

		// right
		else {
			root.right = insert(root.right, item);
			return root;
		}
	}

	// Traversal:

	// Pre-order: root left right
	public void pre_order(BST root) {

		if (root != null) {
			System.out.print(root.item + "");

			// recursion for left and right and print root as it is:
			pre_order(root.left);
			pre_order(root.right);
		}
	}

	// In-order: left root right
	public void in_order(BST root) {

		if (root != null) {
			in_order(root.left);
			System.out.print(root.item + "");

			in_order(root.right);
		}
	}

	// Post-order: left right root
	public void post_order(BST root) {

		if (root != null) {
			post_order(root.left);

			post_order(root.right);
			System.out.print(root.item + "");
		}
	}

	// BST Search Using Recursion:
	public boolean search_recursion(BST root, int item) {

		if (root == null)
			return false;

		// item to be searched is the root itself:
		// after so many recursive calls this will be the break condition beacus every
		// node itself in it is a root
		// so it will break here after its moved left and right
		if (root.item == item)
			return true;

		if (root.item < item)
			// move right
			return search_recursion(root.right, item);
		else
			// move left
			return search_recursion(root.left, item);
	}

	// BST Search using Normal Opertaions:
	// No recursion and actual traversal
	public void search(BST root, int item) {

		boolean flag = false;

		while (flag == false) {

			// escape condition when root is null or tree empty:
			if (root == null) {
				System.out.print("Tree is empty. No item found.");
				return;
			}

			if (root.item == item) {
				// break condition
				System.out.print("Item found");
				flag = true;
			} else if (item <= root.item) {
				// make left part of the node as root
				root = root.left;
			} else {
				// make the right as root
				root = root.right;
			}
		}
	}

	// O(Logn) or the height of the BST:
	// DEPTH FIRST SEARCH
	// straught line longest find ??
	public int height(BST root) {
		if (root == null) {
			return 0;
		}

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	// The diameter of a tree (sometimes called the width) is the number of nodes on
	// the longest path between two end nodes.
	/*
	 * Return max of following three 1) Diameter of left subtree 2) Diameter of
	 * right subtree 3) Height of left subtree + height of right subtree + 1
	 */
	public int diameter(BST root) {

		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.left);
		int rheight = height(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);

		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}

	// BFS: Bread First Search Level Order Traversal of tree
	// Take a QUEUE DS and put root
	// pop root --> left ---> then right
	public void bfs(BST root) {

		Queue<BST> q = new LinkedList<>();

		// root added into queue:
		q.add(root);

		while (!q.isEmpty()) {

			// remove root or the top element pointing to queue
			BST node = q.remove();
			if (node != null) {
				System.out.println(node.item);
			}

			// Add Node's left to queue once root is removed
			if (node.left != null)
				q.add(node.left);

			// add root's right to the queue one root is removed
			if (node.right != null)
				q.add(node.right);
		}

	}

	// FIND MAX element of the tree node:

	// we already know max will be existing in the right of the tree only
	// let root to be max first

	// then let max to be roots right
	// then let right of the root to be the root again and play around:

	public void findMax(BST root) {
		int max = root.item;

		while (root.right != null) {
			max = root.right.item;
			root = root.right;
		}

		System.out.println("Maximum element in the BST is:" + max);
	}

	// same with minimum for the tree
	public void findMin(BST root) {
		int min = root.item;

		while (root.left != null) {
			min = root.left.item;
			root = root.left;
		}

		System.out.println("Maximum element in the BST is:" + min);
	}

	// function to get the maximum width of the given tree. The width of a tree is
	// the maximum width among all levels
	public void findWidth(BST root) {
		int count = 0;
		int loopCount = 0;
		int max = 0;

		Queue<BST> q = new LinkedList<>();

		q.add(root);
		count++;

		loopCount = count;
		count = 0;

		while (!q.isEmpty()) {

			// check for maximum count at an given time in the queue

			// One Level traversal has ended: L to R
			if (loopCount == 0) {
				loopCount = count;
				if (count > max) {
					max = count;
				}
				// One Level traversal has ended: L to R ended:
				count = 0; // reset for next level
			}

			// remove from queue and increment the counter
			BST node = q.remove();
			if (node.left != null) {
				count++;
				q.add(node.left);
			}

			// similarly, do for the right:
			if (node.right != null) {
				count++;
				q.add(node.right);
			}

			loopCount--;
		}
		System.out.println("The width of the tree is:" + max);
	}

	public void printPaths(BST root, Stack<BST> list) {
		if (root != null) {
			list.push(root);
		} else
			return;

		if (root.left == null && root.right == null) {
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				BST element = (BST) iterator.next();
				System.out.print(element.item + " ");
			}
			System.out.println("\n");
			list.pop();
		} else {
			printPaths(root.left, list);
			printPaths(root.right, list);
			list.pop();
		}
	}

	// Print paths for the tree with only root as parameter
	// create an empty stack first:
	Stack<BST> s = new Stack<>();

	public void printPaths(BST root) {

		// if tree's root is not null push the root to the stack
		if (root != null) {
			s.push(root);
		}

		// left traversal
		if (root.left != null) {
			printPaths(root.left);
		}

		// right traversal
		if (root.right != null) {
			printPaths(root.right);
		}

		// now after traversing you reach the end of the traversal and root's left and
		// right both becomes null
		if (root.left == null && root.right == null) {

			// create an iterator for stack specifically:
			Iterator<BST> it = s.iterator();

			// while the itrariora's next is not null
			while (it.hasNext()) {

				// get the next element:
				BST element = (BST) it.next();

				System.out.print(element.item + " ");
			} // while loop ends here!!!
		}

		// Pop the elements from stack to repeat this whole process again and again in
		// recruiseve mode
		s.pop();
	}

	// Print level wise Traversal of BST using Dequeue double ended Queue:
	// Concept of flag and direction is used here:
	// direction from R-L and L-R is switched periodically based on flag's value

	// NO RECURSION USED HERE
	public void printLevelWise(BST root) {

		int loopCount = 1;
		int count = 0;
		boolean flag = true;

		// add the root to the dequeue and print it:
		Deque<BST> q = new LinkedList<>();
		q.add(root);
		System.out.println(root.item + "\n");

		// until the queue is empty
		while (!q.isEmpty()) {

			// it means that one level of the tree is now being traversed:
			if (loopCount == 0) {

				// again get the loopCount ready as per number of items in the queue
				loopCount = count;

				// reset the count value because we finished up with one level traversing now
				count = 0;

				// flag's value is reversed and the direction is change from R-L to L-R
				flag = !flag;
				System.out.println("\n\n");
			}

			BST node;

			if (flag) {

				// one direction: L TO R
				// because it's double ended queue

				// remove from First & add from LAST:
				node = q.removeFirst();
				if (node.left != null) {
					count++;
					q.addLast(node.left);
					System.out.print(node.left.item + " ");
				}
				if (node.right != null) {
					count++;
					q.addLast(node.right);
					System.out.print(node.right.item + " ");

				}

			} else {
				// opposite direction: R to L

				// remove from LAST & add from FIRST:
				node = q.removeLast();
				if (node.right != null) {
					count++;
					q.addFirst(node.right);
					System.out.print(node.right.item + " ");
				}
				if (node.left != null) {
					count++;
					q.addFirst(node.left);
					System.out.print(node.left.item + " ");

				}
			}
		} // while loop ends here:

		// so that we end up with traversal of one level
		loopCount--;

	}

	// VERY IMPORTANT CONCEPT OF MIRROR IMAGE FOR TREES:
	public void treeMirror(BST node) {

		// Case-1: Both null means the tree is empty
		if (node.left == null && node.right == null) {
			return;
		}

		// left has value good go Left recrusively
		if (node.left != null) {
			treeMirror(node.left);
		}

		// right has value great, go right now recusrvely after traversiy left part
		if (node.right != null) {
			treeMirror(node.right);
		}

		// when both left and right of the node are not null and have certain values
		// that can be reversed
		if (node.left != null && node.right != null) {

			// Swap the left and right nodes of the BST:
			BST temp = node.left;
			node.left = node.right;
			node.right = temp;

		} else if (node.left != null) {

			// only set for right value being exchange
			node.right = node.left;
			node.left = null;
		} else {
			node.left = node.right;
			node.right = null;
		}

	}

	// IMPORTANT:
	public boolean isBSTAndInRange(BST root, int minRange, int maxRange) {

		if (root == null)
			return true;

		boolean inRange = (root.item < maxRange && root.item >= minRange);

		// Left side traversal

		// root becomes ----->LEFT
		// LEFT BEcomes ------>Min Range
		// Right becomes -----> root.item
		boolean isRootMaxRange = isBSTAndInRange(root.left, minRange, root.item);

		// Right side traversal:

		// root becomes ----->RIGHT
		// LEFT BEcomes ------>ROOT Item
		// Right becomes -----> MaxRange
		boolean isRootMinRange = isBSTAndInRange(root.right, root.item, maxRange);

		boolean result = inRange && isRootMaxRange && isRootMinRange;

		return result;
	}

	//Example of the above implementation:
	// this return if the tree from root is a BST or not
	public boolean isBST(BST root) {
		return isBSTAndInRange(root, -999999, 9999999);
	}
	
	//Pre-order Traversal :
	//Root-left-right:
	//NON RECURSION SO USE STACKS INSTEAD:
	public void preOrder_nonrec(BST node) {

		//stack created with root inside:
		Stack<BST> s = new Stack<>();
		if (node != null) {
			s.push(node);
		}

		//Until the stack is not empty:
		while (!s.isEmpty()) {
			
			//pop out the root node and print it
			BST node_poped = s.pop();
			System.out.print(node_poped.item + " ");
			
			//STACK has an important property of LIFO so first right pused so that left is popped off first
			if (node_poped.right != null) {
				s.push(node_poped.right);
			}
			if (node_poped.left != null) {
				s.push(node_poped.left);
			}
			
			//STACK---> push is RIGHT AND LEFT
			//STACK---> pop is LEFT AND RIGHT
		}
	}
	
	//In-Order Traversal <Left /Root/ Right>
	//IMPORTANT:
	
	//Question: 
	//You need to implement using 1 pointer no left and right pointers
	//Using Non Recursion method:
	
	//Given as: only 1 pointer and a flag traverse the tree in-order now?
	class NodeInfo{
		BST bst;
		int flag;
	}
	
	public void inorder_nonRecursion_onePointer(BST node) {
		
		Stack<NodeInfo> s = new Stack<>();
		NodeInfo ni = new NodeInfo();
		
		//normally stack pushed
		//flag=2 means not prcessed YET !!
		if(node != null) {
			ni.bst = node;
			ni.flag = 2;
			s.push(ni);
		}
		
		while (!s.isEmpty()) {
			NodeInfo currNi = s.pop();
			BST currNode = currNi.bst;
			int flag = currNi.flag;

			// It means its left child has been processed. So print it.
			if (flag == 1) {
				System.out.print(currNode.item + " ");
			} else if (flag == 2) {

				//it means its yet to be processed
				
				//STACK Property LIFO
				//so push the right node first
				//then oush the left node
				//while popping off it will be done in reverse order
				
				//RIGHT:
				if (currNode.right != null) {
					currNi = new NodeInfo();
					currNi.bst = currNode.right;
					currNi.flag = 2;
					s.push(currNi);
				}

				//ROOT:
				currNi = new NodeInfo();
				currNi.bst = currNode;
				currNi.flag = 1;
				s.push(currNi);

				//LEFT:
				if (currNode.left != null) {
					currNi = new NodeInfo();
					currNi.bst = currNode.left;
					currNi.flag = 2;
					s.push(currNi);
				}
				
			}
		}//end of while loop
		
	} //end of function
	
	
	

}// end of main class for BST Operations !!
