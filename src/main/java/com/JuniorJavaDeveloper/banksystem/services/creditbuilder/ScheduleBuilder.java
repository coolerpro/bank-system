package com.JuniorJavaDeveloper.banksystem.services.creditbuilder;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleBuilder {
    List<LocalDate> calculateSchedule(LocalDate dateFirstPay, int countMonth);
}
