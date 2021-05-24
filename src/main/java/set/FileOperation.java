package set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author qiwl
 * @version 1.0
 * @description
 * @date 2021/5/15 12:44
 */


//文件相关操作
public class FileOperation {

    //读取文件名称为filename中的内容，并将其中包含的所有词放进words中
    public static boolean readFile(String filename , ArrayList<String> words){
        if (filename == null || words == null){
            System.out.println("filename is null or words is null");
            return false;
        }
        //文件读取
        Scanner scanner;
        try{
            File file = new File(filename);
            if (file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }else
                return false;
        }catch (IOException ioe){
            System.out.println("cannot open "+ filename);
            return false;
        }
        //简单分词，分词方式相对简陋。没有考虑文本的特殊处理，这里只做demo展示用
        if (scanner.hasNextLine()){
            String contents = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents,0);
            for (int i = start + 1; i < contents.length(); ) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))){
                    String word = contents.substring(start,i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents,i );
                    i = 1 + start;
                }else
                    i++;

            }
        }
        return true;
    }

    //寻找字符串中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String contents, int start) {
        for (int i = start ;i< contents.length(); i++ )
            if (Character.isLetter(contents.charAt(i)))
                return i;
        return contents.length();
    }
}
