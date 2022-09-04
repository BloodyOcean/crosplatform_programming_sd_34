package Interfaces;

import Entities.Animal;

import java.util.Collection;
import java.util.Comparator;

public interface IManager {
    Collection<Animal> searchAnimalByDaysWithoutFood(long days);
    Collection<Animal> searchAnimalByDanger(double danger);
    void sort(boolean order);
    void sort(Comparator<Animal> comparator);
    void sortByAnonymousExp(IAnonymous anonymousClass);
    void sortByLambda(IAnimalFunc exp);
}