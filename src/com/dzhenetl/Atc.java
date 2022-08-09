package com.dzhenetl;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Atc implements Runnable {

    private final int callsCount;
    private final Queue<Call> calls;

    public Atc(int callsCount) {
        this.callsCount = callsCount;
        calls = new LinkedBlockingDeque<>();
    }

    @Override
    public void run() {
        for (int i = 0; i < callsCount; i++) {
            calls.offer(new Call());
            System.out.println("ATC поток добавил один звонок");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Queue<Call> getCalls() {
        return calls;
    }
}
