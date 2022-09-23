package foodcalculations;

public class Muffin {

    public static CalculationResult calculateMuffin(double flour) {

        double fat;
        double liquid;
        double egg;
        CalculationResult result = new CalculationResult();

        fat = (1 * flour) / 2;
        liquid = (2 * flour) / 2;
        egg = (1 * flour) / 2;

        result.fat = fat;
        result.liquid = liquid;
        result.egg = egg;

        return result;

    }
}
