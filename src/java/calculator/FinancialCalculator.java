package calculator;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class FinancialCalculator {

    public static int daysPerYear = 360;

    private static FinancialCalculator instance;
    
    public static synchronized FinancialCalculator getInstance(){
        if(instance == null) instance =  new FinancialCalculatorImp();
        return instance;
    }
    
    public abstract float getInterest(float principal, float rate, int days);    
    public abstract float getCAPM(float riskFree, float marketReturn, float beta);
}

