package org.example.service;

import org.example.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {

    private List<Paciente> pacientesDB = new ArrayList<>();

    public List<Paciente> listarPacientes() {
        return pacientesDB;
    }

    public Paciente buscarPorId(int id) {
        for (Paciente p : pacientesDB) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void salvar(Paciente paciente) {
        paciente.setId(pacientesDB.size() + 1);
        pacientesDB.add(paciente);
    }

    public void deletar(int id) {
        pacientesDB.removeIf(p -> p.getId() == id);
    }
}