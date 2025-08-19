package com.JuniorJavaDeveloper.banksystem.services.impl;

import com.JuniorJavaDeveloper.banksystem.entity.Bank;
import com.JuniorJavaDeveloper.banksystem.repository.BankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankServiceImplTest {

    @Mock
    private BankRepository bankRepository;

    private BankServiceImpl bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankServiceImpl(bankRepository);
    }

    @Test
    void findAllReturnsBanks() {
        List<Bank> banks = Arrays.asList(new Bank(), new Bank());
        when(bankRepository.findAll()).thenReturn(banks);

        List<Bank> result = bankService.findAll();

        assertEquals(banks, result);
        verify(bankRepository).findAll();
    }

    @Test
    void saveDelegatesToRepository() {
        Bank bank = new Bank();
        bankService.save(bank);
        verify(bankRepository).save(bank);
    }

    @Test
    void deleteRemovesBank() {
        UUID id = UUID.randomUUID();
        Bank bank = new Bank();
        when(bankRepository.getById(id)).thenReturn(bank);

        bankService.delete(id);

        verify(bankRepository).delete(bank);
    }
}

