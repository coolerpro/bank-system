package com.juniorjavadeveloper.banksystem.forms.menu;

import java.util.List;

public interface MenuForm {

    List<MenuFormImpl.PointMenu> getMenuList();

    void addMenuPoint(String name, String href);

}
