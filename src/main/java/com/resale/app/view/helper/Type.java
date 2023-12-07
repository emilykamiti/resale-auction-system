// package com.resale.app.view.helper;

// import java.util.ArrayList;
// import java.util.List;
// import com.resale.app.bean.ItemBean;
// import com.resale.app.bean.ItemBeanI;
// import com.resale.app.model.entity.Item;
// import com.resale.app.model.entity.ItemType;


// public class Type {
//     static ItemBeanI itemBean = new ItemBean();
//     static List<Item> items = itemBean.list(Item.class);

//     public static String showType(List<? extends Object> models) { 
//         List<Item> homeAccessories = new ArrayList<>();
//         List<Item> luxury = new ArrayList<>();
//         List<Item> furniture = new ArrayList<>();
//         List<Item> cars = new ArrayList<>();

//         for (Item item : items) {
//             ItemType type = item.getType(); 

//             if (type.equals(ItemType.HOME_ACCESSORIES)) {
//                 homeAccessories.add(item);
//             } else if (type.equals(ItemType.LUXURY)) {
//                 luxury.add(item);
//             } else if (type.equals(ItemType.FURNITURE)) {
//                 furniture.add(item);
//             } else if (type.equals(ItemType.CARS)) {
//                 cars.add(item);
//             }
            
//         }

//         StringBuilder categoryDiv = new StringBuilder();
//         categoryDiv.append("<div>");

//         categoryDiv.append("<div>");
//         categoryDiv.append("<h2 style=\"color: white;\">HOME_ACCESSORIES</h2>");
//         categoryDiv.append(HtmlCards.generateCards(homeAccessories));
//         categoryDiv.append("</div>");

//         categoryDiv.append("<div>");
//         categoryDiv.append("<h2 style=\"color: white;\">LUXURY ITEMS</h2>");
//         categoryDiv.append(HtmlCards.generateCards(luxury));
//         categoryDiv.append("</div>");

//         categoryDiv.append("<div>");
//         categoryDiv.append("<h2 style=\"color: white;\">FURNITURE</h2>");
//         categoryDiv.append(HtmlCards.generateCards(furniture));
//         categoryDiv.append("</div>");

//         categoryDiv.append("<div>");
//         categoryDiv.append("<h2 style=\"color: white;\">CARS</h2>");
//         categoryDiv.append(HtmlCards.generateCards(cars));
//         categoryDiv.append("</div>");

//         categoryDiv.append("</div>");

//         return categoryDiv.toString();
//     }
// }
