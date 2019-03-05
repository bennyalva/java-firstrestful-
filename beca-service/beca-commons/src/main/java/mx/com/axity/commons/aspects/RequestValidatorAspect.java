package mx.com.axity.commons.aspects;

import mx.com.axity.commons.exceptions.BusinessException;
import mx.com.axity.commons.to.ErrorTo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

@Aspect
@Configuration
public class RequestValidatorAspect {

    static final Logger LOG = LogManager.getLogger(RequestValidatorAspect.class);

    @Around(value = "execution(* mx.com.axity.web.rest.*.*(..))  && args(..)")  //
    public ResponseEntity execute(ProceedingJoinPoint joinPoint) {
        ResponseEntity result;
        ErrorTo errorTo;
        try {
            LOG.info("Access");
            LOG.info(String.format("Execution: %s", joinPoint.getSignature()));
            result = (ResponseEntity) joinPoint.proceed();
            return result;
        }catch (Throwable e) {
            LOG.info("Exception Ocurred");
            LOG.info("Execution: {}", joinPoint.getSignature());
            LOG.info("Exception: {}", e);
            if (e instanceof NoSuchElementException){
                errorTo = new ErrorTo();
                errorTo.setErrorCode(25);
                errorTo.setErrorMessage("No hay registros con col id proporcionado");

            }else{
                errorTo = new ErrorTo();
                errorTo.setErrorCode(50);
                errorTo.setErrorMessage("Ocurrió un error en el servidor");
            }
           return new ResponseEntity<ErrorTo>(errorTo, HttpStatus.OK);
        }
    }
}
