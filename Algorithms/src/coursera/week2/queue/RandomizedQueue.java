package coursera.week2.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] queue;
	private int size;

	public RandomizedQueue() {
		size = 0;
		int defaultSize = 1;
		queue = (Item[]) new Object[defaultSize];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException("Cannot enqueue null objects.");
		}
		if (queue.length == this.size) {
			Item[] tmpQueue = (Item[]) new Object[this.size * 2];
			for (int i = 0; i < queue.length; i++) {
				tmpQueue[i] = queue[i];
			}
			this.queue = tmpQueue;
		}
		queue[size] = item;

		this.size++;
	}

	public Item dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("There are no elements to dequeue.");
		}

		int index = getRandomIndex();
		Item item = queue[index];
		queue[index] = queue[size];
		queue[size] = null;
		size--;

		if (size > 4 && size < (queue.length / 4)) {
			Item[] tmpQueue = (Item[]) new Object[queue.length / 2];
			for (int i = 0; i < size; i++) {
				tmpQueue[i] = queue[i];
			}
			this.queue = tmpQueue;
		}

		return item;
	}

	public Item sample() {
		if (size == 0) {
			throw new NoSuchElementException("There are no elements in the queue.");
		}
		return queue[getRandomIndex()];
	}

	private int getRandomIndex() {
		int index = 0;
		while (true) {
			index = StdRandom.uniform(this.size);
			if (queue[index] != null) {
				return index;
			}
		}
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}