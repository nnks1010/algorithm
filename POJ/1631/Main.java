import java.util.Scanner;

public class Main {
	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while (n-- > 0) {
			int p = scan.nextInt();
			int[] lis = new int[p + 1];
			for (int i = 1; i <= p; i++)
				lis[i] = Integer.MAX_VALUE;
			for (int i = 0; i < p; i++) {
				int port = scan.nextInt();
				if (lis[lowerBound(lis, port)] > port)
					lis[lowerBound(lis, port)] = port;
			}
			int ans = 0;
			for (int i = 0; i <= p; i++) {
//				System.out.print(lis[i] + " ");
				if (lis[i] == Integer.MAX_VALUE)
					break;
				ans = i;
			}
			System.out.println(ans);
		}
	}
	// 二分探索
	int lowerBound(int[] arr, int value) {
	    int low = 0;
	    int high = arr.length;
	    int mid;
	    while (low < high) {
	        mid = ((high - low) >>> 1) + low;
	        if (arr[mid] < value) {
	            low = mid + 1;
	        } else {
	            high = mid;
	        }
	    }
	    return low;
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
