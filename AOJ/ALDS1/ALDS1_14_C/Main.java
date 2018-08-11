import java.util.Scanner;

public class Main {
	final boolean DEBUG = false;
	final long b1 = 401;
	final long b2 = 397;
	final long h = 1000000007l;
	final int MAX_SIZE = 1000;

	int N, M, T, P, Q;
	char[][] field, pattern;
	long[][] hash, tmp;
	void computeHash(char[][] a, int n, int m) {
		long t1 = 1;
		for (int j = 0; j < Q; j++) t1 = (t1 * b1) % h;
		
		for (int i = 0; i < n; i++) {
			long e = 0;
			for (int j = 0; j < Q; j++) e = (e * b1 + a[i][j]) % h;
			
			for (int j = 0; j + Q <= m; j++) {
				tmp[i][j] = e;
				if (j + Q < m) e = (e * b1 - t1 * a[i][j] + a[i][j + Q]) % h;
				e = (e < 0) ? e + h : e;
			}
		}
		
		long t2 = 1;
		for (int i = 0; i < P; i++) t2 = (t2 * b2) % h;
		
		for (int j = 0; j + Q <= m; j++) {
			long e = 0;
			
			for (int i = 0; i < P; i++) e = (e * b2 + tmp[i][j]) % h;
			
			for (int i = 0; i + P <= n; i++) {
				hash[i][j] = e;
				if (i + P < n) e = (e * b2 - t2 * tmp[i][j] + tmp[i + P][j]) % h;
				e = (e < 0) ? e + h : e;
			}
		}
	}
	void run() {
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		field   = new char[MAX_SIZE][MAX_SIZE];
		pattern = new char[MAX_SIZE][MAX_SIZE];
		hash = new long[MAX_SIZE][MAX_SIZE];
		tmp  = new long[MAX_SIZE][MAX_SIZE];
		N = scan.nextInt();
		M = scan.nextInt();
		for (int i = 0; i < N; i++) {
			char[] line = scan.next().toCharArray();
			for (int j = 0; j < M; j++)
				field[i][j] = line[j];
		}
		P = scan.nextInt();
		Q = scan.nextInt();
		for (int i = 0; i < P; i++) {
			char[] line = scan.next().toCharArray();
			for (int j = 0; j < Q; j++)
				pattern[i][j] = line[j];
		}
		computeHash(pattern, P, Q);
		long pHash = hash[0][0];
		
		computeHash(field, N, M);
		for (int i = 0; i + P <= N; i++)
			for (int j = 0; j + Q <= M; j++)
				if (hash[i][j] == pHash)
					sb.append(i + " " + j + "\n");
		
		System.out.print(sb.toString());
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
