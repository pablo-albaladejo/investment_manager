package investmentmanager.asset

class Company {
    static belongsTo = Asset
    
    String name
    String symbol
    String marketcap
    String state
    String zipcode
    
    static constraints = {
    }
}
