package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByTutorAndStatus(Tutor tutor, StatusAdocao status);

    boolean existsByPetAndStatus(Pet pet, StatusAdocao status);

    int countByTutorAndStatus(Tutor tutor, StatusAdocao status);

}
