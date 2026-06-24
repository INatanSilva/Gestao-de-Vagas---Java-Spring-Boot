package br.com.natansilva.gestao_vagas.modules.company.useCases;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.natansilva.gestao_vagas.modules.company.dto.AuthCompanyDto;
import br.com.natansilva.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {
    
    @Value("{$security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDto authCompanyDto) throws AuthenticationException {
        var companies = this.companyRepository.findByUsername(authCompanyDto.getUsername()).orElseThrow(
            () -> {
                throw new UsernameNotFoundException("Username or password incorrect");
            }
        );

        // Verificar a senha se sao iguais
        var passwordMAtches = this.passwordEncoder.matches(authCompanyDto.getPassword(), companies.getPassword());

        // Se nao for igual -> Error
        if (!passwordMAtches) {
            throw new AuthenticationException();
        }
        // Se for igual -> Gerar o Token 
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("javagas")
            .withSubject(companies.getId().toString())
            .sign(algorithm);
        return token;
    }

}
