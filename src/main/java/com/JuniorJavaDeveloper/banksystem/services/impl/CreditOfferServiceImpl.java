package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.models.BankDto;
import com.JuniorJavaDeveloper.banksystem.models.CreditOfferDto;
import com.JuniorJavaDeveloper.banksystem.models.entity.CreditOffer;
import com.JuniorJavaDeveloper.banksystem.repository.CreditOfferRepository;
import com.JuniorJavaDeveloper.banksystem.services.BankService;
import com.JuniorJavaDeveloper.banksystem.services.CreditOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CreditOfferServiceImpl implements CreditOfferService {

    private CreditOfferRepository creditOfferRepository;
    private BankService bankService;

    @Autowired
    public CreditOfferServiceImpl(CreditOfferRepository creditOfferRepository, BankService bankService) {
        this.creditOfferRepository = creditOfferRepository;
        this.bankService = bankService;
    }

    @Override
    public List<CreditOfferDto> creditOffersList(){

        List<CreditOfferDto>  creditOfferDtoList = new ArrayList<>();

        List<CreditOffer> creditOfferList = creditOfferRepository.findAll();

        for (CreditOffer creditOffer: creditOfferList) {
            creditOfferDtoList.add(convertToDto(creditOffer));
        }

        return creditOfferDtoList;
    }
    @Override
    public List<CreditOfferDto> creditOffersList(BankDto bankDto){

        List<CreditOfferDto>  creditOfferDtoList = new ArrayList<>();

        List<CreditOffer> creditOfferList = creditOfferRepository.getCreditOfferByClient(bankDto.getId());

        for (CreditOffer creditOffer: creditOfferList) {
            creditOfferDtoList.add(convertToDto(creditOffer));
        }

        return creditOfferDtoList;
    }

    @Override
    public CreditOfferDto getCreditOffer(UUID id){

        CreditOffer creditOffer = creditOfferRepository.getById(id);

        return convertToDto(creditOffer);
    }

    @Override
    public void save(CreditOfferDto creditOfferNew) throws Exception {
        creditOfferRepository.saveAndFlush(convertToEnt(creditOfferNew));
    }

    @Override
    public void update(CreditOfferDto creditOfferEdit) throws Exception {
        creditOfferRepository.saveAndFlush(convertToEnt(creditOfferEdit));
    }

    @Override
    public void delete(UUID id){
        creditOfferRepository.delete(creditOfferRepository.getById(id));
    }



    private CreditOfferDto convertToDto(CreditOffer creditOffer) {

        BankDto bankDto = bankService.getBank(creditOffer.getBankId());
        CreditOfferDto creditOfferDto = new CreditOfferDto();

        creditOfferDto.setId(creditOffer.getId());
        creditOfferDto.setCreditLimit(creditOffer.getCreditLimit());
        creditOfferDto.setInterestRate(creditOffer.getInterestRate());

        creditOfferDto.setCreditOrganization(bankDto);

        return creditOfferDto;
    }

    private CreditOffer convertToEnt(CreditOfferDto creditOfferDto) {

        CreditOffer creditOffer = new CreditOffer();

        creditOffer.setId(creditOfferDto.getId());
        creditOffer.setCreditLimit(creditOfferDto.getCreditLimit());
        creditOffer.setInterestRate(creditOfferDto.getInterestRate());

        creditOffer.setBankId(creditOfferDto.getCreditOrganization().getId());

        return creditOffer;
    }

}
