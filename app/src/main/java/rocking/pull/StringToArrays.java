package rocking.pull;

/**
 * Created by Rocking on 2016/9/28.
 */
// 创建一个工具类，可以将 字符串 按照其 特定分隔符 生成字符串数组
public class StringToArrays {

    static String[] arrayStr;

    // 既然是打算通用，那么就传入两个参数，第一个是字符串数据，第二个是 分隔符, 并且别人调用的话，我得返回一个解析了的字符串数组回去
    public static String[] staMethod(String str, String separator) {

        arrayStr = str.split(separator); // 拆分字符为separator ,然后把结果交给数组 array
        return arrayStr;
    }
}
