package top.mebeforeyou.list;

import java.util.ArrayList;

/**
 * @author lovel
 * @created 2026/4/13 13:53
 * @description
 */

public class DynamicAllocateArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        // you can't set any index beyond the current size, even if the capacity is large enough
        list.set(2,10);
    }
}
