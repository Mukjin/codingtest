package ArrayList.PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// P11659 구간 합 구하기
public class P11659 {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 사용
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄 입력: 수의 개수(N)와 질의 개수(M) 입력받기
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        // 누적 합 배열 선언 (1-based index 사용)
        long[]S = new long[suNo + 1];

        // 두 번째 줄 입력: N개의 수를 입력받아 누적 합 배열을 생성
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i<=suNo; i++)
        {
            // 현재 숫자를 이전까지의 누적 합에 더해서 저장
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        // M개의 질의 처리
        for(int q = 0; q<quizNo; q++){
            // i부터 j까지의 구간 합을 구하는 질의 입력받기
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            // 시작 인덱스
            int i = Integer.parseInt(stringTokenizer.nextToken());
            // 끝 인덱스
            int j = Integer.parseInt(stringTokenizer.nextToken());

            // 구간 합 계산: S[j] - S[i-1] (누적 합 배열을 이용하여 빠르게 계산)
            System.out.println(S[j]-S[i-1]);
        }
    }
}
