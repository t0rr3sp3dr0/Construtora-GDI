package systems.singularity.buildware.exceptions;

/**
 * Created by pedro on 7/17/16.
 * © 2016 Singularity Systems
 */
public class InvalidZipCodeException extends Exception {
    public InvalidZipCodeException() {
        super("CEP Inválido!");
    }
}
