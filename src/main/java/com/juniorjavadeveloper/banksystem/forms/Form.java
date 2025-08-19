package com.juniorjavadeveloper.banksystem.forms;

import com.juniorjavadeveloper.banksystem.forms.menu.MenuForm;

public class Form {

    private MenuForm menuForm;

    private String content;
    private String title;

    public MenuForm getMenuForm() {
        return menuForm;
    }

    public void setMenuForm(MenuForm menuForm) {
        this.menuForm = menuForm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
