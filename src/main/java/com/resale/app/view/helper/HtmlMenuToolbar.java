package com.resale.app.view.helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HtmlMenuToolbar implements HtmlMenu, Serializable {

    private String menu;

    private int activeLink;

    private final List<MenuLink> links = new ArrayList<>();

    {
        links.add(new MenuLink("./track", "Track", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./payment", "Payment", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./logout", "Logout", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./login", "Login", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./bids", "Bids", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./type", "category", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./item", "Add Item", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./home", "Home", MenuLinkStatus.ACTIVE));
    }

    public String getMenu() {

        this.activateLink(getActiveLink());

        String menuBar = "<div class=\"topnav\">";

        for (MenuLink link : links)
            menuBar += "<a " + (link.getStatus() == MenuLinkStatus.ACTIVE ? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";

        menuBar += "</div>";

        return menuBar;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getActiveLink() {
        return activeLink;
    }

    public void setActiveLink(int activeLink) {
        this.activeLink = activeLink;
    }

    private void activateLink(int linkIndex) {
        for (int index = 0; index < links.size(); index++) {
            if (index == linkIndex)
                links.get(index).setStatus(MenuLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
        }

    }

    @Override
    public String menu(int activeLinkIndex) {
        return null;
    }
}