package com.github.lsj8367.item7;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {

    public static void main(String[] args) throws Exception {
        ExpensiveObject object = new ExpensiveObject();
        ReferenceQueue<ExpensiveObject> q = new ReferenceQueue<>();
        ExpenseObjectReference<ExpensiveObject> phantom = new ExpenseObjectReference<>(object, q);

        object = null;

        System.gc();
        Thread.sleep(5000L);

        System.out.println(phantom.enqueue());

        final Reference<? extends ExpensiveObject> reference = q.poll();
        ExpenseObjectReference e = (ExpenseObjectReference) reference;
        e.cleanUp();
        reference.clear();
    }
}
