package investmentmanager

//cronExpression: "s m h D M W Y"
//                 | | | | | | `- Year [optional]
//                 | | | | | `- Day of Week, 1-7 or SUN-SAT, ?
//                 | | | | `- Month, 1-12 or JAN-DEC
//                 | | | `- Day of Month, 1-31, ?
//                 | | `- Hour, 0-23
//                 | `- Minute, 0-59
//                 `- Second, 0-59

//http://docs.oracle.com/cd/E12058_01/doc/doc.1014/e12030/cron_expressions.htm

class DailyReportJob {
    
    def grailsApplication
    def emailService
    
    static triggers = {
        //cron name: 'dailyTrigger', cronExpression: "0 0 0 * * ?" //Fire every day at 00.00 am
        //cron name: 'minutelyTrigger', cronExpression: "0 * * * * ?" //Fire every minute
        cron name: 'hourlyTrigger', cronExpression: "0 0 * * * ?" //Fire every hour
    }
 
    def execute(){ 
        emailService.sendDailyReport()
    }
}
