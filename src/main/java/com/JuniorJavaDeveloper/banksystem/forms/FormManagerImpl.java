package com.JuniorJavaDeveloper.banksystem.forms;

import com.JuniorJavaDeveloper.banksystem.forms.menu.MenuManager;
import org.springframework.stereotype.Component;

@Component
public class FormManagerImpl implements FormManager {

    private final MenuManager menuManager;

    public FormManagerImpl(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @Override
    public HomeForm getHomeForm() {
        HomeForm homeForm = new HomeForm();
        homeForm.setMenuForm(menuManager.getMenuForm());
        return homeForm;
    }
}
