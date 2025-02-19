package ArrayList.StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Queue 자료구조로 LinkedList 사용
        Queue<Integer> myQueue = new LinkedList<>();

        int N = sc.nextInt();

        // 1부터 N까지의 숫자를 큐에 삽입
        for(int i = 1; i <= N; i++) {
            myQueue.add(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while(myQueue.size() > 1) {

            // 맨 앞의 카드를 버림
            myQueue.poll();

            // 그 다음 카드를 꺼내서
            int temp = myQueue.poll();

            // 다시 큐의 맨 뒤에 추가
            myQueue.add(temp);
        }

        // 마지막으로 남은 카드 출력
        System.out.println(myQueue.poll());
    }
}
