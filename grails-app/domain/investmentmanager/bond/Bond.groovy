package investmentmanager.bond

class Bond {
    static belongsTo = TreasuryBonds
   
    Integer days
    Float interest
    
    static constraints = {
    }
}
