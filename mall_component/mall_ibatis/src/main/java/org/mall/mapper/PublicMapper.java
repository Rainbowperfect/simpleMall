package org.mall.mapper;

import com.github.abel533.mapper.Mapper;
import org.mall.pojo.User;

import java.util.List;
import java.util.Map;

public interface PublicMapper extends Mapper<User> {

    List<User> getPage(Map<String,Integer> param);
}
