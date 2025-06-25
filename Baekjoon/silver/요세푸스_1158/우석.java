package silver.요세푸스_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 우석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> origin = new LinkedList<>();
        Queue<Integer> josephus = new LinkedList<>();

        // 1부터 N까지의 숫자를 origin 큐에 추가
        for (int i = 1; i <= N; i++) {
            origin.offer(i);
        }

        while (!origin.isEmpty()) {
            for (int i = 1; i < K; i++) { // K-1 번 만큼 원형 큐처럼 돌리기
                origin.offer(origin.poll());
            }
            // K번째 사람 제거하고 josephus 큐에 추가
            josephus.offer(origin.poll());
        }

        // 결과 출력 형식 맞추기
        StringBuilder result = new StringBuilder("<");
        while (josephus.size() > 1) {
            result.append(josephus.poll()).append(", ");
        }
        result.append(josephus.poll()).append(">"); // 마지막 요소 추가

        System.out.println(result.toString());
    }
}