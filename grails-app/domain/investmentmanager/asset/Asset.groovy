package investmentmanager.asset

import investmentmanager.report.OverallReport
import investmentmanager.forecast.Forecast

class Asset {
    static belongsTo = [OverallReport ,  Forecast]
    
    Integer ranking;
    Company company
    Stock stock  
    
    static constraints = {
    }
}
