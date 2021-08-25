package se.nackademin.java20.lab1.application;

import se.nackademin.java20.lab1.Domain.Account;
import se.nackademin.java20.lab1.Domain.IAccountRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public class BankService {
    private final IAccountRepository iAccountRepository;

    public BankService(IAccountRepository iAccountRepository){
        this.iAccountRepository = iAccountRepository;
    }

    @Transactional
    public Account openAccount (String holder) {
       return iAccountRepository.save(new Account(holder, 0));
    }

    @Transactional
    public Account withdraw(String holder, Long id, int amount){
        Account account = iAccountRepository.findByHolderAndAccountId(holder, id).orElseThrow(() -> new RuntimeException("not found"));
        account.withdraw(amount);
        iAccountRepository.save(account);
        return account;
    }
    @Transactional
    public Account deposit(long id, String holder, int amount) {
        Account account = iAccountRepository.findByHolderAndAccountId(holder, id).orElseThrow(() -> new RuntimeException("Could not find account"));
        account.deposit(amount);
        iAccountRepository.save(account);
        return account;
    }

    @Transactional
    public Account checkBalance(String holder, Long id){
        Account account = iAccountRepository.findByHolderAndAccountId(holder,id).orElseThrow(() -> new RuntimeException("Could not find account"));
        return account;
    }
}
