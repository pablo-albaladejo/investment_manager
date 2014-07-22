package investmentmanager.report

class Summary {

    static belongsTo = OverallReport
    
    Date date
    Float marketReturn
    Float riskFree
    
    static constraints = {
    }
}
