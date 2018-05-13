import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	class Cow implements Comparable<Cow> {
		int min, max;
		Cow(int min, int max) {
			this.min = min; this.max = max;
		}
		public int compareTo(Cow c) {
			return this.max - c.max;
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		int c = scan.nextInt();
		int l = scan.nextInt();
		PriorityQueue<Cow> que = new PriorityQueue<Cow>();
		Cow[] cows = new Cow[c];
		for (int i = 0; i < c; i++) {
			int min = scan.nextInt();
			int max = scan.nextInt();
			cows[i] = new Cow(min, max);
		}
		int[][] lotion = new int[l][2];
		for (int i = 0; i < l; i++) {
			lotion[i][0] = scan.nextInt();
			lotion[i][1] = scan.nextInt();
		}
		Arrays.sort(cows, new Comparator<Cow>() {
			public int compare(Cow a, Cow b) {
				return a.min - b.min;
			}
		});
		Arrays.sort(lotion, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		int ans = 0, i = 0, j = 0;
		while (j < l) {
			while (i < c) {
				if (cows[i].min <= lotion[j][0]) {
					que.add(cows[i]);
					i++;
				} else {
					break;
				}
			}
			if (que.isEmpty()) j++;
			while (!que.isEmpty()) {
				Cow cow = que.poll();
				if (cow.max < lotion[j][0]) continue;
				lotion[j][1]--;
				ans++;
				if (lotion[j][1] == 0) j++;
				break;
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
