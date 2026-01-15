package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    @Autowired
    private AbrigoService abrigoService;

    public List<PetDto> listarTodosDisponiveis() {
        return repository.findAllByAdotado(false)
                .stream()
                .map(PetDto::new)
                .toList();
    }



}