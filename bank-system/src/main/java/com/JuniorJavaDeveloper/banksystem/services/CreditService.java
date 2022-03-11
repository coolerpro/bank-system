package com.JuniorJavaDeveloper.banksystem.services;

import com.JuniorJavaDeveloper.banksystem.models.BankDto;
import com.JuniorJavaDeveloper.banksystem.models.ClientDto;
import com.JuniorJavaDeveloper.banksystem.models.CreditDto;

import java.util.List;
import java.util.UUID;

public interface CreditService {

    List<CreditDto> getCredits();
    List<CreditDto> getCredits(ClientDto clientDto);
    List<CreditDto> getCredits(BankDto bankDto);
    List<CreditDto> getCredits(BankDto bankDto, ClientDto clientDto);

    CreditDto getCredit(UUID id);

    void save(CreditDto creditNew) throws Exception;
    void update(CreditDto creditEdit) throws Exception;
    void delete(UUID id);
}
