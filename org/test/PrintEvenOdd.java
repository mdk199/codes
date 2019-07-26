package org.test;

import java.util.concurrent.Semaphore;

public class PrintEvenOdd {

    public static void main(String[] args) {

        //We dont want the even number printed first so the initial permit for this semaphore is 0.
        Semaphore evenSemaphore = new Semaphore(0);
        //We want to print the odd number first so the initial permit for this semaphore is 1.
        Semaphore oddSemaphore = new Semaphore(1);

        PrintOddNumber printOddNumber = new PrintOddNumber(evenSemaphore, oddSemaphore);
        PrintEvenNumber printEvenNumber = new PrintEvenNumber(evenSemaphore, oddSemaphore);

        new Thread(printOddNumber, "Print Odd").start();
        new Thread(printEvenNumber, "Print Even").start();
    }

}

class PrintEvenNumber implements Runnable {

    Semaphore sempahoreEven;
    Semaphore sempahoreOdd;

    public PrintEvenNumber(Semaphore sempahoreEven, Semaphore sempahoreOdd) {
        super();
        this.sempahoreEven = sempahoreEven;
        this.sempahoreOdd = sempahoreOdd;
    }

    @Override
    public void run() {
        for (int i = 2;; i = i + 2) {
            try {
                //This will decrement the permit used by the even semaphore to 0.
                sempahoreEven.acquire();
                System.out.println(i);
                //This will increment the permit used by odd semaphore by 1.
                sempahoreOdd.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class PrintOddNumber implements Runnable {

    Semaphore sempahoreEven;
    Semaphore sempahoreOdd;

    public PrintOddNumber(Semaphore sempahoreEven, Semaphore sempahoreOdd) {
        this.sempahoreEven = sempahoreEven;
        this.sempahoreOdd = sempahoreOdd;
    }

    @Override
    public void run() {
        for (int i = 1;; i = i + 2) {
            try {
                //This will decrement the permit used by the odd semaphore to 0.
                sempahoreOdd.acquire();

                Thread.sleep(1000);
                System.out.println(i);
                //This will increment the permit used by even semaphore by 1.
                sempahoreEven.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}