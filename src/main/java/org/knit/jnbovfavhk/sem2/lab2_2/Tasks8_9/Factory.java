package org.knit.jnbovfavhk.sem2.lab2_2.Tasks8_9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

public class Factory {
    // сырье
    private int material;
    // обработанное штамповщиком
    private BlockingQueue<Integer> stampedBlanks;
    // собранное сборщиком
    private BlockingQueue<Integer> uncheckedDetails;
    // проверенное контролем качества
    private BlockingQueue<Integer> warehouse;

    public Factory() {
        material = 10;
        stampedBlanks = new ArrayBlockingQueue<>(3);
        uncheckedDetails = new ArrayBlockingQueue<>(4);
        warehouse = new ArrayBlockingQueue<>(10);
    }

    public synchronized void stampBlank() throws InterruptedException {
        if (material > 0) {
            material -= 1;
            stampedBlanks.put(1);

        } else {
            throw new ArithmeticException("материала больше нет");
        }
    }

    public synchronized void assembleDetail() throws InterruptedException {
        stampedBlanks.take();
        uncheckedDetails.put(1);

    }

    public synchronized void checkDetail() throws InterruptedException {
        uncheckedDetails.take();
        warehouse.put(1);

    }


    public int getMaterial() {
        return material;
    }
}
