package foodcalculations;

public class Cookie {

    public static CalculationResult calculateCookie(double flour){

        double fat;
        double sugar;
        CalculationResult result = new CalculationResult();

        fat = (2 * flour) / 3;
        sugar = (1 * flour) / 3;

        result.fat = fat;
        result.sugar = sugar;

        return result;
    }
}
