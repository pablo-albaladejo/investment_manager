package investmentmanager.mailing

class Email {

    String name
    String surname
    String address
    
    static constraints = {
        name blank: false, nullable: false
        surname blank: false, nullable: false
        address email: true, nullable: false
    }
}
