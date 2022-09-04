package Helpers;

import Entities.Animal;
import Interfaces.IAnimalFunc;
import Interfaces.IAnonymous;
import Interfaces.IManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Manager implements IManager {

    private ArrayList<Animal> list;

    public ArrayList<Animal> getList() {
        return list;
    }

    public void setList(ArrayList<Animal> list) {
        this.list = list;
    }

    public Manager(ArrayList<Animal> list) {
        this.list = list;
    }

    @Override
    public Collection<Animal> searchAnimalByDaysWithoutFood(long days) {
        var result = new ArrayList<Animal>();
        for (var item : this.list) {
            if (item.getDaysWithoutFood() == days) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<Animal> searchAnimalByDanger(double danger) {
        var result = new ArrayList<Animal>();
        for (var item : this.list) {
            if (item.getDanger() == danger) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void sort(boolean order) {
        for (int i = 0; i < this.list.size(); i++) {
            for (int j = 0; j < this.list.size() - i - 1; j++) {
                if (this.list.get(j).getLifeLength() > this.list.get(j + 1).getLifeLength() && order) {
                    var tmp = this.list.get(j);
                    this.list.set(j, this.list.get(j + 1));
                    this.list.set(j + 1, tmp);
                }
            }
        }
    }

    @Override
    public void sort(Comparator<Animal> comparator) {
        this.list.sort(comparator);
    }

    @Override
    public void sortByAnonymousExp(IAnonymous anonymousClass) {
        this.list.sort(anonymousClass::compare);
    }

    @Override
    public void sortByLambda(IAnimalFunc exp) {
        this.list.sort(exp::operation);
    }

    public class LifeLengthComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal a, Animal b) {
            return Long.compare(a.getLifeLength(), b.getLifeLength());
        }
    }

    public class NameComparator implements Comparator<Animal> {
        @Override
        public int compare(Animal a, Animal b) {
            return a.getAnimalName().compareToIgnoreCase(b.getAnimalName());
        }
    }

}