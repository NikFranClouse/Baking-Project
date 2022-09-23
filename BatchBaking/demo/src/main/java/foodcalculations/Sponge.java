package foodcalculations;

public class Sponge {

    public static CalculationResult calculateSponge(double flour) {

        double egg;
        double sugar;
        CalculationResult result = new CalculationResult();

        egg = (1 * flour) / 1;
        sugar = (1 * flour) / 1;

        result.egg =egg;
        result.sugar = sugar;

        return result;

    }
}
