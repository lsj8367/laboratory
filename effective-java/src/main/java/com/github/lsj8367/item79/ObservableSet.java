package com.github.lsj8367.item79;

import com.github.lsj8367.item18.ForwardingSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(final Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    public void addObserver(final SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public void removeObserver(final SetObserver<E> observer) {
        synchronized (observers) {
            observers.remove(observer);
        }
    }

    private void notifyElementAdded(final E element) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);
            }
        }
    }

    @Override
    public boolean add(final E e) {
        boolean isAdded = super.add(e);
        if (isAdded) {
            notifyElementAdded(e);
        }
        return isAdded;
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element);
        }
        return result;
    }

}
