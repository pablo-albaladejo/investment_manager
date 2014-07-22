package investmentmanager.forecast

class Investment {
    static belongsTo = Forecast
    
    Integer ranking
    
    Float principal
    Float rate
    Integer days
    Float interest
    
    static constraints = {
    }
}
