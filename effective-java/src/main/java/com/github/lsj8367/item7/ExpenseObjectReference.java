package com.github.lsj8367.item7;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class ExpenseObjectReference<ExpensiveObject> extends PhantomReference<ExpensiveObject> {

    public ExpenseObjectReference(final ExpensiveObject referent, final ReferenceQueue<? super ExpensiveObject> q) {
        super(referent, q);
    }

    public void cleanUp() {
        System.out.println("clean up");
    }

}
