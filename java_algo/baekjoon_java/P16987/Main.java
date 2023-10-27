package baekjoon_java.P16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        Egg[] eggs = new Egg[n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, eggs);

        System.out.println(answer);
    }

    private static void dfs(int depth, Egg[] eggs) {
        if (depth == n) {
            isMaximumBrokenEgg(eggs);
            return;
        }

        Egg targetEgg = eggs[depth];

        if (targetEgg.isBroken()) {
            dfs(depth + 1, eggs);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == depth) {
                continue;
            }
            boolean check = targetEgg.breakEgg(eggs[i]);
            dfs(depth + 1, eggs);
            if (check) {
                targetEgg.rollbackEgg(eggs[i]);
            }
        }

    }

    private static void isMaximumBrokenEgg(Egg[] eggs) {
        int count = 0;
        for (Egg egg : eggs) {
            if (egg.isBroken()) {
                count++;
            }
        }
        answer = Math.max(count, answer);
    }
}

class Egg {
    private int durability;
    private int weight;

    public Egg(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }

    public boolean breakEgg(Egg egg) {
        if (egg.isBroken()) {
            return false;
        }
        this.durability -= egg.weight;
        egg.durability -= this.weight;
        return true;
    }

    public void rollbackEgg(Egg egg) {
        this.durability += egg.weight;
        egg.durability += this.weight;
    }

    public boolean isBroken() {
        return this.durability <= 0;
    }
}
