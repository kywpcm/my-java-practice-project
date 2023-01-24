package util;

import org.junit.Assert;
import org.junit.Test;

public class CommonUtil {

    public static int getMinValue(int[] array, int idx) {
        int p;
        if (idx == 0)
            return array[idx]; // (a)

        p = getMinValue(array, idx - 1);

        if (p < array[idx]) // (b)
            return p;
        return array[idx];
    }

    public static int getMaxValue(int[] array, int idx) {
        int p;
        if (idx == 0)
            return array[idx]; // (a)

        p = getMaxValue(array, idx - 1);

        if (p < array[idx]) // (b)
            return array[idx];
        return p;
    }

    @Test
    public void t1() {
        int[] array = {5, 3, 9, 1, 4, 2, 5, 7, 6, 11};
        Assert.assertEquals(1, getMinValue(array, array.length - 1));
        Assert.assertEquals(11, getMaxValue(array, array.length - 1));
    }

}
