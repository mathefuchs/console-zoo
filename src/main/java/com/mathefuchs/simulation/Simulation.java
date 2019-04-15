package com.mathefuchs.simulation;

import com.mathefuchs.model.Zoo;

import java.util.Random;

public class Simulation {

    private static final int numberOfHorizontalCells = 45;
    private static final int numberOfVerticalCells = 30;
    private static final int countOfAnimals = 50;

    private static Random random = new Random();
    private Zoo zoo;

    public Simulation() {
        zoo = new Zoo(random, numberOfHorizontalCells, numberOfVerticalCells);
        zoo.fillWithAnimals(countOfAnimals);
    }

    public void performTimeStep() {
        zoo.performTimeStep();
    }

    @Override
    public String toString() {
        return zoo.toString();
    }
}
