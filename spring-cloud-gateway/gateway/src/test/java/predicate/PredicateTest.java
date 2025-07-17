package predicate;

import org.junit.Test;

import java.util.function.Predicate;

public class PredicateTest {
    @Test
    public void test() {
        Predicate<String> predicate = new StringPredicate();
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("aaa"));
    }
}
