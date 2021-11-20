class InvalidBankTransaction extends Exception {
    // Custom Exception class

    InvalidBankTransaction() {
        
    }

    String errorMessage;
    public InvalidBankTransaction(String message) {

        errorMessage = message;
    }

    public String getMessage() {
        return errorMessage;
    }
    
}
