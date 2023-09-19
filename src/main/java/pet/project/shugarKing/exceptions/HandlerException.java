package pet.project.shugarKing.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestControllerAdvice
public class HandlerException {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler({MissingRequestHeaderException.class, MethodArgumentNotValidException.class,
             MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(final Exception e) {
        log.debug("ERROR bad request {}", e.getMessage(), e);
        return new ErrorResponse(HttpStatus.BAD_REQUEST.name(), e.getMessage(), "Incorrectly made request.", LocalDateTime.now().format(FORMATTER));
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFound(final RuntimeException e) {
        log.debug("ERROR not found {}", e.getMessage(), e);
        return new ErrorResponse(HttpStatus.NOT_FOUND.name(), e.getMessage(), "Not found", LocalDateTime.now().format(FORMATTER));
    }

    @ExceptionHandler({ConflictException.class,
            DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse conflict(final Exception e) {
        log.debug("ERROR conflict {}", e.getMessage(), e);
        return new ErrorResponse(HttpStatus.CONFLICT.name(), e.getMessage(), "Integrity constraint has been violated", LocalDateTime.now().format(FORMATTER));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse internalServerError(final Exception e) {
        log.debug("ERROR Internal Server Error {}", e.getMessage(), e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getMessage(), "Internal Server Error", LocalDateTime.now().format(FORMATTER));
    }
}

