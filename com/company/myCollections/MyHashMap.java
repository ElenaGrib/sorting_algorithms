package com.company.myCollections;

public class MyHashMap<K, V> implements MyCollections {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private MyEntry[] table = new MyEntry[DEFAULT_INITIAL_CAPACITY];

    public class MyEntry<K, V> {
        K key;
        V value;
        MyEntry next;

        MyEntry(K k, V v) {
            key = k;
            value = v;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }


    }

    private int getAdditionalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int getBucketNumber(int hash) {
        return hash & (DEFAULT_INITIAL_CAPACITY - 1);
    }

    public void put(K key, V value) {
        //получаем хеш-код
        int userHash = key.hashCode();
        int hash = getAdditionalHash(userHash);

        //вычисляем номер бакета
        int bucket = getBucketNumber(hash);
        MyEntry existingElement = table[bucket];

        for (; existingElement != null; existingElement = existingElement.next) {

            //для дубликатов, затираем первоначальное значение дубликатом,
            if (existingElement.key.equals(key)) {
                existingElement.value = value;
                return;
            } else {
            }
        }

        //добавляем кей и велью в нужный бакет
        MyEntry entryInOldBucket = new MyEntry(key, value);
        entryInOldBucket.next = table[bucket];
        table[bucket] = entryInOldBucket;
    }

    public MyEntry get(K key) {
        //получаем хеш-код
        int hash = getAdditionalHash(key.hashCode());

        //вычисляем номер бакета
        int bucket = getBucketNumber(hash);
        MyEntry existingElement = table[bucket];

        //если нашли бакет, то проходимся по связному списку, если нет, возвращаем нулл
        while (existingElement != null) {
            if (existingElement.key.equals(key)) {
                return existingElement;
            }
            existingElement = existingElement.next;
        }
        return null;
    }

    public void remove(K key) {
        //получаем хеш-код
        int hash = getAdditionalHash(key.hashCode());

        //вычисляем номер бакета
        int bucket = getBucketNumber(hash);
        MyEntry existingElement = table[bucket];

        //если нашли бакет, то проходимся по связному списку, если нет, возвращаем нулл
        while (existingElement != null) {
            if (existingElement.key.equals(key)) {
                existingElement.key = null;
                existingElement.value = null;
            }
            existingElement = existingElement.next;
        }
    }

    public int size() {
        return this.DEFAULT_INITIAL_CAPACITY;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException();
    }

}
