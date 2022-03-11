package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.models.BankDto;
import com.JuniorJavaDeveloper.banksystem.models.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.repository.BankRepository;
import com.JuniorJavaDeveloper.banksystem.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<BankDto> banksList(){

        List<BankDto> bankDtoList = new ArrayList<>();
        List<Bank> bankListEmt = bankRepository.findAll();

        for (Bank bank:bankListEmt) {
            bankDtoList.add(convertToDto(bank));
        }

        return bankDtoList;
    }

    @Override
    public BankDto getBank(UUID id){
        return convertToDto(bankRepository.getById(id));
    }

    @Override
    public void save(BankDto bankNew) {
        bankRepository.saveAndFlush(convertToEnt(bankNew));
    }

    @Override
    public void update(BankDto bankEdit) {
        bankRepository.saveAndFlush(convertToEnt(bankEdit));
    }

    @Override
    public void delete(UUID id){
        bankRepository.delete(bankRepository.getById(id));
    }

    @Override
    public BankDto convertToDto(Bank bank){

        BankDto bankDto = new BankDto();
        bankDto.setId(bank.getId());
        bankDto.setName(bank.getName());
        bankDto.setInn(bank.getInn());
        bankDto.setBic(bank.getBic());

        return bankDto;
    }

    @Override
    public Bank convertToEnt(BankDto bankDto){

        Bank bankEnt = new Bank();
        bankEnt.setId(bankDto.getId());
        bankEnt.setName(bankDto.getName());
        bankEnt.setInn(bankDto.getInn());
        bankEnt.setBic(bankDto.getBic());

        return bankEnt;
    }

}
