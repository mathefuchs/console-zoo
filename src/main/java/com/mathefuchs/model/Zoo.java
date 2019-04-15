package com.mathefuchs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zoo {

    private final List<Animal> animals = new ArrayList<>();
    private final Random random;
    private final Point zooSize;
    private final Animal[][] animalsInTable;
    private int countOfAnimals;

    public Zoo(Random random, int numberOfHorizontalCells, int numberOfVerticalCells) {
        this.random = random;
        this.zooSize = new Point(numberOfHorizontalCells, numberOfVerticalCells);
        this.animalsInTable = new Animal[numberOfVerticalCells][numberOfHorizontalCells];
        this.countOfAnimals = 0;
    }

    public void fillWithAnimals(int countOfAnimals) {
        this.countOfAnimals = countOfAnimals;

        for (int i = 0; i < countOfAnimals; i++) {
            Animal animal = new Animal(random, zooSize, this::isCellEmpty);
            animals.add(animal);
            animalsInTable[animal.getPosition().getY()][animal.getPosition().getX()] = animal;
        }
    }

    private boolean isCellEmpty(Point point) {
        return countOfAnimals == 0 || animalsInTable[point.getY()][point.getX()] == null;
    }

    public void performTimeStep() {
        for (Animal animal : animals) {
            animalsInTable[animal.getPosition().getY()][animal.getPosition().getX()] = null;
            animal.performTimeStep();
            animalsInTable[animal.getPosition().getY()][animal.getPosition().getX()] = animal;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < zooSize.getY(); y++) {
            for (int x = 0; x < zooSize.getX(); x++) {
                if (animalsInTable[y][x] != null) {
                    sb.append(animalsInTable[y][x].getAnimalState().toString());
                } else {
                    sb.append(".");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
