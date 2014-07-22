package investmentmanager.bond

class TreasuryBonds {

    static hasMany = [bonds : Bond]
    
    Date date
    
    static constraints = {
    }
}
