package coursera.week2.percolation.week2.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int size;

	private class Node {
		Item item;
		Node prev;
		Node next;

		public Node(Item item) {
			this.item = item;
		}

		public Item getItem() {
			return item;
		}
	}

	public Deque() {
		first = null;
		last = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if(item == null) {
			throw new IllegalArgumentException("A null item cannot be added as the first, to the deque.");
		}
		Node newElement = new Node(item);
		newElement.next = first;
		first.prev = newElement;
		first = newElement;
		size++;
	}

	public void addLast(Item item) {
		if(item == null) {
			throw new IllegalArgumentException("A null item cannot be added as last, to the deque.");
		}
		Node newElement = new Node(item);
		last.next = newElement;
		newElement.prev = last;
		last = newElement;
		size++;
	}

	public Item removeFirst() {
		if (size == 0) {
			throw new NoSuchElementException("This queue does not have any elements (removeFirst.");
		}
		Item tmp = first.getItem();
		first = first.next;
		first.prev = null;
		size--;
		return tmp;
	}

	public Item removeLast() {
		if (size == 0) {
			throw new NoSuchElementException("This queue does not have any elements (removeLast).");
		}
		Node tmp = last;
		last = last.prev;
		last.next = null;
		size--;
		return tmp.getItem();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iter = new ListIterator();
		return iter;
	}
	
	private class ListIterator implements Iterator<Item>{
		
		Node current;
		public ListIterator() {
			current = first;
		}

		@Override
		public boolean hasNext() {			
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No more elements exist to iterate over.");
			}
			if(current != null) {
				Item item = current.getItem();
				current = current.next;
				return item;
			}
			return null;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Deque iterator does not support removing items from the iterator");
		}
		
	}

}
