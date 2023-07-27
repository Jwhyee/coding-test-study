package kim.array;

/**
 * 문제 이름(난이도) : 삼각 달팽이(LV2)
 * 시간 : 11.89ms
 * 메모리: 128MB
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * */
class PRG_68645 {
    public int[] solution(int n) {

        int[][] triangle = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;

        while(true) {
            // 아래로 이동
            while (true) {
                triangle[y][x] = v++;
                if (y + 1 == n || triangle[y + 1][x] != 0) break;
                y += 1;
            }
            if (x + 1 == n || triangle[y][x + 1] != 0) break;
            x += 1;

            // 오른쪽으로 이동
            while (true) {
                triangle[y][x] = v++;
                if (x + 1 == n || triangle[y][x + 1] != 0) break;
                x += 1;
            }
            if (triangle[y - 1][x - 1] != 0) break;
            y -= 1;
            x -= 1;

            // 왼쪽 위로 이동
            while (true) {
                triangle[y][x] = v++;
                if (triangle[y-1][x-1] != 0) break;
                y -= 1;
                x -= 1;
            }
            if (y + 1 == n || triangle[y + 1][x] != 0) break;
            y += 1;
        }

        int[] result = new int[v-1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}