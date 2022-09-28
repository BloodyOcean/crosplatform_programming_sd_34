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

        var flag = true;

        Scanner sc = new Scanner(System.in);

        while (flag)
        {
            System.out.println("Resume? true/false");

            flag = sc.nextBoolean();

            if (flag) {

                System.out.println("1. Sort bubble\n2. Sort lambda\n3. Sort anonymous\n4. Search dangerous" +
                        "\n5. Search days without food\n6. Print\n7. Sort by comparator\n");

                var num = sc.nextInt();
                switch (num){
                    case 1: {System.out.println("enter true asc or false desc: "); var ord = sc.nextBoolean(); mngr.sort(ord); break;}
                    case 2: {System.out.println("enter true(desc) or false(asc): "); var ord = sc.nextBoolean(); if(ord) {mngr.sortByLambda((a, b) -> Long.compare(b.getLifeLength(), a.getLifeLength()));} else {mngr.sortByLambda((a, b) -> Long.compare(a.getLifeLength(), b.getLifeLength()));} break;}
                    case 3: {System.out.println("enter true asc or false desc: "); var ord = sc.nextBoolean(); if(ord) {mngr.sortByAnonymousExp(new IAnonymous() {
                        @Override
                        public int compare(Animal a, Animal b) {
                            return (int) (a.getLifeLength() - b.getLifeLength());
                        }
                    });} else {mngr.sortByAnonymousExp(new IAnonymous() {
                        @Override
                        public int compare(Animal a, Animal b) {
                            return (int) (b.getLifeLength() - a.getLifeLength());
                        }
                    });} break;}
                    case 4: {System.out.println("enter Double: "); var n = sc.nextDouble(); System.out.println(mngr.searchAnimalByDanger(n)); break;}
                    case 5: {System.out.println("enter int value"); var n = sc.nextInt(); System.out.println(mngr.searchAnimalByDaysWithoutFood(n)); break;}
                    case 6: {System.out.println(mngr.getList()); break;}
                    case 7: {System.out.println("enter true asc or false desc: "); var b = sc.nextBoolean(); if(b){mngr.sort(mngr.new LifeLengthComparator());} else {mngr.new NameComparator();} break;}
                    default: break;
                }
            }



        }

    }
}