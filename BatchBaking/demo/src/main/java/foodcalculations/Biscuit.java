package foodcalculations;

public class Biscuit {

    public static CalculationResult calculateBiscuit(double flour) {

        double fat;
        double liquid;
        CalculationResult result = new CalculationResult();


        fat = (1 * flour) / 3;
        liquid = (2 * flour) / 3;

        result.fat = fat;
        result.liquid = liquid;

        return result;
    }
}

