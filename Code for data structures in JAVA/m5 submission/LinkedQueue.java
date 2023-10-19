//Rafael Hidalgo

public class LinkedQueue<T> implements QueueInterface<T> {

	private Node firstNode; // References node at front of queue
	private Node lastNode; // References node at back of queue

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
	} // end default constructor

	@Override
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		lastNode = newNode;

	}

	@Override
	public T getFront() {
		if (isEmpty())
			throw new EmptyQueueException();
		else
			return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;

	}

	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node

	@Override
	public T dequeue() {
		T front = getFront(); // Might throw EmptyQueueException
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if (firstNode == null)
			lastNode = null;
		return front;
	}

}
