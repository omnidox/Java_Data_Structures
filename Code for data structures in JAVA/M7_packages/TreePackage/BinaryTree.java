package TreePackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * A class that implements the ADT binary tree.
 * 
 * @author Frank M. Carrano.
 */

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	} // end default constructor

	public BinaryTree(T rootData) {
		root = new BinaryNode<>(rootData);
	} // end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	} // end constructor

	@Override
	public T getRootData() {
		if (isEmpty())
			throw new EmptyTreeException();
		else
			return root.getData();
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void clear() {
		root = null;

	}

	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreOrderIterator(root);
	}

	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostOrderIterator(root);
	}

	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		return new LevelOrderIterator(root);
	}

	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);

	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);

	}

	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {

		root = new BinaryNode<>(rootData);
		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);
		if ((rightTree != null) && !rightTree.isEmpty()) {
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		} // end if
		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();
		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	} // end privateSetTree

	protected void setRootData(T rootData) {
		root.setData(rootData);
	} // end setRootData

	protected void setRootNode(BinaryNode<T> rootNode) {
		root = rootNode;
	} // end setRootNode

	protected BinaryNode<T> getRootNode() {
		return root;
	} // end getRootNode

	private class InorderIterator implements Iterator<T> {
		private Stack<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;

		public InorderIterator() {
			nodeStack = new Stack<>();
			currentNode = root;
		} // end default constructor

		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		} // end hasNext

		public T next() {
			BinaryNode<T> nextNode = null;

			// Find leftmost node with no left child
			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			} // end while

			// Get leftmost node, then move to its right subtree
			if (!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				assert nextNode != null; // Since nodeStack was not empty
				// before the pop
				currentNode = nextNode.getRightChild();
			} else
				throw new NoSuchElementException();

			return nextNode.getData();
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end InorderIterator

	private class PreOrderIterator implements Iterator<T> {
		private Stack<BinaryNode<T>> nodeStack = new Stack<>();

		public PreOrderIterator(BinaryNode<T> root) {
			if (root != null) {
				nodeStack.push(root); // add to end of stack
			}
		} // end default constructor

		public boolean hasNext() {
			return !nodeStack.isEmpty();
		} // end hasNext

		public T next() {

			if (!hasNext()) {
				throw new NoSuchElementException("All nodes have been visited!");
			}

			BinaryNode<T> nextNode = nodeStack.pop(); // retrieve and remove the head of stack
			if (nextNode.hasRightChild())
				nodeStack.push(nextNode.getRightChild());
			if (nextNode.hasLeftChild())
				nodeStack.push(nextNode.getLeftChild());

			return nextNode.getData();
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end PreOrderIterator

	private class PostOrderIterator implements Iterator<T> {
		private Stack<BinaryNode<T>> nodeStack = new Stack<>();
		private BinaryNode<T> currentNode;
		private BinaryNode<T> top;

		public PostOrderIterator(BinaryNode<T> root) {
			currentNode = root;
			while (currentNode != null) {
				nodeStack.push(currentNode);
				if (currentNode.hasLeftChild()) {
					currentNode = currentNode.getLeftChild();
				} else {
					currentNode = currentNode.getRightChild();
				}
			}

		}

		public boolean hasNext() {
			return !nodeStack.isEmpty();
		} // end hasNext

		public T next() {

			if (!hasNext()) {
				throw new NoSuchElementException("All nodes have been visited!");
			}

			BinaryNode<T> nextNode = nodeStack.pop(); // retrieve and remove the head of stack
			if (!nodeStack.isEmpty()) {
				top = nodeStack.peek();
				if (nextNode == top.getLeftChild()) {
					currentNode = top.getRightChild();
					while (currentNode != null) {
						nodeStack.push(currentNode);
						if (currentNode.hasLeftChild()) {
							currentNode = currentNode.getLeftChild();
						} else {
							currentNode = currentNode.getRightChild();
						}
					}
				}
			}

			return nextNode.getData();
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end PreOrderIterator

	private class LevelOrderIterator implements Iterator<T> {

		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();

		public LevelOrderIterator(BinaryNode<T> root) {
			queue.add(root);

		}

		public boolean hasNext() {
			return !queue.isEmpty();
		} // end hasNext

		public T next() {

			if (!hasNext()) {
				throw new NoSuchElementException("All nodes have been visited!");
			}

			BinaryNode<T> tempNode = queue.poll();

			if (tempNode.hasLeftChild()) {
				queue.add(tempNode.getLeftChild());
			}

			if (tempNode.hasRightChild()) {
				queue.add(tempNode.getRightChild());
			}

			return tempNode.getData();
		} // end next

		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end PreOrderIterator

}
