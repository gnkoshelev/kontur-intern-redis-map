package ru.gnkoshelev.kontur.intern.redis.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author Gregory Koshelev
 */
public class RedisMapTest {
    @Test
    public void baseTests() {
        Map<String, String> map1 = new RedisMap();
        Map<String, String> map2 = new RedisMap();

        map1.put("one", "1");

        map2.put("one", "ONE");
        map2.put("two", "TWO");

        Assert.assertEquals("1", map1.get("one"));
        Assert.assertEquals(1, map1.size());
        Assert.assertEquals(2, map2.size());

        map1.put("one", "first");

        Assert.assertEquals("first", map1.get("one"));
        Assert.assertEquals(1, map1.size());

        Assert.assertTrue(map1.containsKey("one"));
        Assert.assertFalse(map1.containsKey("two"));

        Set<String> keys2 = map2.keySet();
        Assert.assertEquals(2, keys2.size());
        Assert.assertTrue(keys2.contains("one"));
        Assert.assertTrue(keys2.contains("two"));

        Collection<String> values1 = map1.values();
        Assert.assertEquals(1, values1.size());
        Assert.assertTrue(values1.contains("first"));
    }
}
