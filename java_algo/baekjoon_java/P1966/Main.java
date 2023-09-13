package baekjoon_java.P1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int documentLength = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Document> documents = new LinkedList<>();

            for (int j = 0; j < documentLength; j++) {
                documents.add(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int answer = 1;

            while (true) {
                Document now = documents.poll();
                int maxPriority = -1;
                for (Document document : documents) {
                    maxPriority = Math.max(document.priority, maxPriority);
                }
                if (now.priority >= maxPriority) {
                    if (now.position == targetIndex) {
                        break;
                    }
                    answer++;
                }
                if (now.priority < maxPriority) {
                    documents.add(now);
                }
            }

            System.out.println(answer);
        }
    }

    private static final class Document {
        int position;
        int priority;

        public Document(int position, int priority) {
            this.position = position;
            this.priority = priority;
        }
    }
}
