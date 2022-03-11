package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.models.*;
import com.JuniorJavaDeveloper.banksystem.models.entity.Credit;
import com.JuniorJavaDeveloper.banksystem.repository.CreditRepository;
import com.JuniorJavaDeveloper.banksystem.services.*;
import com.example.JuniorJavaDeveloper.banksystem.models.*;
import com.example.JuniorJavaDeveloper.banksystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CreditImpl implements CreditService {

    private CreditRepository creditRepository;
    private BankService bankService;
    private ClientService clientService;
    private CreditOfferService creditOfferService;
    private PaymentScheduleService paymentScheduleService;

    @Autowired
    public CreditImpl(CreditRepository creditRepository, BankService bankService, ClientService clientService, CreditOfferService creditOfferService, PaymentScheduleService paymentScheduleService) {
        this.creditRepository = creditRepository;
        this.bankService = bankService;
        this.clientService = clientService;
        this.creditOfferService = creditOfferService;
        this.paymentScheduleService = paymentScheduleService;
    }

    @Override
    public List<CreditDto> getCredits(){

        List<CreditDto>  creditDtoList = new ArrayList<>();

        List<Credit> creditList = creditRepository.findAll();

        for (Credit credit: creditList) {
            creditDtoList.add(convertToDto(credit));
        }

        return creditDtoList;
    }

    @Override
    public List<CreditDto> getCredits(ClientDto clientDto){

        List<CreditDto>  creditDtoList = new ArrayList<>();

        List<Credit> creditList = creditRepository.getCreditsByClient(clientDto.getId());

        for (Credit credit: creditList) {
            creditDtoList.add(convertToDto(credit));
        }

        return creditDtoList;
    }

    @Override
    public List<CreditDto> getCredits(BankDto bankDto){

        List<CreditDto>  creditDtoList = new ArrayList<>();

        List<Credit> creditList = creditRepository.getCreditsByBank(bankDto.getId());

        for (Credit credit: creditList) {
            creditDtoList.add(convertToDto(credit));
        }

        return creditDtoList;
    }

    @Override
    public List<CreditDto> getCredits(BankDto bankDto, ClientDto clientDto){

        List<CreditDto>  creditDtoList = new ArrayList<>();

        List<Credit> creditList = creditRepository.getCreditsByBankClient(bankDto.getId(), clientDto.getId());

        for (Credit credit: creditList) {
            creditDtoList.add(convertToDto(credit));
        }

        return creditDtoList;
    }


    @Override
    public CreditDto getCredit(UUID id){

        Credit credit = creditRepository.getById(id);

        return convertToDto(credit);
    }

    @Override
    public void save(CreditDto creditNew) throws Exception {
        checkFillings(creditNew);
        creditRepository.saveAndFlush(convertToEnt(creditNew));
    }

    @Override
    public void update(CreditDto creditEdit) throws Exception {
        checkFillings(creditEdit);
        creditRepository.saveAndFlush(convertToEnt(creditEdit));
    }

    @Override
    public void delete(UUID id){
        creditRepository.delete(creditRepository.getById(id));
    }




    private CreditDto convertToDto(Credit credit) {

        BankDto bankDto = bankService.getBank(credit.getBankId());
        ClientDto clientDto = clientService.getClient(credit.getClientId());
        CreditOfferDto creditOfferDto = creditOfferService.getCreditOffer(credit.getCreditOfferId());
        PaymentScheduleDto paymentScheduleDto = paymentScheduleService.getPaymentSchedule(credit.getPaymentScheduleId());

        CreditDto creditDto = new CreditDto();

        creditDto.setId(credit.getId());
        creditDto.setSum(credit.getSum());

        creditDto.setBank(bankDto);
        creditDto.setClient(clientDto);
        creditDto.setCreditOffer(creditOfferDto);

        creditDto.setPaymentSchedule(paymentScheduleDto);

        return creditDto;
    }

    private Credit convertToEnt(CreditDto creditDto) {

        Credit credit = new Credit();

        credit.setId(creditDto.getId());
        credit.setSum(creditDto.getSum());

        credit.setBankId(creditDto.getBank().getId());
        credit.setClientId(creditDto.getClient().getId());
        credit.setCreditOfferId(creditDto.getCreditOffer().getId());
        credit.setPaymentScheduleId(creditDto.getPaymentSchedule().getId());

        return credit;
    }

    private void checkFillings(CreditDto creditDto) throws Exception {
        if (creditDto.getClient() == null){
            throw new Exception("Null in the required field clientId");
        }
        if (creditDto.getBank() == null){
            throw new Exception("Null in the required field banktId");
        }
        if (creditDto.getCreditOffer() == null){
            throw new Exception("Null in the required field creditOfferId");
        }
        if (creditDto.getPaymentSchedule() == null){
            throw new Exception("Null in the required field paymentScheduleId");
        }
    }
}
