package nl.novi.TIEwebapi.exceptions;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException () {

        super();
    }

    public RecordNotFoundException (String message) {

        super(message);

    }
}
