package se.nackademin.java20.lab1.Domain;

import java.util.Optional;

public interface IAccountRepository{
    Account save(Account account);

    Optional<Account> findByUserIdAndAccountId(String holder, long accountId);
}
