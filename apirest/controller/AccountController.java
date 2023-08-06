package com.icodeap.apirest.controller;


import com.icodeap.apirest.model.Account;
import com.icodeap.apirest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

public class AccountController {

    @Autowired
   private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/calculateAndSave")
    public ResponseEntity<Account> calculateAndSavePayments(@RequestBody Account account) {
        Account account1 = accountService.calculateAndSavePayments(account);
        return ResponseEntity.ok(account1);
    }
}
