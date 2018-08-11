import java.util.Scanner;

public class Main {
	class Card {
		String card;
		int value;
		Card(String card) {
			this.card = card;
			this.value = card.charAt(1) - '0';
		}
	}

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Card[] bubble = new Card[n];
		Card[] select = new Card[n];
		for (int i = 0; i < n; i++) {
			String card = scan.next();
			bubble[i] = new Card(card);
			select[i] = new Card(card);
		}

		bubbleSort(bubble, n);
		selectionSort(select, n);

		boolean stable = true;
		for (int i = 0; i < n; i++) {
			if (bubble[i].card.compareTo(select[i].card) != 0)
				stable = false;
		}

		for (int i = 0; i < n; i++)
			System.out.print(bubble[i].card + (i != n - 1 ? " ":"\n"));
		System.out.println("Stable");
		for (int i = 0; i < n; i++)
			System.out.print(select[i].card + (i != n - 1 ? " ":"\n"));
		System.out.println(stable ? "Stable" : "Not stable");
	}

	void bubbleSort(Card[] c, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= i + 1; j--) {
				if (c[j].value < c[j - 1].value) {
					Card tmp = c[j];
					c[j] = c[j - 1];
					c[j - 1] = tmp;
				}
			}
		}
	}

	void selectionSort(Card[] c, int n) {
		for (int i = 0; i < n; i++) {
			int minj = i;
			for (int j = i; j < n; j++) {
				if (c[j].value < c[minj].value)
					minj = j;
			}
			Card tmp = c[i];
			c[i] = c[minj];
			c[minj] = tmp;
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
