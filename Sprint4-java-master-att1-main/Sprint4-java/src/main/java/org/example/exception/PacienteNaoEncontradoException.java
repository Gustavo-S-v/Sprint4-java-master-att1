package org.example.exception;

public class PacienteNaoEncontradoException extends RuntimeException {
    public PacienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
