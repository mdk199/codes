package org.test;

import java.util.HashMap;

public class SubArrayKSum {

  static int[] a = new int[]{10, 2, -2, -20, 10};


  public static void main(String[] args) {
    // -10;

    /**
     * 10, 2, -2, 20, 10
     * 10 12 10, 30, 40
     * -10, -8, -10, 10, 20
     *
     */
    int[] arr = new int[]{10, 2, -2, 20, 10};
    System.out.println(countSubarray(arr, 20));
  }

  private static int countSubarray(int[] nums, int k) {

    int count = 0, sum = 0;
    HashMap < Integer, Integer > map = new HashMap< >();
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k))
        count += map.get(sum - k);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
    /*int count = 0, i = 0, currSum = 0;
    int j = 0;
    while (i < a.length && j < a.length) {
      currSum = currSum + a[i++];
      while (currSum > k && j < i - 1) {
        currSum = currSum - a[j++];
      }
      if (currSum == k) {
        count++;
        currSum = currSum - a[j++];
      }
    }
    return count;*/
  }
}
