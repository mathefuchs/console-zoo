package com.mathefuchs;

import com.mathefuchs.simulation.Simulation;

public class Main {

    private static volatile boolean isRunning = true;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> isRunning = false));

        Simulation simulation = new Simulation();

        while (isRunning) {
            System.out.println(simulation.toString());

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }

            simulation.performTimeStep();

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
