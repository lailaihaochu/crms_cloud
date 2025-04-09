package com.crms.cloud;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {
        Test2 test2=new Test2();
        System.out.println(test2.solution(new int[]{-1,3}));
    }

    //1, 3, 6, 4, 1, 2
    public int solution(int[] A) {
        Arrays.sort(A);
        int maxv = A[A.length - 1];
        if (maxv <= 0) {
            return 1;
        } else {
            for (int i = 1; i < (maxv + 1); i++)
                if (!check(A, i)){
                    return i;
                }
        }
        return maxv + 1;

    }

    boolean check(int[] A, int b) {
        for (int i = 0; i < A.length; i++) {
            if (b == A[i]){
                return true;
            }
        }
        return false;
    }
}
