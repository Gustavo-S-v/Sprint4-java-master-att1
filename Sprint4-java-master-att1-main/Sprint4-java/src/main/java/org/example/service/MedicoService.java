package org.example.service;

import org.example.model.Medico;
import org.example.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    public Medico buscarPorId(int id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public Medico salvar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deletar(int id) {
        medicoRepository.deleteById(id);
    }
}
