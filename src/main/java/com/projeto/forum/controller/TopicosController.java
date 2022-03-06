package com.projeto.forum.controller;

import com.projeto.forum.controller.dto.TopicoDTO;
import com.projeto.forum.controller.form.TopicoForm;
import com.projeto.forum.modelo.Topico;
import com.projeto.forum.repository.CursoRepository;
import com.projeto.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    TopicoRepository repository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> lista(String nomeCurso) {
        if(nomeCurso == null) {
            List<Topico> topicos = repository.findAll();
            return TopicoDTO.converter(topicos);
        } else {
            List<Topico> topicos = repository.findByCurso_Nome(nomeCurso);
            return TopicoDTO.converter(topicos);
        }

    }
    @PostMapping
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        repository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }
}

