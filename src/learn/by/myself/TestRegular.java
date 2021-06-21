package learn.by.myself;

import java.util.regex.Pattern;


public class TestRegular {
    public static void main(String[] args){
        /**任意文件下载*/
        /*String content = "../1.txt";
        String pattern = ".*\\.\\..*";
        String a = content.replaceAll("\\.\\.","");
        System.out.println(a);
        boolean isMatch = Pattern.matches(pattern, content);
        boolean isMatch2 = Pattern.matches(pattern, a);
        System.out.println("字符串content中是否包含了 '..' 子字符串? " + isMatch);
        System.out.println("字符串a中是否包含了 '..' 子字符串? " + isMatch2);*/

        /** SQL注入*/
        /*String sqlin = "sasa..dag*gda;ndsssggjj'|*|%|;|-|+|,|(|)|[|]|<|>|.|:|\"|#|%|_|=|/|@";
//        boolean a = sql_inj(sqlin);
//        System.out.println("字符串a中是否包含了异常字符:"+a);

        //安全漏洞整改，SQL注入
        String inj_str = "drop|having|by|order|where|from|regxp|like|and|exec|insert|select|delete|update|count|chr|mid|master|truncate|char|declare";
        String inj_str2 = "'|*|%|;|-|+|,|(|)|[|]|<|>|.|:|\"|#|%|_|=|/|@";
        String inj_stra[] = inj_str.split("\\|");
        String inj_stra2[] = inj_str2.split("\\|");
        for (int i=0 ; i  <inj_stra.length ; i++ ){
            if (sqlin.indexOf(inj_stra[i])>=0){
                sqlin = sqlin.replaceAll(inj_stra[i],"0");
            }
        }
        for (int i=0 ; i  <inj_stra2.length ; i++ ){
            if (sqlin.indexOf(inj_stra2[i])>=0){
                System.out.println("\\"+inj_stra2[i]);
                sqlin = sqlin.replaceAll("\\"+inj_stra2[i],"0");
            }
        }
        System.out.println(sqlin);
*/

//        “|”、“&”、“;”、“$”、“%”、“@”、“'”、“"”、“\'”、“\"”、“<>”、“()”、“+”、“CR”（回车符，ASCII 0x0d）、“LF”（换行，ASCII 0x0a）、“,”、“\”。
        /** 反射性XSS漏洞*/
        String xss = "|&|;|$|%|@|'|\"|\\'|\\\"|<>|()|+|\n|,|\\ssmalkmdakmm";
        String filter = "| & ; $ % @ ' \" + , \\ < > ( ) \n";
        String filters[] = filter.split(" ");
        for (int i=0 ; i  <filters.length ; i++ ){
            if (xss.indexOf(filters[i])>=0){
                System.out.println("\\"+filters[i]);
                xss = xss.replaceAll("\\"+filters[i],"");
            }
        }
        System.out.println(xss);


    }

    public static boolean sql_inj(String str){

        //select and or like regxp from where update exec order by having drop delete ( ) [ ] < > , . ; : ' " # % + - _ = / * @

        String inj_str = "drop|having|by|order|where|from|regxp|like|'|and|exec|insert|select|" +
                "delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,|(|)|[|]|<|>|.|:|\"|#|%|_|=|/|@";
        String inj_stra[] = inj_str.split("\\|");

        for (int i=0 ; i  <inj_stra.length ; i++ ){
            System.out.println("第"+i+"个异常字符为:"+inj_stra[i]);
            if (str.indexOf(inj_stra[i])>=0){
                return true;
            }
        }
        return false;
    }
}
