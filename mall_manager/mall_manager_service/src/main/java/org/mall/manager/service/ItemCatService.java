package org.mall.manager.service;

import org.mall.pojo.ItemCat;

import java.util.List;

public interface ItemCatService {
    List<ItemCat> getItemCatByPage(Integer pages,Integer rows);
}
