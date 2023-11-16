package com.resale.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

    public String getStyle() {
        return "<style>\n" +
            ".topnav {\n" +
            "    overflow: hidden;\n" +
            "    background-color: #333;\n" +
            "}\n" +
            ".topnav a {\n" +
            "    float: left;\n" +
            "    color: #f2f2f2;\n" +
            "    text-align: center;\n" +
            "    padding: 14px 16px;\n" +
            "    text-decoration: none;\n" +
            "    font-size: 17px;\n" +
            "}\n" +
            ".topnav a:hover {\n" +
            "    background-color: blue;\n" +
            "    color: black;\n" +
            "}\n" +
            ".topnav a.active {\n" +
            "    background-color: blue;\n" +
            "    color: white;\n" +
            "}\n" +
            "table {\n" +
            "    font-family: arial, sans-serif;\n" +
            "    border-collapse: collapse;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "td, th {\n" +
            "    border: 1px solid #dddddd;\n" +
            "    text-align: left;\n" +
            "    padding: 8px;\n" +
            "}\n" +
            "tr:nth-child(even) {\n" +
            "    background-color: #dddddd;\n" +
            "}\n" +
            "html, body {\n" +
            "    width: 100%;\n" +
            "}\n" +
            ".row {\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    width:50%;\n" +
            "}\n" +
            ".item-name, .item-type, .item-price, .item-bid {\n" +
            " font-size: 20px;\n" +
            " color: #333;\n" +
            "}\n" +
            ".item-image {\n" +
            "            height: 50%;\n" +
            "            width: 30%;\n" +
            "        }\n" +
            ".bid-link {\n" +
            "            text-decoration: none;\n" +
            "            background-color: #e74c3c;\n" +
            "            color: #fff;\n" +
            "            padding: 5px 10px;\n" +
            "            border-radius: 5px;\n" +
            "}\n" +

            "</style>";
    }
}
