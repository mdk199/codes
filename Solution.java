import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k  = scan.nextInt();
        int n = scan.nextInt();
        int count = 0;
        Pattern pattern = Pattern.compile(String.valueOf(k));
        for(int i=k; i<= n; i++){
            Matcher matcher = pattern.matcher(String.valueOf(i));
            while (matcher.find()){
                count++;
            }
        }
        System.out.println(count);
    }
}
