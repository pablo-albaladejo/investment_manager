package investmentmanager.report

import investmentmanager.asset.Asset
import investmentmanager.forecast.Forecast

class OverallReport {
    static hasMany = [assets : Asset, forecasts : Forecast]
    
    Summary summary
}
