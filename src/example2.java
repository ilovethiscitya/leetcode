import java.util.Scanner;

/**
 * Created by jianzhe on 2018/4/10.
 */
public class example2 {
    public static int jumpGame(int[] nums){
        int len = nums.length;
        int[] f = new int[len];
        for(int i = 0; i < len; i++) {
            f[i] = -1;
        }
        f[0] = 0;
        for(int i = 0; i < len; i++) {
            if(f[i] != -1) {
                for(int j = 1; j <= nums[i]; j++) {
                    if(i + j < len && (f[i + j] == - 1 || f[i + j] > f[i] + 1)){
                        f[i + j] = f[i] + 1;
                    }
                }
            }
        }
           return f[len - 1];
    }
    public static void main() {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(nums.toString());
    }


}
