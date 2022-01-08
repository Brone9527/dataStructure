package reflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/8/11 8:56
 */
 
public class BirthdayUtil {

    public String test(String date){
        return "happy test"
                + date;
    }

    public static void main(String[] args) throws Exception{
        //获取字节码对象
        Class<BirthdayUtil> calzz = (Class<BirthdayUtil>)Class.forName("reflectTest.BirthdayUtil");
        //获取一个对象
        Constructor con = calzz.getConstructor();
        BirthdayUtil bu = (BirthdayUtil) con.newInstance();
        //String[] s = new String[]{"aaaa" , "bbbb"};
        String s = "aaaa";
        String outPut = null;

        Method method = calzz.getMethod("test", String.class);
        //调用invoke方法来调用
        String output = (String)method.invoke(bu,s);
        System.out.println(output);

    }


}
