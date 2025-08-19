package com.juniorjavadeveloper.banksystem.services.creditmanager;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleManager {
    List<LocalDate> calculateSchedule(LocalDate dateFirstPay, int countMonth);
}
