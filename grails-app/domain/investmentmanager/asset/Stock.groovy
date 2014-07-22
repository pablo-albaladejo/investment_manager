package investmentmanager.asset

class Stock {
    static belongsTo = Asset

    Float marketprice
    Float pricechange
    Float beta
    Float capm
    
    static constraints = {
    }
}
