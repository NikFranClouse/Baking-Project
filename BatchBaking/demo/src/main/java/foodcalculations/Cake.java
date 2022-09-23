package foodcalculations;

public class Cake {


    public static CalculationResult calculateCake(double flour) {

        double fat;
        double egg;
        double sugar;
        CalculationResult result = new CalculationResult();


        fat = (1 * flour) / 1;
        egg = (1 * flour) / 1;
        sugar = (1 * flour) / 1;

        result.fat = fat;
        result.egg = egg;
        result.sugar = sugar;

        return result;
    }
}
