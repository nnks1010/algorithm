import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	int[] rank, tmp;
	int n, k;

	void run() {
		Scanner scan = new Scanner(System.in);
		String t = scan.next();
		int q = scan.nextInt();
		Integer[] sa = new Integer[t.length() + 1];
		rank = new int[t.length() + 1];
		tmp = new int[t.length() + 1];
		constructSA(t.toCharArray(), sa);
		if (DEBUG)
			System.out.println("sa: " + Arrays.toString(sa));
		for (int i = 0; i < q; i++) {
			String p = scan.next();
			System.out.println(contain(t, sa, p) ? 1 : 0);
		}
	}

	boolean contain(String s, Integer[] sa, String t) {
		int a = 0, b = s.length(), subIndex = 0;
		while (b - a > 1) {
			int c = (a + b) / 2;
			subIndex = sa[c] + t.length() > s.length() ? s.length() : sa[c] + t.length();
			if (DEBUG) {
				System.out.print("substr(" + sa[c] + ", " + subIndex + ")");
				System.out.print(", cmp: " + (s.substring(sa[c], subIndex).compareTo(t) < 0));
				System.out.println(", str: " + s.substring(sa[c], subIndex));
			}
			if (s.substring(sa[c], subIndex).compareTo(t) < 0) a = c;
			else b = c;
		}
		subIndex = sa[b] + t.length() > s.length() ? s.length() : sa[b] + t.length();
		return s.substring(sa[b], subIndex).compareTo(t) == 0;
	}

	boolean compareSA(int i, int j) {
		if (rank[i] != rank[j]) return rank[i] < rank[j];
		else {
			int ri = i + k <= n ? rank[i + k] : -1;
			int rj = j + k <= n ? rank[j + k] : -1;
			return ri < rj;
		}
	}

	void constructSA(char[] s, Integer[] sa) {
		n = s.length;
		
		for (int i = 0; i <= n; i++) {
			sa[i] = i;
			rank[i] = i < n ? s[i] : -1;
		}

		Comparator<Integer> compare_sa = new Comparator<Integer>() {
			@Override
			public int compare(Integer i, Integer j) {
				if (rank[i] != rank[j]) return rank[i] == rank[j] ? 0 : (rank[i] < rank[j] ? -1 : 1);
				else {
					int ri = i + k <= n ? rank[i + k] : -1;
					int rj = j + k <= n ? rank[j + k] : -1;
					return ri == rj ? 0 : (ri < rj ? -1 : 1);
				}
			}
		};
		for (k = 1; k <= n; k *= 2) {
			Arrays.sort(sa, 0, n + 1, compare_sa);
			tmp[sa[0]] = 0;
			for (int i = 1; i <= n; i++) {
				tmp[sa[i]] = tmp[sa[i - 1]] + (compareSA(sa[i - 1], sa[i]) ? 1 : 0);
			}
			for (int i = 0; i <= n; i++) {
				rank[i] = tmp[i];
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
