  
package com.resale.app.view.navigationbar;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class BottomNavigationBar  implements Menu, Serializable {

    @Override
    public String menu(int activeLinkIndex) {
        return StringUtils.EMPTY;
    }
}
