package com.dzhenetl;

import java.util.Queue;

public class Employee implements Runnable {

    private final int WORK_TIMEOUT = 3000;
    Queue<Call> callQueue;

    public Employee(Queue<Call> queue) {
        callQueue = queue;
    }

    @Override
    public void run() {
        while (!callQueue.isEmpty()) {
            Call call = callQueue.poll();
            if (call == null) {
                continue;
            }
            System.out.println(Thread.currentThread().getName() + " взял в работу звонок");
            try {
                Thread.sleep(WORK_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
