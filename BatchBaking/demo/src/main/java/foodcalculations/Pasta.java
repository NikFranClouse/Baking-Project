package foodcalculations;

public class Pasta {

    public static CalculationResult calculatePasta(double flour){

        double egg;
        CalculationResult result = new CalculationResult();

        egg = (2 * flour) / 3;

        result.egg = egg;

        return result;

    }
}
