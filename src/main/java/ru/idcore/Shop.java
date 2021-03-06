package ru.idcore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop extends Thread {
    private List<Integer> bills;
    private int maxValue;
    private TaxService taxService;

    public Shop(TaxService taxService, int maxValue) {
        bills = new ArrayList<>();
        this.maxValue = maxValue;
        this.taxService = taxService;
        fillListBill();
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public List<Integer> getBills() {
        return bills;
    }

    public void setBills(List<Integer> bills) {
        this.bills = bills;
    }

    public void fillListBill() {
        for (int i = 0; i < maxValue; i++) {
            bills.add((int) (Math.random() * ((maxValue + 1))));
        }
        System.out.println(bills);
    }

    @Override
    public void run() {
        for (Integer integer : bills
        ) {
            taxService.getAdder().add(integer);
        }
    }
}
