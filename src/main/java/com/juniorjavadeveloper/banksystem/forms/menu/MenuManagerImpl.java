package com.juniorjavadeveloper.banksystem.forms.menu;

import org.springframework.stereotype.Component;

@Component
public class MenuManagerImpl implements MenuManager {

    private MenuForm menuForm;

    public void setStandartMenu() {
        menuForm = new MenuFormImpl();
        menuForm.addMenuPoint("Домашняя", "");
        menuForm.addMenuPoint("Список банков", "bank");
        menuForm.addMenuPoint("Список клиентов", "client");
        menuForm.addMenuPoint("Спсок кредитных предложений", "creditoffer");
        menuForm.addMenuPoint("Спсок кредитов", "credit");
    }

    public MenuForm getMenuForm() {

        if (menuForm == null)
            setStandartMenu();

        return menuForm;
    }

    public void setMenuForm(MenuForm menuForm) {
        this.menuForm = menuForm;
    }
}
