package cuc.utils;

import java.util.Random;

public class Utils {

    private static int min = 0;
    private static int max = 50;

    public static int generator(){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
