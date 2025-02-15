package ArrayList.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에는 배열의 크기 N과 최소 합 M이 주어진다.
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 두 번째 줄에는 배열 A의 원소들이 주어진다.
        int [] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A를 정렬한다.
        Arrays.sort(A);

        // 투 포인터 알고리즘을 사용하여 조건을 만족하는 쌍의 개수를 찾습니다.
        int count = 0;

        // A[0] -> Min
        int i = 0;

        // A[N-1]
        int j = N-1;
        while(i<j){
            if(A[i]+A[j]<M)i++;
            else if (A[i]+A[j]>M)j--;
            else {
                // 조건을 만족하는 쌍을 찾았으므로 카운트를 증가시키고, i와 j를 각각 증가, 감소시킨다.
                count++;
                i++; j--;
            }
        }
        System.out.println(count);
    }
}
