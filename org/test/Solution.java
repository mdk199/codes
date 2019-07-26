package org.test;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 2, 2};
        System.out.println(solution(input));

        // 1 3 3 4 5 7
        // 0,3,4,1,5,2

        // 1, 3,3, 4,5,7
        /**
         * 1 -> 0
         * 4 -> 1
         * 7 -> 2
         * 3 -> 3,6
         * 5 -> 4
         *
         *
         *
         */

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, ArrayList<Integer>> vtoi = new HashMap<>();
        int[] temp = Arrays.copyOf(A, A.length);
        for (int i = 0; i < A.length; i++) {
            if (vtoi.get(A[i]) == null)
                vtoi.put(A[i], new ArrayList<>());
            vtoi.get(A[i]).add(i);
        }
        Arrays.sort(temp);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == temp[i - 1]) {
                continue;
            } else {
                ArrayList<Integer> m = vtoi.get(temp[i - 1]);
                ArrayList<Integer> n = vtoi.get(temp[i]);
                for(Integer valM : m){
                    int index = Arrays.binarySearch(n.toArray(), valM);
                    int computed = (index * - 1);
                    if(computed > n.size()){
                        computed = computed - 2;
                        if(Math.abs(n.get(computed) -  valM) < min){
                            min = Math.abs(n.get(computed) - valM);
                        }
                    }else {
                        if(computed > 0 && computed < n.size()){
                            if(Math.abs(n.get(computed) -  valM) < min){
                                min = Math.abs(n.get(computed) -  valM);
                            }
                            if(Math.abs(n.get(computed-1) - valM) < min){
                                min = Math.abs(n.get(computed-1) -  valM);
                            }
                        }
                    }
                }
            }
        }
        return min;
    }


}
