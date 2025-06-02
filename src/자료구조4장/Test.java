package 자료구조4장;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Point2 {
	private int ix;
	private int iy;

	public Point2(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "(" + ix + ", " + iy + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Point2)) return false;
		Point2 p = (Point2) obj;
		return this.ix == p.ix && this.iy == p.iy;
	}
}

class objectStack {
	// --- 실행시 예외: 스택이 비어있음 ---//
	public static class EmptyGenericStackException extends Exception {
		public EmptyGenericStackException() {
			super("스택이 비어 있습니다.");
		}
	}

	// --- 실행시 예외: 스택이 가득 참 ---//
	public static class OverflowGenericStackException extends RuntimeException {
		public OverflowGenericStackException() {
			super("스택이 가득 찼습니다.");
		}
	}

	private List<Point2> data;
	private int capacity;
	private int top;

	public objectStack(int capacity) {
		this.capacity = capacity;
		this.top = 0;
		this.data = new ArrayList<>(capacity);
	}

	public boolean push(Point2 x) throws OverflowGenericStackException {
		if (isFull()) throw new OverflowGenericStackException();
		data.add(x);
		top++;
		return true;
	}

	public Point2 pop() throws EmptyGenericStackException {
		if (isEmpty()) throw new EmptyGenericStackException();
		top--;
		return data.remove(top);
	}

	public Point2 peek() throws EmptyGenericStackException {
		if (isEmpty()) throw new EmptyGenericStackException();
		return data.get(top - 1);
	}

	public void clear() {
		data.clear();
		top = 0;
	}

	public int indexOf(Point2 x) {
		return data.indexOf(x);
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		return top <= 0;
	}

	public boolean isFull() {
		return top >= capacity;
	}

	public void dump() {
		if (isEmpty()) {
			System.out.println("스택이 비어 있습니다.");
		} else {
			for (int i = 0; i < top; i++) {
				System.out.println(data.get(i));
			}
		}
	}
}
