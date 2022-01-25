package utils

class ServiceDownException extends RuntimeException {

    ServiceDownException(String message) {
        super(message)
    }
}
