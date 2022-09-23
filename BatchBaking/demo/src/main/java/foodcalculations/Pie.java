package foodcalculations;

public class Pie {

    public static CalculationResult calculatePie(double flour){

        double fat;
        double liquid;
        CalculationResult result = new CalculationResult();

        fat = (2 * flour) / 3;
        liquid = (1 * flour) / 3;

        result.fat = fat;
        result.liquid = liquid;

        return result;

    }
}
