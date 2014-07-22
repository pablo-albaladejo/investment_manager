package investmentmanager.mailing

class EmailController {

    def grailsApplication
    def emailService  

    //------------------------------- AJAX ------------------------------------
    def ajax(){
        int from = Integer.parseInt(params.length)
        List list = emailService.list()
        if(from < list.size){
            int end = from + Integer.parseInt(grailsApplication.config.grails.data.emails)-1
            if(list.size < from) from = list.size-2
            if(list.size < end) end = list.size-1
            render (template: "rows", model: [list:list.getAt(from..end)])
        }
    }
    //------------------------------ SAVE -------------------------------------
    def save(){
        
        def action = "add"
        withMobileDevice { 
            action = "add_mobile"
        }
        
        def email = new Email(params);
        if (email.validate()) {
            emailService.add(email)
            
            redirect (action: action)
        }else {
            render (view: action, model:[email:email])
        }   
    }

    //------------------------------- ADD -------------------------------------
    def add(){   
        withMobileDevice { 
            redirect(action: "add_mobile")
        }
    }
    def add_mobile(){
        
        
    }
    //-------------------------------- LIST
    def list(){
                
        withMobileDevice { 
            redirect(action: "list_mobile")
       }
        
    }
    def list_mobile(){
        
        
    }
}
