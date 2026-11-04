package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeDados {

    @ExceptionHandler(PacienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResponse lidarComError(PacienteNaoEncontradoException ex) {
        return new ErroResponse(ex.getMessage(), 404);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse lidarComValidacao(MethodArgumentNotValidException ex) {
        String mensagem = "Dados inválidos";
        FieldError erro = ex.getBindingResult().getFieldError();
        if (erro != null) {
            mensagem = erro.getDefaultMessage();
        }
        return new ErroResponse(mensagem, 400);
    }

    @ExceptionHandler(MedicoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResponse lidarComMedicoNaoEncontrado(MedicoNaoEncontradoException ex) {
        return new ErroResponse(ex.getMessage(), 404);
    }
}