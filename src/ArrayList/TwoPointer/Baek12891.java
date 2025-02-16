package ArrayList.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12891 {
    static int myArr[];   // 현재 부분 문자열에서 각 문자(A, C, G, T)의 개수를 저장하는 배열
    static int checkArr[]; // 필요한 최소 문자 개수를 저장하는 배열
    static int checkSecret; // 조건을 만족하는 문자의 개수를 체크하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // S: 전체 DNA 문자열 길이, P: 부분 문자열 길이
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0; // 조건을 만족하는 경우의 수

        checkArr = new int[4]; // 'A', 'C', 'G', 'T' 최소 개수
        myArr = new int[4]; // 현재 부분 문자열에서 'A', 'C', 'G', 'T' 개수
        char A[] = new char[S]; // 전체 DNA 문자열 저장 배열
        checkSecret = 0; // 조건을 만족하는 문자 개수 (4가 되면 조건 만족)

        // DNA 문자열 입력
        A = br.readLine().toCharArray();

        // 필요한 최소 개수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++; // 필요 개수가 0인 경우, 이미 조건을 만족한 것으로 간주
            }
        }

        // 초기 P 길이의 부분 문자열 세팅
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4) Result++; // 모든 조건을 만족하는 경우 증가

        // 슬라이딩 윈도우 방식으로 이동하면서 검사
        for (int i = P; i < S; i++) {
            int j = i - P; // 이전에 포함된 문자 위치
            Add(A[i]);  // 새로 추가된 문자 반영
            Remove(A[j]); // 이전 문자 제거
            if (checkSecret == 4) Result++; // 모든 조건을 만족하면 결과 증가
        }
        System.out.println(Result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--; // 조건을 만족했던 경우 감소
                myArr[0]--;
                break;

            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;

            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;

            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }


    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++; // 조건을 처음 만족한 경우 증가
                break;

            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;

            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;

            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
