package Helpers;

import Entities.Animal;

import java.util.Comparator;

class Manager {

    class LifeLengthComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal a, Animal b) {
            return Long.compare(a.getLifeLength(), b.getLifeLength());
        }
    }

    class NameComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal a, Animal b) {
            return a.getAnimalName().compareToIgnoreCase(b.getAnimalName());
        }
    }

}