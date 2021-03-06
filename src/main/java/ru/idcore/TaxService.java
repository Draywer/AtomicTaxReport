package ru.idcore;

import java.util.concurrent.atomic.LongAdder;

public class TaxService {
    private LongAdder adder;

    public TaxService() {
        adder = new LongAdder();
    }

    public LongAdder getAdder() {
        return adder;
    }

    public void setAdder(LongAdder adder) {
        this.adder = adder;
    }
}
