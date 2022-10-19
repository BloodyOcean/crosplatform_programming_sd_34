import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IManager fm = new FirstManager();
        IManager sm = new SecondManager();

        var flag = 1;

        Scanner sc = new Scanner(System.in);

        while (flag == 1)
        {
            System.out.println("Resume? 1/0");

            flag = sc.nextInt();

            if (flag == 1) {

                System.out.println("""
                        1. read 1st file manager
                        2. Read second manager file
                        3. Add new film
                        4. Remove by key 1st manager
                        5. Remove by key 2nd manager
                        6. Print manager""");

                var num = sc.nextInt();

                switch (num){
                    case 1: {
                        System.out.println("Enter path:");
                        var p = sc.nextLine();
                        p = sc.nextLine();
                        fm.readFromFile(p);
                        break;
                    }

                    case 2: {
                        System.out.println("Enter path:");
                        var p = sc.nextLine();
                        p = sc.nextLine();
                        sm.readFromFile(p);
                        break;
                    }

                    case 3: {
                        System.out.println("Enter number of manager:");
                        var p = sc.nextInt();
                        System.out.println("Enter Title, year, director and producers:");
                        var title = sc.nextLine();
                        title = sc.nextLine();
                        var year = sc.nextInt();
                        var dir = sc.nextLine();
                        dir = sc.nextLine();
                        var producers = Arrays.stream(sc.nextLine().split(" ")).toList();
                        var f = new Film(title, year, dir, producers);
                        if (p == 1) {
                            fm.addFilm(f);
                        } else {
                            sm.addFilm(f);
                        }

                        break;
                    }
                    case 4: {
                        System.out.println("Enter key:");
                        var k = sc.nextLine();
                        k = sc.nextLine();
                        fm.remove(k); break;
                    }
                    case 5: {
                        System.out.println("Enter key:");
                        var k = sc.nextInt();
                        k = sc.nextInt();
                        sm.remove(k);
                        break;
                    }
                    case 6: {  fm.print(); sm.print(); break;}
                    default: break;


                }
            }



        }
    }
}
