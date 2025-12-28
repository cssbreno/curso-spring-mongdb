package com.cssbreno.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cssbreno.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //indica que essa classe vai interceptar exceções lançadas pelos controladores REST
public class ResourceExceptionHandler {
  @ExceptionHandler(ObjectNotFoundException.class) //indica que esse método vai tratar exceções do tipo ObjectNotFoundException
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
      HttpServletRequest request) { //método que será chamado quando uma ObjectNotFoundException for lançada

    HttpStatus status = HttpStatus.NOT_FOUND; //define o status HTTP 404 (Not Found)
    StandardError error = new StandardError(System.currentTimeMillis(), status.value(), status.getReasonPhrase(), e.getMessage(),
        request.getRequestURI()); //cria um objeto StandardError com os detalhes do erro
    return ResponseEntity.status(status).body(error); //retorna uma resposta HTTP com o status 404 e o corpo contendo os detalhes do erro
  }
}
