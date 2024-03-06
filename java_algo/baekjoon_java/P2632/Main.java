package baekjoon_java.P2632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int targetSize = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int aPizzaCount = Integer.parseInt(st.nextToken());
		int bPizzaCount = Integer.parseInt(st.nextToken());

		int aPizzaTotalSize = 0;
		int bPizzaTotalSize = 0;

		int[] aPizza = new int[aPizzaCount * 2];
		int[] bPizza = new int[bPizzaCount * 2];

		for (int i = 0; i < aPizzaCount; i++) {
			int pizzaSize = Integer.parseInt(br.readLine());
			aPizza[i] = pizzaSize;
			aPizza[i + aPizzaCount] = pizzaSize;
			aPizzaTotalSize += pizzaSize;
		}

		int[] aSum = new int[2000001];

		for (int i = 0; i < aPizzaCount; i++) {
			int sum = 0;
			for (int j = i; j < i + aPizzaCount - 1; j++) {
				sum += aPizza[j];
				aSum[sum]++;
			}
		}

		aSum[0] = 1;
		aSum[aPizzaTotalSize] = 1;

		for (int i = 0; i < bPizzaCount; i++) {
			int pizzaSize = Integer.parseInt(br.readLine());
			bPizza[i] = pizzaSize;
			bPizza[i + bPizzaCount] = pizzaSize;
			bPizzaTotalSize += pizzaSize;
		}

		int[] bSum = new int[2000001];

		for (int i = 0; i < bPizzaCount; i++) {
			int sum = 0;
			for (int j = i; j < i + bPizzaCount - 1; j++) {
				sum += bPizza[j];
				bSum[sum]++;
			}
		}

		bSum[0] = 1;
		bSum[bPizzaTotalSize] = 1;

		int answer = 0;

		for (int i = 0; i <= targetSize; i++) {
			answer += aSum[i] * bSum[targetSize - i];
		}

		System.out.println(answer);
	}
}
