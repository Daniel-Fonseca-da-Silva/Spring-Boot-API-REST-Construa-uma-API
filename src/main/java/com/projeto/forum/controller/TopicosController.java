package com.projeto.forum.controller;

import com.projeto.forum.controller.dto.TopicoDTO;
import com.projeto.forum.modelo.Topico;
import com.projeto.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    TopicoRepository repository;

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista() {
        List<Topico> topicos = repository.findAll();
        return TopicoDTO.converter(topicos);
    }
}

