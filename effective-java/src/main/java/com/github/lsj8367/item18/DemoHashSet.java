package com.github.lsj8367.item18;

import java.util.Collection;
import java.util.HashSet;

public class DemoHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public DemoHashSet() {
    }

    public DemoHashSet(final int initialCapacity, final float loadFactor, final int addCount) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(final E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

}
