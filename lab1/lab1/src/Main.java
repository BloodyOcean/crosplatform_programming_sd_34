import java.util.ArrayList;
import java.util.Scanner;

class Fraction {
    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator;
    }

    private long numerator;
    private long denominator;

    public Fraction(long num, long den) {
        this.numerator = num;
        this.denominator = den;
    }

    public long getNumerator() { return this.numerator; }
    public void setNumerator(long num) { this.numerator = num; }
    public long getDenominator() { return denominator; }
    public void setDenominator(long den) { this.denominator = den; }
}

class MathHelper {

    public static long getCommonDenominator(ArrayList<Fraction> list) {
        long res = 1;
        for (var item : list) {
            res = item.getDenominator() * res / getGreatestCommonDivisor(res, item.getDenominator());
        }
        return res;
    }
    public static long getGreatestCommonDivisor(long n1, long n2) {
        if (n2 == 0) {
            return n1;
        }

        return getGreatestCommonDivisor(n2, n1 % n2);
    }
}


class CalcSeries {
    public Fraction calculate(ArrayList<Fraction> list) {
        long commonNumerator = 0;
        var commonDenominator = MathHelper.getCommonDenominator(list);

        for (var item : list) {
            commonNumerator += commonDenominator / item.getDenominator();
        }

        var gcd = MathHelper.getGreatestCommonDivisor(commonNumerator, commonDenominator);
        commonNumerator /= gcd;
        commonDenominator /= gcd;

        return new Fraction(commonNumerator, commonDenominator);

    }

}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        long n = scanner.nextInt();
        ArrayList<Fraction> fractions = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            fractions.add(new Fraction(1, i));

        scanner.close();
        var calculator = new CalcSeries();
        var res = calculator.calculate(fractions);
        System.out.println(res);
    }
}
