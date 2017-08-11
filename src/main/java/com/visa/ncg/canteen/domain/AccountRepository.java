package com.visa.ncg.canteen.domain;

import com.visa.ncg.canteen.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    public List<Account> findAll();
}
