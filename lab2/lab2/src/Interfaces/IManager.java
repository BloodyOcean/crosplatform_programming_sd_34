package Interfaces;

import Entities.Animal;

import java.util.ArrayList;
import java.util.Comparator;

interface IManager {
    ArrayList<Animal> searchAnimalByDaysWithoutFood();
    ArrayList<Animal> searchAnimalByDanger();
    void sort(ArrayList<Animal> animals, boolean order);
    void sort(ArrayList<Animal> animals, Comparator<Animal> comparator);
    void sortByAnonymousExp(ArrayList<Animal> animals);
    void sortByLambda(ArrayList<Animal> animals, AnimalFunc exp);
}