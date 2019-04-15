package com.mathefuchs.model;

import java.util.Random;
import java.util.function.Predicate;

public class Animal {

    private final Point exhibitSize;
    private Random random;
    private Predicate<Point> checkWhetherPlaceEmpty;
    private Point position;
    private AnimalState animalState;
    private int remainingTimeInState;

    public Animal(Random random, Point exhibitSize, Predicate<Point> checkWhetherPlaceEmpty) {
        this.random = random;
        this.checkWhetherPlaceEmpty = checkWhetherPlaceEmpty;

        this.exhibitSize = exhibitSize;

        this.animalState = AnimalState.randomState(random);
        this.remainingTimeInState = this.animalState.getInitialTimeStepsInState();

        do {
            position = Point.randomPointInRect(random, exhibitSize);
        }
        while (!checkWhetherPlaceEmpty.test(position));
    }

    public Point getPosition() {
        return position;
    }

    public AnimalState getAnimalState() {
        return animalState;
    }

    public void performTimeStep() {
        position.applyTranslationIfPlaceEmpty(animalState.getTransformationOfMovingAnimal(random),
                exhibitSize, checkWhetherPlaceEmpty);

        if (--remainingTimeInState <= 0) {
            animalState = animalState.getRandomNextState(random);
            this.remainingTimeInState = animalState.getRandomTimeStepsInState(random);
        }
    }
}
