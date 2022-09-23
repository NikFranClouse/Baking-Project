package foodcalculations;

public class Fritter {

    public static CalculationResult calculateFritter(double flour){

        double liquid;
        double egg;
        CalculationResult result = new CalculationResult();

        liquid = (2 * flour) / 2;
        egg = (1 * flour) / 2;

        result.liquid = liquid;
        result.egg = egg;

        return result;
    }
}
