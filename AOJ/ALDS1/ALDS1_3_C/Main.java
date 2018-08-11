import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	class List {
		class Cell {
			Cell prev, next;
			int v;
			Cell(int value) {
				this.v = value;
			}
		}
		Cell cell, lastCell;
		void insert(int value) {
			if (cell == null) {
				cell = new Cell(value);
				lastCell = cell;
				return;
			}
			cell.next = new Cell(value);
			cell.next.prev = cell;
			cell = cell.next;
		}
		void delete(int value) {
			Cell c = cell;
			while (c != null) {
				if (c.v != value) {
					c = c.prev;
					continue;
				}
				Cell prev = c.prev;
				Cell next = c.next;
				if (prev == null && next == null) {
					cell = null;
				} else if (prev == null) {
					next.prev = null;
					lastCell = next;
				} else if (next == null) {
					prev.next = null;
					cell = prev;
				} else {
					prev.next = next;
					next.prev = prev;
				}
				break;
			}
		}
		void deleteFirst() {
			if (cell.prev == null) {
				cell = null;
			} else {
				cell.prev.next = null;
				cell = cell.prev;
			}
		}
		void deleteLast() {
			if (lastCell.next == null) {
				cell = null;
				lastCell = null;
			} else {
				lastCell = lastCell.next;
				lastCell.prev = null;
			}
		}
		void debugPrint() {
			Cell c = cell;
			while (c != null) {
				System.out.print("[" + (c.prev == null ? "null" : c.prev.v) + ", " + c.v + ", " + (c.next == null ? "null" : c.next.v) + "]" + (c.prev == null ? "\n" : " "));
				c = c.prev;
			}
		}
		void print() {
			Cell c = cell;
			while (c != null) {
				System.out.print(c.v + (c.prev == null ? "\n" : " "));
				c = c.prev;
			}
		}
	}
	void run() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List list = new List();
		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			int val = 0;
			if (command.charAt(6) == ' ') {
				val = Integer.parseInt(command.substring(7));
				command = command.substring(0, 6);
			}
			switch (command) {
			case "insert":
				list.insert(val);
				break;
			case "delete":
				list.delete(val);
				break;
			case "deleteFirst":
				list.deleteFirst();
				break;
			case "deleteLast":
				list.deleteLast();
				break;
			}
		}
		list.print();
	}
	public static void main(String[] args) {
		try {
			new Main().run();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
