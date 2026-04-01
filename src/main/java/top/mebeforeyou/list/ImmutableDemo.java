package top.mebeforeyou.list;

import java.util.List;

/**
 * @author lovel
 * @created 2026/4/1 8:45
 * @description
 */

public class ImmutableDemo {
    public static void main(String[] args) {
        // List.of() 返回一个不可变的 List 实例, 该实例不支持添加、删除或修改元素.
        List<String> list = List.of("a", "b", "c");

        System.out.println(list); // 输出: [a, b, c]

        list.remove("b");
        System.out.println(list); // 输出: [a, c]
    }
}
