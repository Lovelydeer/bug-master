package top.mebeforeyou.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lovel
 * @created 2026/4/1 8:42
 * @description
 */

public class ModifyModCount {
    public static void main(String[] args) {
        // Arrays.asList() 返回的是一个 基于数组的固定大小的 List 视图, 它不支持添加或删除元素, 但支持修改元素. 因此, 你不能直接调用 list.remove() 来删除元素, 否则会抛出 UnsupportedOperationException.
        // new ArrayList<>() 创建了一个新的 ArrayList 实例, 对其做了一次完整拷贝, 该实例是可变的, 支持添加和删除元素.
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        for(String s: list){
            if("A".equals(s)){
                list.remove(s);
            }
        }
    }
}
