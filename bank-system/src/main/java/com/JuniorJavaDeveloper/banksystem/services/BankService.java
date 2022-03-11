package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.models.BankDto;
import com.JuniorJavaDeveloper.banksystem.models.entity.Bank;

import java.util.List;
import java.util.UUID;

public interface BankService {

    List<BankDto> banksList();
    BankDto getBank(UUID id);
    void save(BankDto bankNew);
    void update(BankDto bankEdit);
    void delete(UUID id);
    BankDto convertToDto(Bank bank);
    Bank convertToEnt(BankDto bankDto);

}
