import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Process {
		String name;
		int time;
		Process(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int q = scan.nextInt();
		Queue<Process> que = new LinkedList<Process>();
		for (int i = 0; i < n; i++) {
			String name = scan.next();
			int time = scan.nextInt();
			que.add(new Process(name, time));
		}
		for (int time = 0; !que.isEmpty();) {
			Process p = que.poll();
			if (p.time - q <= 0) {
				time += p.time;
				System.out.println(p.name + " " + time);
			} else {
				p.time -= q;
				que.add(p);
				time += q;
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
