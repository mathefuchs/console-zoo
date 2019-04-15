package com.mathefuchs.model;

import java.util.Random;

public enum AnimalState {
    Hike(4, "H") {
        @Override
        public AnimalState getRandomNextState(Random random) {
            AnimalState nextState;

            if (random.nextInt(2) == 0) {
                nextState = AnimalState.Sleep;
            } else {
                nextState = AnimalState.Eat;
            }

            return nextState;
        }

        @Override
        public int getRandomTimeStepsInState(Random random) {
            return random.nextInt(3) + 4;
        }

        @Override
        public Point getTransformationOfMovingAnimal(Random random) {
            return Direction.randomDirection(random).getTransformation();
        }
    },
    Sleep(10, "S") {
        @Override
        public AnimalState getRandomNextState(Random random) {
            return AnimalState.Hike;
        }

        @Override
        public int getRandomTimeStepsInState(Random random) {
            return random.nextInt(6) + 5;
        }
    },
    Eat(6, "E") {
        @Override
        public AnimalState getRandomNextState(Random random) {
            return AnimalState.Hike;
        }

        @Override
        public int getRandomTimeStepsInState(Random random) {
            return random.nextInt(3) + 2;
        }
    };

    private int initialTimeStepsInState;
    private String abbreviation;

    AnimalState(int timeStepsInState, String abbreviation) {
        this.initialTimeStepsInState = timeStepsInState;
        this.abbreviation = abbreviation;
    }

    public static AnimalState randomState(Random random) {
        return AnimalState.values()[random.nextInt(AnimalState.values().length)];
    }

    public abstract AnimalState getRandomNextState(Random random);

    public abstract int getRandomTimeStepsInState(Random random);

    public Point getTransformationOfMovingAnimal(Random random) {
        return Point.ZERO;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getInitialTimeStepsInState() {
        return initialTimeStepsInState;
    }

    @Override
    public String toString() {
        return getAbbreviation();
    }
}
