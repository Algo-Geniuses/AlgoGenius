package Baekjoon.silver.큐2_18258;

public class wooseok {

    //1. Queue 인터페이스를 이용한 풀이
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //명령어 입력 횟수
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<>();
        int input = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            switch(S) {
                case "push" :
                    input = Integer.parseInt(st.nextToken());
                    que.offer(input);
                    break;
                case "pop" :
                    if(que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(que.size()).append("\n");
                    break;
                case "empty" :
                    if(que.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if(que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.peek()).append("\n");
                    break;
                case "back" :
                    if(que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(input).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }*/

    // 2. 선형 배열을 이용한 풀이
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue_Array queue = new Queue_Array(N);

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push" :
                    int value = Integer.parseInt(st.nextToken());
                    queue.push(value);
                    break;
                case "pop" :
                    sb.append(queue.pop()).append("\n");
                    break;

                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty" :
                    sb.append(queue.queueIsEmpty()? 1:0).append("\n");
                    break;

                case "front" :
                    sb.append(queue.front()).append("\n");
                    break;

                case "back" :
                    sb.append(queue.back()).append("\n");
                    break;

            }
        }
        System.out.println(sb);

    }
     */

    // 3. 원형 큐를 이용한 풀이
    /*
    static int[] queue;    // 정수형 큐
    static int front;      // 삭제 위치
    static int rear;       // 삽입 위치
    static int size;       // 현재 요소 개수
    static int capacity;   // 전체 큐 크기 (N+1로 설정)

    public static void init(int n) {
        capacity = n + 1;         // 원형 큐는 한 칸을 비워야 함
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public static boolean isEmpty() {
        return front == rear;
    }

    public static boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void push(int x) {
        if (isFull()) return;         // 문제 조건상 터질 일은 없음
        rear = (rear + 1) % capacity;
        queue[rear] = x;
        size++;
    }

    public static int pop() {
        if (isEmpty()) return -1;
        front = (front + 1) % capacity;
        int value = queue[front];
        size--;
        return value;
    }

    public static int getSize() {
        return size;
    }

    public static int getFront() {
        if (isEmpty()) return -1;
        return queue[(front + 1) % capacity];
    }

    public static int getBack() {
        if (isEmpty()) return -1;
        return queue[rear];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        init(N);  // 큐 크기 초기화 (명령 수 기준으로 넉넉하게)

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    push(x);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(getSize()).append("\n");
                    break;
                case "empty":
                    sb.append(isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(getFront()).append("\n");
                    break;
                case "back":
                    sb.append(getBack()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
     */

    // 4. 연결리스트를 직접 구현한 풀이
    /*
    static class LinkedListQueue {
        private static class Node {
            int data;
            Node next;
            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node front;
        private Node rear;
        private int size;

        public LinkedListQueue() {
            front = null;
            rear = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        public int dequeue() {
            if (isEmpty()) return -1;
            int value = front.data;
            front = front.next;
            size--;
            if (isEmpty()) rear = null;
            return value;
        }

        public int peekFront() {
            if (isEmpty()) return -1;
            return front.data;
        }

        public int peekBack() {
            if (isEmpty()) return -1;
            return rear.data;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedListQueue queue = new LinkedListQueue();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.enqueue(x);
                    break;
                case "pop":
                    sb.append(queue.dequeue()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.peekFront()).append("\n");
                    break;
                case "back":
                    sb.append(queue.peekBack()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
     */

    // 5 .덱을 이용한 풀이
    /*
    public static void main(String[] args) throws IOException {
        // 빠른 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 명령어 개수
        int N = Integer.parseInt(br.readLine());

        // Deque를 큐처럼 사용
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    queue.addLast(value); // 큐의 뒤쪽에 추가
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.removeFirst()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
     */
}
