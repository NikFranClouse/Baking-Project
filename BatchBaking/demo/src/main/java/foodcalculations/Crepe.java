package foodcalculations;

public class Crepe {


    public static CalculationResult calculateCrepe(double flour) {

        double liquid;
        double egg;
        CalculationResult result = new CalculationResult();

        liquid = (1 * flour) / 0.5;
        egg = (1 * flour) / 0.5;

        result.liquid = liquid;
        result.egg = egg;

        return result;
    }
}
