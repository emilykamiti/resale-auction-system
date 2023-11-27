package com.resale.utils;

import org.apache.commons.beanutils.ConvertUtils;
import com.resale.app.model.entity.ItemType;


public class EnumConverter {
    public static void registerEnumConverters() {
        ConvertUtils.register(new ItemTypeConverter(), ItemType.class);
    }
}
