package others;

/**
 * @Author zeroback13
 * @Date 2022/2/26 12:20
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        int[] freq = new int[256];  //数组初始化默认为 0
        System.out.println(freq[0]);

        String s = "String";
        for(int i = 0;i < s.length();i++){
            System.out.println((int)s.charAt(i));
        }

    }
}
