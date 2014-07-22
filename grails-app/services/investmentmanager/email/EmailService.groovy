package investmentmanager.email

import grails.transaction.Transactional
import investmentmanager.mailing.Email

@Transactional
class EmailService {   
    
    def mailService 
    def reportService
    
    def add(email) {
        email.save()
    }
    
    def list(){
        return Email.getAll()
    }
    
    def getRecipients(){
        return Email.getAll().collect{it.address}
    }
    
    def sendDailyReport(){
        def txt = reportService.getDailyReport()
        List recipients = getRecipients()
        if(recipients){
            mailService.sendMail {
                bcc recipients.toArray()
                subject "Daily Report"
                body txt
            }
        }
    }
}
