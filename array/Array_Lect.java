class Array_lect {
    /**
     * 
     * @param args
     * Array(배열)
     * 같은 종류의 데이터를 효율적으로 관리하기 위해 사용. -> 순차적으로 저장.
     * 인덱스 번호를 통한 빠른 접근 가능.
     * 
     */
    public static void main(String[] args){
        Integer[][][] data=  {
            {
                {1,2,3},
                {4,5,6}
            },{
                {7,8,9},
                {10,11,12}
            }
        };

        System.out.println(data[1][0][1]);
        System.out.println(data[1][1][0]);
        System.out.println(data[0][0][1]);
    }
}