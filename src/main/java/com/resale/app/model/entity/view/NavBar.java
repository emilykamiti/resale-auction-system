package com.resale.app.model.entity.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.resale.app.model.entity.UserType;

public class NavBar implements Menu, Serializable {

    private String menu;
    private int activeLink;
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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

    private final List<NavigationLink> leftLinks = new ArrayList<>();
    private final List<NavigationLink> rightLinks = new ArrayList<>();

    {
        leftLinks.add(new NavigationLink("./about", "About us", NavStatus.ACTIVE));
        leftLinks.add(new NavigationLink("./home", "Home", NavStatus.ACTIVE));
        leftLinks.add(new NavigationLink("./type", "Category", NavStatus.ACTIVE));
        leftLinks.add(new NavigationLink("./register.jsp", "Register", NavStatus.NOT_ACTIVE));
        leftLinks.add(new NavigationLink("./login", "Login", NavStatus.NOT_ACTIVE));
        rightLinks.add(new NavigationLink("./admin", "Admin", NavStatus.NOT_ACTIVE));
    }

    public String getMenu() {
        this.activateLink(getActiveLink());

        String navbarLinks = "<div class='topnav'>";

        navbarLinks += "<div class='left'>";
        for (NavigationLink link : leftLinks)
            navbarLinks += "<a " + (link.getStatus() == NavStatus.ACTIVE ? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";
        navbarLinks += "</div>";

        navbarLinks += "<div class='right'>";
        if (getUserType() != null && getUserType() == UserType.ADMIN) {
            rightLinks.add(new NavigationLink("./admin", "Admin", NavStatus.NOT_ACTIVE));
        }
        for (NavigationLink link : rightLinks)
            navbarLinks += "<a " + (link.getStatus() == NavStatus.ACTIVE ? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";
        navbarLinks += "</div>";

        navbarLinks += "</div>";
        return navbarLinks;
    }

    private void activateLink(int linkIndex) {
        List<NavigationLink> allLinks = new ArrayList<>();
        allLinks.addAll(leftLinks);
        allLinks.addAll(rightLinks);

        for (int index = 0; index < allLinks.size(); index++) {
            if (index == linkIndex)
                allLinks.get(index).setStatus(NavStatus.ACTIVE);
            else
                allLinks.get(index).setStatus(NavStatus.NOT_ACTIVE);
        }
    }

    @Override
    public String menu(int activeLinkIndex) {
        return null;
    }
}