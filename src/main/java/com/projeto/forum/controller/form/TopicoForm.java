package com.projeto.forum.controller.form;

import com.projeto.forum.modelo.Curso;
import com.projeto.forum.modelo.Topico;
import com.projeto.forum.repository.CursoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class TopicoForm {

    @NotNull @NotEmpty @Size(min = 5)
    private String titulo;
    @NotNull @NotEmpty @Size(min = 10)
    private String mensagem;
    @NotNull @NotEmpty
    private String nomecurso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomecurso);
        return new Topico(titulo, mensagem, curso);
    }
}
