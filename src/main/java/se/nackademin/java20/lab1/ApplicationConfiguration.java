package se.nackademin.java20.lab1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.nackademin.java20.lab1.Domain.IAccountRepository;
import se.nackademin.java20.lab1.application.BankService;
import se.nackademin.java20.lab1.persistance.AccountRepositoryHibernate;

import javax.persistence.EntityManager;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public IAccountRepository iAccountRepository(EntityManager em) {
        return new AccountRepositoryHibernate(em);
    }

    @Bean
    public BankService bankService(IAccountRepository iaccountRepository) {
        return new BankService(iaccountRepository);
    }
}
