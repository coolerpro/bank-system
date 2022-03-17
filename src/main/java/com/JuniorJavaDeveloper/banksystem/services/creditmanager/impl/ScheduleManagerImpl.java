package com.JuniorJavaDeveloper.banksystem.services.creditmanager.impl;

import com.JuniorJavaDeveloper.banksystem.services.creditmanager.ScheduleManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleManagerImpl implements ScheduleManager {

    public List<LocalDate> calculateSchedule(LocalDate dateFirstPay, int countMonth) {

        List<LocalDate> dateList = new ArrayList<>();
        LocalDate datePay = dateFirstPay;
        for (int i = 0; i < countMonth; i++) {
            dateList.add(datePay.plusMonths(i));
        }
        return dateList;
    }
}
