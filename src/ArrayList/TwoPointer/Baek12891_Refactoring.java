package ArrayList.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12891_Refactoring {
    static int[] currentCount = new int[4]; // 현재 부분 문자열의 A, C, G, T 개수
    static int[] requiredCount = new int[4]; // 필요한 최소 A, C, G, T 개수
    static int validCount = 0; // 조건을 만족하는 문자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        int result = 0; // 조건을 만족하는 부분 문자열 개수

        char[] dna = br.readLine().toCharArray(); // DNA 문자열 입력

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            requiredCount[i] = Integer.parseInt(st.nextToken());
            if (requiredCount[i] == 0) validCount++; // 필요 개수가 0이면 자동으로 만족
        }

        // 초기 P 길이의 부분 문자열 설정
        for (int i = 0; i < P; i++) {
            add(dna[i]);
        }
        if (validCount == 4) result++;

        // 슬라이딩 윈도우 방식으로 이동
        for (int i = P; i < S; i++) {
            add(dna[i]);         // 새로 추가된 문자
            remove(dna[i - P]);  // 빠지는 문자
            if (validCount == 4) result++;
        }

        System.out.println(result);
        br.close();
    }


    private static void add(char c) {
        int index = charToIndex(c);
        currentCount[index]++;
        if (currentCount[index] == requiredCount[index]) validCount++;
    }


    private static void remove(char c) {
        int index = charToIndex(c);
        if (currentCount[index] == requiredCount[index]) validCount--;
        currentCount[index]--;
    }

    private static int charToIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: throw new IllegalArgumentException("Invalid DNA character: " + c);
        }
    }
}
