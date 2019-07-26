package org.test;

import java.util.HashSet;

public class Uber {

    // fucntion that returns the count of
    // subarrays with m odd numbers
    static int countSubarrays(int a[],
                              int n, int m)
    {

        StringBuilder sb = new StringBuilder();
        HashSet<String> subArray = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++)
        {   sb.append(a[i]);
            int odd = 0;
            for (int j = i; j < n; j++)
            {
                if (a[j] % 2 == 1)
                    odd++;

                if (odd <= m){
                    sb.append(a[j]);
                    subArray.add(sb.toString());
                }
            }
            sb = new StringBuilder();
        }

        return subArray.size();
    }

    // Driver code
    public static void main (String[] args)
    {
        int a[] = { 6, 3, 5, 8 };
        int n = a.length;
        int m = 1;

        System.out.println(countSubarrays(a, n, m));
    }
}
