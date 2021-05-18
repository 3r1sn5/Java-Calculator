import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CalculatorFormTest
{
    static CalculatorForm calc = new CalculatorForm();
    @Test
    public void testAddSub()

    {
        try {
            calc.testClick("CLEAR");
            calc.testClick("1");
            calc.testClick("+");
            calc.testClick("2");
            calc.testClick("-");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        double result = calc.getResult();
        assertEquals(3, result, 0);
    }

    public static void main(String[] args)
    {
        calc.showWindow();
        Result result = JUnitCore.runClasses(CalculatorForm.class);
        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}