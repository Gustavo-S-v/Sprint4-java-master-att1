package org.example.controller;

import org.example.model.Paciente;
import org.example.service.PacienteService;
import org.example.dto.DTOPacienteResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodosPacientes() {
        List<Paciente> lista = pacienteService.listarPacientes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable int id) {
        Paciente paciente = pacienteService.buscarPorId(id);
        if (paciente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public ResponseEntity<String> cadastrarPaciente(@RequestBody DTOPacienteResponse dto) {
        Paciente novoPaciente = new Paciente();
        novoPaciente.setNome(dto.getNome());
        novoPaciente.setIdade(dto.getIdade());
        novoPaciente.setDoenca(dto.getDoenca());

        pacienteService.salvar(novoPaciente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paciente cadastrado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerPaciente(@PathVariable int id) {
        pacienteService.deletar(id);
        return ResponseEntity.ok("Paciente removido com sucesso!");
    }
}