package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.DTOMedicoRequest;
import org.example.dto.DTOMedicoResponse;
import org.example.model.Medico;
import org.example.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<DTOMedicoResponse>> listarTodos() {
        List<Medico> medicos = medicoService.listarMedicos();
        List<DTOMedicoResponse> response = medicos.stream()
                .map(m -> new DTOMedicoResponse(m.getId(), m.getNome(), m.getCrm(), m.getEspecialidade()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOMedicoResponse> buscarPorId(@PathVariable int id) {
        Medico medico = medicoService.buscarPorId(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }
        DTOMedicoResponse response = new DTOMedicoResponse(
                medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade()
        );
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DTOMedicoResponse> cadastrar(@Valid @RequestBody DTOMedicoRequest dto) {
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());

        Medico salvo = medicoService.salvar(medico);
        DTOMedicoResponse response = new DTOMedicoResponse(
                salvo.getId(), salvo.getNome(), salvo.getCrm(), salvo.getEspecialidade()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remover(@PathVariable int id) {
        medicoService.deletar(id);
        return ResponseEntity.ok("Médico removido com sucesso!");
    }
}
