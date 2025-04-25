package ca.hccis.photography.exception;

/**
 * The PhotographySessionException class
 *
 * @author Vy Phan
 * @since 20240926
 */
public class PhotographySessionException extends RuntimeException{
    public PhotographySessionException(){
        super();
    }

    public PhotographySessionException(String message){
        super(message);
    }
}
