package org.example.exception;

public class ErroResponse {
    private String erro;
    private int Status;

    public ErroResponse(String erro, int status) {
        this.erro = erro;
        Status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
