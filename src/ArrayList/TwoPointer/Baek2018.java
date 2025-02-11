package ArrayList.TwoPointer;

import java.util.Scanner;

public class Baek2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N 자체를 하나의 연속된 합으로 포함하므로 초기 count를 1로 설정
        int count = 1;
        // 연속 부분합의 시작 인덱스 (자연수 시작은 1)
        int start_index = 1;
        // 연속 부분합의 끝 인덱스
        int end_index = 1;
        // 현재 연속 부분합의 값, 처음에는 1부터 시작하므로 1
        int sum = 1;

        // end_index가 N에 도달할 때까지 반복 (N 이상의 숫자를 포함하면 더 이상 연속 합을 구할 수 없으므로)
              while (end_index != N) {
                  if (sum == N) {
                      // 현재 연속 부분합이 목표 N과 같다면, 하나의 경우의 수 발견
                      count++;
                      // 새로운 연속합을 찾기 위해 end_index를 한 칸 증가시키고, 그 값을 합에 더함
                      end_index++;
                      sum = sum + end_index;
                  } else if (sum > N) {
                      // 현재 연속 부분합이 목표 N보다 크면,
                      // 합에서 start_index 위치의 값을 빼서 합을 줄이고, 시작 인덱스를 한 칸 증가시킴
                      sum = sum - start_index;
                      start_index++;
                  } else {
                      // 현재 연속 부분합이 목표 N보다 작으면,
                      // 연속 범위를 넓히기 위해 end_index를 한 칸 증가시키고, 그 값을 합에 더함
                      end_index++;
                      sum = sum + end_index;
                  }
              }
              System.out.println(count);
          }
      }
