package com.icodeap.apirest.service;

import com.icodeap.apirest.model.Account;
import com.icodeap.apirest.model.Payment;
import com.icodeap.apirest.Accounts.SimpleInterestCalculator;
import com.icodeap.apirest.repository.AccountRepository;
import com.icodeap.apirest.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService {

    @Autowired
    private  AccountRepository accountRepository;
    @Autowired
    private  PaymentRepository paymentRepository;


    public AccountService(
                           AccountRepository accountRepository,
                           PaymentRepository paymentRepository) {
        this.accountRepository = accountRepository;
        this.paymentRepository = paymentRepository;
    }
    public Account calculateAndSavePayments(Account account) {
        Account accountBack = SimpleInterestCalculator.calculatePayments(account);
        return accountBack;
    }

}
