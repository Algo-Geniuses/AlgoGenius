package Baekjoon.silver.스택_10828;

public class wooseok {

    // 1. stack을 직접 사용
    /*
    public static void main(String[] args) throws IOException {
        // 빠른 입력/출력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 명령 개수
        int N = Integer.parseInt(br.readLine());

        // 스택 선언
        Stack<Integer> stack = new Stack<>();

        // 명령 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
     */

    // 2. 선형 배열을 이용한 풀이
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];
        int top = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack[++top] = x;
                    break;
                case "pop":
                    sb.append(top == -1 ? -1 : stack[top--]).append("\n");
                    break;
                case "size":
                    sb.append(top + 1).append("\n");
                    break;
                case "empty":
                    sb.append(top == -1 ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(top == -1 ? -1 : stack[top]).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
     */

    // 3. 연결 리스트를 직접 구현한 풀이
    /*
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedStack {
        Node top = null;
        int size = 0;

        void push(int value) {
            Node node = new Node(value);
            node.next = top;
            top = node;
            size++;
        }

        int pop() {
            if (top == null) return -1;
            int val = top.data;
            top = top.next;
            size--;
            return val;
        }

        int top() {
            return top == null ? -1 : top.data;
        }

        int size() {
            return size;
        }

        int empty() {
            return top == null ? 1 : 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        LinkedStack stack = new LinkedStack();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
     */

    // 4. 덱을 이용한 풀이
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    stack.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.removeLast()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peekLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
     */
}
