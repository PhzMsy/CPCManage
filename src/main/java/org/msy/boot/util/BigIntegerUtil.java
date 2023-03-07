package org.msy.boot.util;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class BigIntegerUtil {

    public static BigInteger listToBit(List<Integer> ids) {
        BigInteger power = new BigInteger("0");
        for(Integer id : ids) {
            power = power.setBit(id);
        };
        return power;
    }

    public Integer toInt(BigInteger bit) {
        return bit != null ? Integer.parseInt(bit.toString()) : 0;
    }

    /*@Test
    public void test1() {
        List<Integer> ids = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        BigInteger bigIds = listToBit(ids);

        System.out.println(bigIds.intValue());

        boolean b = bigIds.testBit(3);
        System.out.println(b);

        b = bigIds.testBit(6);
        System.out.println(b);



    }*/
}



