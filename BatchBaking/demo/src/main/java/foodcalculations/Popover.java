package foodcalculations;

public class Popover {

    public static CalculationResult calculatePopover(Double flour) {

        double liquid;
        double egg;
        CalculationResult result = new CalculationResult();

        liquid = (2 * flour) / 1;
        egg = (1 * flour) / 1;

        result.liquid = liquid;
        result.egg = egg;

        return result;

    }
}
