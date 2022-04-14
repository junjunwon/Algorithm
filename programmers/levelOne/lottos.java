package programmers.levelOne;

public class lottos {
    /**
     * 순서와 상관없이,
     * 로또번호 배열 : lottos (6, 0-45)
     * 0: 알아볼 수 없는 숫자.
     * 0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않다.
     * 정렬되어 있지 않음.
     *
     * 당첨번호 배열 : win_nums(6, 1-45)
     * 같은 숫자가 2개 이상 담겨있지 않다.
     *     원소들은 정렬되어 있지 ㅇ낳다.
     *
     * 당첨 가능한 최고 순위와 최저 순위를 차례대로 !! 배열에 담아서 return
     *
     * 당첨번호와 동일한 값이 있는지 확인하는 배열
     * 동일하면 1
     * 알아볼 수 없거나 다르면 0
     *
     * 31 10 45 1 6 19
     * 1   0  0 1 0  0
     * 3개
     * for문으로 0의 개수를 줄여나가고,
     * 그거에 대한 switch문으로 case별로 배열에 넣어준다.
     * 0의 개수는 2개
     * -> 2 + 2 = 4개
     *
     */
    public static void main(String[] args) {


        int lottos[] = {44, 1, 0, 0, 31, 25};
        int win_nums[] = {31, 10, 45, 1, 6, 19};
        int result[] = new int[2];
        int result2[] = new int[2];
        int check = 0;
        int countZero = 0;
        for(int i = 0; i<win_nums.length; i++) {
            for(int j = 0; j<lottos.length; j++) {
                if(win_nums[i] == lottos[j]) {
                    check += 1;
                    break;
                }
            }
        }
        for(int i = 0; i<lottos.length; i++) {
            if(lottos[i] == 0 ) {
                countZero +=1;
            }
        }
        result[0] = check+countZero;
        result[1] = check;
        System.out.println(result[0]);
        System.out.print(result[1]);
        for(int i =0 ; i<result.length; i++){
            result2[i] = selectCase(result[i]);
            System.out.println(result2[i]);
        }

    }

    public static int selectCase(int result) {
        switch (result) {
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default : return 6;
        }
    }
}
