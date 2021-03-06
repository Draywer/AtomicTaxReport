package ru.idcore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaxService taxService = new TaxService();
        Shop shop1 = new Shop(taxService, 10);
        Shop shop2 = new Shop(taxService, 10);
        Shop shop3 = new Shop(taxService, 10);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.submit(shop1);
        service.submit(shop2);
        service.submit(shop3);
        service.awaitTermination(3, TimeUnit.SECONDS);

        System.out.println("Общая выручка: " + taxService.getAdder().sum());

        service.shutdown();

    }
}
