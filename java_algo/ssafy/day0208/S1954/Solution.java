package ssafy.day0208.S1954;

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] s = new String[]{"1",
                "1 2 \n4 3 ",
                "1 2 3 \n8 9 4 \n7 6 5",
                "1 2 3 4 \n12 13 14 5 \n11 16 15 6 \n10 9 8 7",
                "1 2 3 4 5 \n16 17 18 19 6 \n15 24 25 20 7 \n14 23 22 21 8 \n13 12 11 10 9",
                "1 2 3 4 5 6 \n20 21 22 23 24 7 \n19 32 33 34 25 8 \n18 31 36 35 26 9 \n17 30 29 28 27 10 \n16 15 14 13 12 11",
                "1 2 3 4 5 6 7 \n24 25 26 27 28 29 8 \n23 40 41 42 43 30 9 \n22 39 48 49 44 31 10 \n21 38 47 46 45 32 11 \n20 37 36 35 34 33 12 \n19 18 17 16 15 14 13",
                "1 2 3 4 5 6 7 8 \n28 29 30 31 32 33 34 9 \n27 48 49 50 51 52 35 10 \n26 47 60 61 62 53 36 11 \n25 46 59 64 63 54 37 12 \n24 45 58 57 56 55 38 13 \n23 44 43 42 41 40 39 14 \n22 21 20 19 18 17 16 15",
                "1 2 3 4 5 6 7 8 9 \n32 33 34 35 36 37 38 39 10 \n31 56 57 58 59 60 61 40 11 \n30 55 72 73 74 75 62 41 12 \n29 54 71 80 81 76 63 42 13 \n28 53 70 79 78 77 64 43 14 \n27 52 69 68 67 66 65 44 15 \n26 51 50 49 48 47 46 45 16 \n25 24 23 22 21 20 19 18 17 ",
                "1 2 3 4 5 6 7 8 9 10 \n36 37 38 39 40 41 42 43 44 11 \n35 64 65 66 67 68 69 70 45 12 \n34 63 84 85 86 87 88 71 46 13 \n33 62 83 96 97 98 89 72 47 14 \n32 61 82 95 100 99 90 73 48 15 \n31 60 81 94 93 92 91 74 49 16 \n30 59 80 79 78 77 76 75 50 17 \n29 58 57 56 55 54 53 52 51 18 \n28 27 26 25 24 23 22 21 20 19"};

        for (int testCase = 1; testCase <= n; testCase++) {
            int m = Integer.parseInt(br.readLine());
            sb.append("#").append(testCase).append("\n").append(s[m - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
