package com.resale.app.view.navigationbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.resale.app.view.html.MenuLink;
import com.resale.app.view.html.MenuLinkStatus;

public class TopNavigationBar implements Menu, Serializable {

    private final List<MenuLink> links = new ArrayList<>();

    {
        links.add(new MenuLink("./home", "Home", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./track", "Track", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./payment", "Payment", MenuLinkStatus.NOT_ACTIVE));
        links.add(new MenuLink("./logout", "Logout", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./login.html", "Login", MenuLinkStatus.ACTIVE));
        links.add(new MenuLink("./showbid", "Bids", MenuLinkStatus.ACTIVE));
    }

    @Override
    public String menu(int activeLinkIndex) {
        activateLink(activeLinkIndex);

        String menuBar = "<div class=\"topnav\">";

        for (MenuLink link : links) {
            menuBar += "<a " + (link.getStatus() == MenuLinkStatus.ACTIVE ? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";
        }

        menuBar += "</div>";
        links.add(new MenuLink("./itemaction", "Item", MenuLinkStatus.NOT_ACTIVE));
        return menuBar;
    }

    private void activateLink(int linkIndex) {
        for (int index = 0; index < links.size(); index++) {
            if (index == linkIndex) {
                links.get(index).setStatus(MenuLinkStatus.ACTIVE);
            } else {
                links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
            }
        }
    }
}
