package org.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MarkingOneToZeroCost {

  public static void cost(int[] a, int k) {
    Set<Integer> oneIndexes = new TreeSet<>();
    int operation = 0;
    int tCost = 0, cost = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == 1) {
        oneIndexes.add(i);
      }
    }

    while (!oneIndexes.isEmpty()) {
      Iterator itr = oneIndexes.iterator();
      cost = 0;
      int x = (int) itr.next();
      oneIndexes.remove(x);
      a[x] = 0;
      while (x + k < a.length) {
        if (a[x + k] == 1) {
          a[x + k] = 0;
          oneIndexes.remove(x + k);
        } else {
          a[x + k] = 1;
          oneIndexes.add(x + k);
          cost++;

        }
        x += k;
      }

      System.out.println(Arrays.toString(a));
      tCost += cost;
      operation++;
    }

    System.out.println("cost : " + tCost + " operations: " + operation);
  }


  public static void main(String[] args) {

    int[] arr = new int[]{1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0};
    cost(arr, 2);

    int[] arr2 = new int[]{1, 0, 0, 1, 1};
    cost(arr2, 1);

    //  10011
    //  01000
    //  00111
    //  00000

  }
}
