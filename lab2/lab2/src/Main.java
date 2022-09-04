import Entities.Animal;
import Entities.Mammal;
import Entities.Reptile;
import Entities.Rodent;
import Helpers.Manager;
import Interfaces.IAnonymous;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> lst = new ArrayList<>();
        lst.add(new Mammal("Wolf", 10, 6, 30));
        lst.add(new Mammal("Tiger", 15, 7, 25));
        lst.add(new Rodent("Hamster", 3, 8, 10));
        lst.add(new Rodent("Beaver", 4, 9, 22));
        lst.add(new Reptile("Lizard", 2, 10, 10));
        lst.add(new Reptile("Snake", 12, 2, 15));
        lst.add(new Mammal("Monkey", 5, 3, 20));
        lst.add(new Reptile("Croco", 14, 4, 30));

        var mngr = new Manager(lst);
        System.out.println(mngr.getList());
        mngr.sort(false);
        System.out.println(mngr.searchAnimalByDanger(5));
        System.out.println(mngr.searchAnimalByDaysWithoutFood(2));
//        mngr.sort(mngr.new LifeLengthComparator());
//        mngr.sortByLambda((a, b) -> Long.compare(b.getLifeLength(), a.getLifeLength()));
//        mngr.sortByAnonymousExp(new IAnonymous() {
//            @Override
//            public int compare(Animal a, Animal b) {
//                return (int) (a.getLifeLength() - b.getLifeLength());
//            }
//        });
        System.out.println(mngr.getList());


    }
}