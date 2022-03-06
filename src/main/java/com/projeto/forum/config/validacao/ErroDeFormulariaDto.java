package com.projeto.forum.config.validacao;

public class ErroDeFormulariaDto {

    private String campo;
    private String erro;

    public ErroDeFormulariaDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
