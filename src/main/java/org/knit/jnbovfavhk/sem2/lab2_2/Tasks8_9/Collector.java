package org.knit.jnbovfavhk.sem2.lab2_2.Tasks8_9;

import static java.lang.Thread.sleep;

public class Collector extends Worker implements Runnable {


    public Collector(Factory factory) {
        super(factory);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(1000);
                factory.assembleDetail();
                System.out.println("Заготовка " + i + " обработана");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
