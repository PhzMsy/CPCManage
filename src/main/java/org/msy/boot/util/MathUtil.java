package org.msy.boot.util;

public class MathUtil {

    /*
    首页：    1     :  0 ~ 5
    上一页  : i - 1 :
    下一页  : i + 1 :  5 ~ 5
    尾页    : 3     :  10 ~ 5
    1 -> 0
    2 -> 5
    3 -> 10
*/
    public static Integer getStart(Integer p) {
        if(p == 1) {
            return 0 ;
        } else {
            return (p - 1) * 10;
        }
    }
}
