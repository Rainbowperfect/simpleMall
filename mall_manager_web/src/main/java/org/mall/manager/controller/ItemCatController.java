package org.mall.manager.controller;

import org.mall.pojo.ItemCat;
import org.mall.manager.service.ItemCatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    private Logger logger=LoggerFactory.getLogger(ItemCatController.class);

    @RequestMapping("/query/{pages}")
    @ResponseBody
    public List<ItemCat> getPages(@PathVariable ("pages")Integer pages,Integer rows){

        List<ItemCat> list = itemCatService.getItemCatByPage(pages, rows);

        if (list.size()==0){
            logger.error("没有查询到===");
        }
        return list;
    }
}
