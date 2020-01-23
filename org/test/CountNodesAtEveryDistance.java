package org.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class CountNodesAtEveryDistance {

  static Queue<Integer> queue = new LinkedList<>();
  static Map<Integer, Set<Integer>> nodeConnection = new HashMap<>();

  public static void main(String[] args) {
    //9,1,4,9,0,4,8,9,0,1
    int[] input = new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1};
    System.out.println(solution(input));
  }


  public static int[] solution(int[] T) {
    int[] res = new int[T.length];
    int capital = -1;
    for (int i = 0; i < T.length; i++) {

      if (Objects.isNull(nodeConnection.get(T[i]))) {
        nodeConnection.put(T[i], new HashSet<Integer>());
      }
      if (T[i] == i) {
        capital = i;
      } else {
        nodeConnection.get(T[i]).add(i);
      }
    }

    int level = 0;
    int count = 0;
    queue.add(capital);
    queue.add(-1);
    while (!queue.isEmpty()) {
      int val = queue.remove();
      if (val == -1) {
        res[level++] = count;
        count = 0;
        if (null != queue.peek() && queue.peek() != -1) {
          queue.add(-1);
        }
      } else {
        if (Objects.nonNull(nodeConnection.get(val))) {
          Iterator<Integer> itr = nodeConnection.get(val).iterator();
          while (itr.hasNext()) {
            queue.add(itr.next());
            count++;
          }
        }

      }
    }

    return res;
  }
}
