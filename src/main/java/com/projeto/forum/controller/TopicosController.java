package com.projeto.forum.controller;

import com.projeto.forum.controller.dto.TopicoDTO;
import com.projeto.forum.modelo.Curso;
import com.projeto.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista() {
        Topico topico = new Topico("Dúvida com JPA", "Tenho uma dúvida sobre JPA", new Curso("Hibernate", "programação"));
        return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
    }
}

