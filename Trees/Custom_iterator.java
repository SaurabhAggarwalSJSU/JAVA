import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

//custom value enum:

public class Custom_iterator {

	public static void main(String args[]) {
		
		

	} // void main ends here

	// Pre-order traversal:
	// Each time when we visit a node, we push its right and left children into the
	// stack so that we can access left subtree first and then right subtree.

	// More specifically, we use ArrayDeque which a "resizable-array implementation
	// of the Deque interface". It provides amortized constant time operations such
	// as add, poll, push, and pop, etc.
	// It provides amortized constant time operations such as add, poll, push, and
	// pop, etc.
	// This iterator takes extra spaces for the stack, which is O(h) at worst case,
	// where h is the height of the tree.

	// Create a Tree Node:
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Create an interface that extends the Java class iterator of type Integer
	// Next:
	// HasNext:
	public interface PreOrderBinaryTreeIterator extends Iterator<Integer> {
		// Returns the next integer a in the pre-order traversal of the given binary
		// tree.

		// the outputs will be 4, 2, 1, 3, 6, 5, 7.
		public Integer next();

		// Return true if traversal has not finished; otherwise, return false.
		public boolean hasNext();
		
		//remove node
		public void remove();
	}

	public static class PreOrderBinaryTreeIteratorImp implements PreOrderBinaryTreeIterator {

		// create a stack for storing root--left--right
		Stack<TreeNode> stack = new Stack<TreeNode>();

		// create constructor for this implm:
		public PreOrderBinaryTreeIteratorImp(TreeNode root) {

			if (root != null) {
				stack.push(root);
			}
		}
		
		//returns true/false based on if stack is empty or not:
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		@Override
		public Integer next() {
			
			//no more next exists:
			if (!hasNext()) {
				throw new NoSuchElementException("All nodes have been visited!");
			}
			
			//pop one by one
			TreeNode res = stack.pop(); // retrieve and remove the head of queue
			
			//insert right first becsuse of LIFO
			if (res.right != null)
				stack.push(res.right);
			
			//then insert right for LIFO
			//because the left will be poped out later
			if (res.left != null)
				stack.push(res.left);

			return res.val;
		}
		
		//no remove is supported at the time of traversal:
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove is not supported");
		}
	}
	
	public static ArrayList<Integer> preOrderTraversal(TreeNode root){
		
		//results array:
		ArrayList<Integer> resultLst = new ArrayList<Integer>();
		
		//create an iterator:
		PreOrderBinaryTreeIteratorImp itr = new PreOrderBinaryTreeIteratorImp(root);
		
		//traverse:
		while(itr.hasNext()) {
			resultLst.add(itr.next());
		}
		
		return resultLst;
	}

//main Class ends here
}
