package foodcalculations;

public class Pancake {

    public static CalculationResult calculatePancake(double flour){

        double fat;
        double liquid;
        double egg;
        CalculationResult result = new CalculationResult();

        fat = (0.5 * flour) / 2;
        liquid = (2 * flour) / 2;
        egg = (1 * flour) / 2;

        result.fat = fat;
        result.liquid = liquid;
        result.egg = egg;

        return result;
    }
}
