package com.visa.ncg.canteen;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.visa.ncg.canteen.data.AccountRepository;

@Component
public class DataLoader implements ApplicationRunner{

    private AccountRepository accountRepository;

    public DataLoader(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Account account = accountRepository.save(new Account("Bank", 100));
        account = accountRepository.save(new Account("Necessities",20));

        accountRepository.save(new Account("Luxuries", 15));
    }
}
