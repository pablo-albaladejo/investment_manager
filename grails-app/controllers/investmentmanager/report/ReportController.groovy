package investmentmanager.report

import grails.converters.JSON

class ReportController {

    def reportService
    
    def ajax(){
        render(template: "content", model: [report:reportService.getOverall()])
    }
    
    def overall() {
        withMobileDevice { 
            redirect(action: "overall_mobile")
       }
    }
    def overall_mobile(){

    }
    
    def json(){
        render reportService.getOverall() as JSON        
    }
}
