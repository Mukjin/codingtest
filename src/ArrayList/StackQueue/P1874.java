package ArrayList.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력 받을 수열의 길이
        int A[] = new int[N]; // 입력된 수열을 저장할 배열

        // 수열 입력 받기
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>(); // 스택 생성
        int num = 1; // 스택에 push할 숫자 (1부터 시작)
        boolean result = true; // 가능한 수열인지 여부를 판단하는 플래그
        StringBuffer bf = new StringBuffer(); // 결과 저장을 위한 StringBuffer

        // 수열을 스택을 이용해 만들 수 있는지 확인
        for(int i = 0; i < A.length; i++){
            int su = A[i]; // 현재 수열의 숫자

            if(su >= num){ // 현재 숫자가 스택에 push할 숫자보다 크거나 같다면
                while(su >= num){
                    stack.push(num++); // 숫자를 스택에 push
                    bf.append("+\n"); // push 연산 기록
                }
                stack.pop(); // 스택에서 pop하여 해당 숫자를 제거
                bf.append("-\n"); // pop 연산 기록
            } else {
                int n = stack.pop(); // 스택에서 pop하여 비교
                if(n > su) { // pop한 값이 필요한 값보다 크면 수열을 만들 수 없음
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n"); // pop 연산 기록
                }
            }
        }

        // 가능한 경우 결과 출력
        if(result) System.out.println(bf.toString());
    }
}