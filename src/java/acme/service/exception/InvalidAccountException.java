package acme.service.exception;

public class InvalidAccountException extends Exception {
    String details;
    public InvalidAccountException(String reason, String details) {
        super(reason);
        this.details = details;
    }
    
    public String getFaultInfo() {return details;}
    
}
