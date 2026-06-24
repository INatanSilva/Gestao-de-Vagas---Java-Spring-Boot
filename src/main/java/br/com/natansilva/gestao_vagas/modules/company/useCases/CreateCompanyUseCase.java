package br.com.natansilva.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.natansilva.gestao_vagas.exceptions.UserFoundException;
import br.com.natansilva.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.natansilva.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        // Lógica para criar uma nova empresa
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
            .ifPresent(user -> {
                throw new UserFoundException();
            });

            var password = passwordEncoder.encode(companyEntity.getPassword());
            companyEntity.setPassword(password);
            
        return this.companyRepository.save(companyEntity);

    }
}
