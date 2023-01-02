package au.com.tgg.apps.foundation.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TggApiRuntimeException extends ResponseStatusException {


    public TggApiRuntimeException() {
        super(HttpStatus.BAD_REQUEST);
    }

    public TggApiRuntimeException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }

    public TggApiRuntimeException(String reason, Throwable cause) {
        super(HttpStatus.BAD_REQUEST, reason, cause);
    }

    public TggApiRuntimeException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }
}
