import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	final int INF = Integer.MAX_VALUE;

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] w = new int[n];
		int[] sortedW = new int[n];
		int[] transDestIdx = new int[n];
		int[] rank = new int[n];

		for (int i = 0; i < n; i++)
			rank[i] = INF;
		for (int i = 0; i < n; i++)
			sortedW[i] = w[i] = scan.nextInt();
		Arrays.sort(sortedW);
		for (int i = 0; i < n; i++)
			transDestIdx[i] = Arrays.binarySearch(sortedW, w[i]);

		if (DEBUG) {
			System.out.println(Arrays.toString(w));
			System.out.println(Arrays.toString(transDestIdx));
			System.out.println(Arrays.toString(sortedW));
		}

		int r = 0;
		for (int i = 0; i < n; i++) {
			int idx = i;
			if (rank[i] != INF)
				continue;
			while (rank[i] == INF) {
				rank[transDestIdx[idx]] = r;
				idx = transDestIdx[idx];
			}
			r++;
		}
		if (DEBUG)
			System.out.println(Arrays.toString(rank));

		HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i < n; i++) {
			LinkedList<Integer> list = map.get(rank[i]);
			if (list == null) {
				LinkedList<Integer> l = new LinkedList<Integer>();
				l.add(w[i]);
				map.put(rank[i], l);
			} else {
				list.add(w[i]);
				map.put(rank[i], list);
			}
		}

		if (DEBUG) {
			System.out.println(map.size());
			for (int i = 0; i < map.size(); i++) {
				LinkedList<Integer> list = map.get(i);
				System.out.println("map " + i + ": " + list.toString());
			}
		}

		int ans = 0;
		for (int i = 0; i < map.size(); i++) {
			LinkedList<Integer> list = map.get(i);
			if (list.size() == 1)
				continue;
			int sum = 0;
			int min = INF;
			int length = list.size();
			for (int j = 0; j < length; j++) {
				int num = list.get(j);
				sum += num;
				min = Math.min(min, num);
			}
			if (DEBUG)
				System.out.println(sum + " " + min + " " + length);
			ans += Math.min(sum + (length - 2) * min, sum + min + (length + 1) * sortedW[0]);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
