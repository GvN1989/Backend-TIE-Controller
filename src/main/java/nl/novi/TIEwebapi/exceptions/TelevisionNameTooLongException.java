package nl.novi.TIEwebapi.exceptions;

import nl.novi.TIEwebapi.models.Television;

public class TelevisionNameTooLongException extends RuntimeException{
    public TelevisionNameTooLongException (String message) {
        super(message);

    }

    public TelevisionNameTooLongException(){
        super();
    }

}
