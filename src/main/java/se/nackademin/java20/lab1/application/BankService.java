package se.nackademin.java20.lab1.application;

import se.nackademin.java20.lab1.Domain.Account;
import se.nackademin.java20.lab1.Domain.IAccountRepository;

import javax.transaction.Transactional;

public class BankService {
    private final IAccountRepository iAccountRepository;

    public BankService(IAccountRepository iAccountRepository){
        this.iAccountRepository = iAccountRepository;
    }

    @Transactional
    public Account openAccount (String holder) {
       return iAccountRepository.save(new Account(holder, 0));
    }
}
