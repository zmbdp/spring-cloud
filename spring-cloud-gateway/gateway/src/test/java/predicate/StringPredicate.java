package predicate;

import java.util.function.Predicate;

/**
 * 判断字符串是否为空
 * 空 - true
 * 非空 - false
 */
public class StringPredicate implements Predicate<String> {
    @Override
    public boolean test(String s) {
        // 判断这个字符串是否为空
        return s.isEmpty();
    }
}
