package com.projeto.forum.controller;

import com.projeto.forum.modelo.Curso;
import com.projeto.forum.modelo.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TopicosController {

    @GetMapping("/topicos")
    @ResponseBody
    public List<Topico> lista() {
        Topico topico = new Topico("Dúvida com JPA", "Tenho uma dúvida sobre JPA", new Curso("Hibernate", "programação"));
        return Arrays.asList(topico, topico, topico);
    }
}

