package systems.singularity.buildware.exceptions;

/**
 * Created by pedro on 7/26/16.
 * © 2016 Singularity Systems
 */
public class InvalidCNPJException extends Exception {
    public InvalidCNPJException() {
        super("CNPJ Inválido!");
    }
}
