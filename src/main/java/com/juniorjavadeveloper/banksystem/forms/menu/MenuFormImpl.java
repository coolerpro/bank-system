package com.juniorjavadeveloper.banksystem.forms.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuFormImpl implements MenuForm {

    private List<PointMenu> menuList;

    class PointMenu {
        private String namePoint;
        private String hrefPoint;

        public PointMenu(String namePoint, String hrefPoint) {
            this.namePoint = namePoint;
            this.hrefPoint = hrefPoint;
        }

        public String getNamePoint() {
            return namePoint;
        }

        public String getHrefPoint() {
            return hrefPoint;
        }
    }

    public MenuFormImpl() {
        this.menuList = new ArrayList<>();
    }

    public List<PointMenu> getMenuList() {
        return menuList;
    }

    public void addMenuPoint(String name, String href) {
        this.menuList.add(new PointMenu(name, href));
    }
}
