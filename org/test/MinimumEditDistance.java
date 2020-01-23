package org.test;

public class MinimumEditDistance {

  static int arr[][];

  public static void main(String[] args) {
    String a = "kitten", b = "sittig";
    arr = new int[a.length() + 1][b.length() + 1];
    System.out.println(minEditDistance(a.toCharArray(), b.toCharArray(), 0, 0));
    System.out.println("hell0");
  }

  public static int minEditDistance(char[] a, char[] b, int i, int j){
      int count;
      if(i == a.length)
        return b.length - j;
      if(j == b.length)
        return a.length - i;
      if(a[i] == b[j]) {
         count = arr[i][j] == 0 ? minEditDistance(a, b, i + 1, j + 1) : arr[i][j];
         arr[i][j] = count;
         return count;
      }
      count  =  arr[i][j] == 0 ? min(minEditDistance(a, b, i+1, j), minEditDistance(a, b, i, j+1), minEditDistance(a, b, i+1, j+1)) + 1 : arr[i][j];
      arr[i][j] = count;
      return  count;
  }

  public static int min(int a, int b, int c){
    return  a < b
        ? (a < c ? a : b < c ? b : c)
        : (b < c ? b : c < a ? c : a);
  }
}
