package com.tsourdos.tricky_java.memory_leak;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashSet/HashMap where the key used either does not have or has an incorrect equals()/hashCode() solutions.
 *
 * @author s.tsourdos
 */
public class KeylessEntry {

    static class Key {

        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        /**
         * If equals does not exist, each KeylessEntry object will result to un-equal, when compared to
         * a different object.
         */
        @Override
        public boolean equals(Object o) {
            boolean response = false;
            if (o instanceof Key) {
                response = (((Key) o).id).equals(this.id);
            }
            return response;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 17 * hash + Objects.hashCode(4);
            return hash;
        }
    }

    public static void main(String[] args) {
        Map<Key, String> m = new HashMap();
        while (true) {
            for (int i = 0; i < 10000; i++) {
                if (!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                }
            }
        }
    }
}
