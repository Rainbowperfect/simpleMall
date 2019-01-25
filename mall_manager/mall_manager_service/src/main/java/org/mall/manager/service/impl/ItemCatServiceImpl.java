package org.mall.manager.service.impl;

import com.github.pagehelper.PageHelper;
import org.mall.manager.mapper.ItemCatMapper;
import org.mall.manager.service.ItemCatService;
import org.mall.pojo.ItemCat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    private Logger logger=LoggerFactory.getLogger(ItemCatServiceImpl.class);

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> getItemCatByPage(Integer pages, Integer rows) {

        PageHelper.startPage(pages,rows);

        List<ItemCat> list = itemCatMapper.select(null);

        if (list.size()==0){
            logger.error("查询的结果为空");
        }
        return list;
    }
}
