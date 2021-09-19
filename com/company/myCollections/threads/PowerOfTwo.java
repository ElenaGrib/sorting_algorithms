package com.company.myCollections.threads;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PowerOfTwo {
    private AtomicReference<BigInteger> current = new AtomicReference<>(null);

    BigInteger next() {
        BigInteger recent, next;
        do {
            recent = current.get();
            next = (recent == null) ? BigInteger.valueOf(1) : recent.shiftLeft(1);
        } while (!current.compareAndSet(recent, next));
        return next;
    }
}
