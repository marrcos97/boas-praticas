package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTutorComAdocaoPendente implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
        boolean tutorTemAdocaoPendente = adocaoRepository.existsByTutorAndStatus(tutor, StatusAdocao.AGUARDANDO_AVALIACAO);

        if (tutorTemAdocaoPendente) {
            throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
        }
    }

}
