package systems.singularity.buildware.exceptions;

/**
 * Created by pedro on 7/26/16.
 * © 2016 Singularity Systems
 */
public class InvalidBirthdateException extends Exception {
    public InvalidBirthdateException() {
        super("Data de Nascimento Inválida!");
    }
}
