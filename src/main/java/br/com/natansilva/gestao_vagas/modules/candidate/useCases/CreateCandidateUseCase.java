package br.com.natansilva.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natansilva.gestao_vagas.exceptions.UserFoundException;
import br.com.natansilva.gestao_vagas.modules.candidate.entities.CandidateEntity;
import br.com.natansilva.gestao_vagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        // Lógica para criar um candidato
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent(user -> {
                throw new UserFoundException();
            });
        return this.candidateRepository.save(candidateEntity);
    }
}
