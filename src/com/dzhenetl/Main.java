package com.dzhenetl;

import java.util.Queue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Atc atc = new Atc(60);
        new Thread(atc).start();

        // Подождем пока очередь заполнится минимальным количеством звонков
        Thread.sleep(4000);


        Queue<Call> callQueue = atc.getCalls();
        for (int i = 1; i <= 3; i++) {
            Employee employee = new Employee(callQueue);
            new Thread(employee, "Специалист " + i).start();
        }
    }
}
