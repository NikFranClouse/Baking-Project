package foodcalculations;

public class Bread {

    public static CalculationResult calculateBread(double flour) {

        double liquid;
        CalculationResult result = new CalculationResult();


        liquid = (3 * flour) / 5;

        result.liquid = liquid;

        return result;
    }
}
