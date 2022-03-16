package com.JuniorJavaDeveloper.banksystem.services.creditbuilder.impl;

import com.JuniorJavaDeveloper.banksystem.services.creditbuilder.ScheduleBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleBuilderImpl implements ScheduleBuilder {

    private List<LocalDate> dateList;

    public ScheduleBuilderImpl() {
    }

    public List<LocalDate> calculateSchedule(LocalDate dateFirstPay, int countMonth) {

        LocalDate datePay = dateFirstPay;
        for (int i = 0; i < countMonth; i++) {
            dateList.add(datePay);
            datePay.plusMonths(1);
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
