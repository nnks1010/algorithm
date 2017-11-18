import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	void run() {
		/*
		 * 各区間の開始時間の早い順にソートする
		 * stallに区間を格納する時は終了時間の一番早いstallを取り出し，そのstallの終了時間を格納する区間の終了時間で更新する
		 * もし，ない場合は新しいstallを作成して，そこに格納する．
		 */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] cow = new int[n][3];
		for (int i = 0; i < n; i++) {
			cow[i][0] = scan.nextInt();
			cow[i][1] = scan.nextInt();
			cow[i][2] = i;
		}
		Arrays.sort(cow, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		// for (int i = 0; i < n; i++) {
		// System.out.println(Arrays.toString(cow[i]));
		// }
		Queue<int[]> que = new PriorityQueue<int[]>(n + 1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int[] ans = new int[n];
		que.add(cow[0]);
		ans[cow[0][2]] = 1;
		for (int i = 1; i < n; i++) {
			int[] c = que.peek();
			if (cow[i][0] > c[1]) {
				que.poll();
				c[1] = cow[i][1];
				que.add(c);
				ans[cow[i][2]] = ans[c[2]];
			} else {
				que.add(cow[i]);
				ans[cow[i][2]] = que.size();
			}
		}
		System.out.println(que.size());
		for (int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
