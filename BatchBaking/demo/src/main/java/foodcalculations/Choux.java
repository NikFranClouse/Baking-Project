package foodcalculations;

public class Choux {


    public static CalculationResult calculateChoux(double flour){

        double fat;
        double liquid;
        double egg;
        CalculationResult result = new CalculationResult();

        fat = (1 * flour) / 1;
        liquid = (2 * flour) / 1;
        egg = (2 * flour) / 1;

        result.fat = fat;
        result.liquid = liquid;
        result.egg = egg;

        return result;

    }
}
