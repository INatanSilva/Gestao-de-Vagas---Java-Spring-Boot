package br.com.natansilva.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.natansilva.gestao_vagas.modules.company.entities.JobEntity;
import br.com.natansilva.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
    
    @Autowired
    private JobRepository jobRepository;
    
    public JobEntity execute(JobEntity jobEntity) {
        // Lógica para criar uma vaga de emprego
        return this.jobRepository.save(jobEntity);
    }

}
