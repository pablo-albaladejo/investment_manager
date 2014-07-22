package investmentmanager.forecast

import investmentmanager.asset.Asset

class Forecast {
    static hasMany = [investments : Investment]
    
    Integer ranking;
    
    Asset asset    
    static constraints = {
    }
}
