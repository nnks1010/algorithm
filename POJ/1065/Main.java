import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    class Pair {
        int l, w;
        Pair(int l, int w) {
            this.l = l; this.w = w;
        }
    }
    void run() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            Pair[] sticks = new Pair[n];
            for (int i = 0; i < n; i++) {
            	int l = scan.nextInt();
            	int w = scan.nextInt();
            	sticks[i] = new Pair(l, w);
            }
            Arrays.sort(sticks, new Comparator<Pair>() {
            	public int compare(Pair p1, Pair p2) {
            		if (p1.l - p2.l != 0)
            			return p1.l - p2.l;
            		else
            			return p1.w - p2.w;
            	}
            });
//            for (Pair p : sticks)
//            	System.out.println(p.l + " " + p.w);
            LinkedList<Pair> lis = new LinkedList<Pair>();
            lis.add(sticks[0]);
            for (int i = 1; i < n; i++) {
            	if (lis.getLast().w > sticks[i].w)
            		lis.add(sticks[i]);
            	else {
            		for (Pair s: lis) {
            			if (s.w <= sticks[i].w) {
            				s.w = sticks[i].w;
            				break;
            			}
            		}
            	}
//            	for (Pair p : lis)
//            		System.out.println(p.l + " " + p.w);
//            	System.out.println();
            }
            System.out.println(lis.size());
        }
    }
    public static void main(String[] args) {
        new Main().run();
    }
}
