package ru.luxtington.main.tmp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.luxtington.reflection.base.other.UpCacher;

public class CacheTest {

    private Testable a;
    private int begin;

    @BeforeEach
    void setUp() throws Exception {
        a = UpCacher.cache(new My("ajah", 14)).get(0);
        int begin = a.getOriginalMethodsCalls(); // always 0
    }

    @Test
    @DisplayName("Вызов кэширующего метода дважды")
    public void testCachingMethodCallingTwice() {
        a.getData();
        a.getData();  // при повторном вызове кэшируемого метода возвращаемое значение кэшируется
        Assertions.assertEquals(begin + 1, a.getOriginalMethodsCalls(),
                "Method that cached after repeatable calling don't cached");

    }

    @Test
    @DisplayName("Проверка кэширования нового результата после обновления полей")
    public void testCacheClearAfterUpdatingFields() {
        a.getData();
        a.setData("abc"); // после вызова метода, обновляющего значения, кэш должен сбрасываться
        a.getData();
        Assertions.assertEquals(begin + 2, a.getOriginalMethodsCalls(),
                "Cache of cached methods don't clear after field's updating");

    }

    @Test
    @DisplayName("Вызов некэширующего метода")
    public void testNonCachedMethod() {
        a.summOneAndTwo();  // метод который никак не помечен НЕ должен кэшироваться
        Assertions.assertEquals(begin, a.getOriginalMethodsCalls(),
                "Non cached method is cached");
    }

    @Test
    @DisplayName("Вызов кэширующего метода с одинаковыми параметрами дважды")
    public void testCacheMethodWithSameArgs() {
        a.concatenate("abc", 5);
        a.concatenate("abc", 5); // при вызове с другими аргументами кэш НЕ сбрасывается
        Assertions.assertEquals(begin + 1, a.getOriginalMethodsCalls(),
                "Cached methods with same parameters shouldn't cached");
    }

    @Test
    @DisplayName("Вызов кэширующего метода с разными параметрами дважды")
    public void testCacheMethodWithDifferentArgs() {
        a.concatenate("abc", 5);
        a.concatenate("qwe", 9); // при вызове с другими аргументами кэш сбрасывается
        Assertions.assertEquals(begin + 2, a.getOriginalMethodsCalls(),
                "Methods with different parameters shouldn't cached");
    }

    @Test
    @DisplayName("Вызов кэширующих перегруженных методов дважды")
    public void testTwoCachedOverloadMethods() {
        a.concatenate("abc", 5);
        a.concatenate("qwe", "rty", "123"); // каждый перегруженный метод должен кэшироваться
        Assertions.assertEquals(begin + 2, a.getOriginalMethodsCalls(),
                "Overload methods with different arg's types shouldn't be cached");
    }
}