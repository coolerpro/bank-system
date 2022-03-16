package com.JuniorJavaDeveloper.banksystem.services.creditbuilder.impl;

import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.ScheduleBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleBuilderImpl implements ScheduleBuilder {

    private List<LocalDate> dateList;

    public ScheduleBuilderImpl() {
    }

    public List<LocalDate> calculateSchedule(LocalDate dateFirstPay, int countMonth) {

        dateList = new ArrayList<>();
        LocalDate datePay = dateFirstPay;
        for (int i = 0; i < countMonth; i++) {
            dateList.add(datePay.plusMonths(i));
        }
        return dateList;
    }

    public List<LocalDate> getDateList() {
        return dateList;
    }

    public void setDateList(List<LocalDate> dateList) {
        this.dateList = dateList;
    }
}
