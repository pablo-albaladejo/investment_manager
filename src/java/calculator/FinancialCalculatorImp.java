package calculator;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FinancialCalculatorImp extends FinancialCalculator{

    /**
     * Simple Interest
     * @param principal
     * @param rate
     * @param days
     * @return interest
     */
    @Override
    public float getInterest(float principal, float rate, int days){
        Double time = (double)days / (double)daysPerYear;
        return principal * (rate / 100.0f) * time.floatValue();
    }
    
    /**
     * Capital Asset Pricing Model
     * @param riskFree
     * @param marketReturn
     * @param beta
     * @return CAPM
     */
    @Override
    public float getCAPM(float riskFree, float marketReturn, float beta){       
        return riskFree + beta * (marketReturn - riskFree);
    }
}
