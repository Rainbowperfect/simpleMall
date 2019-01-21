package org.mall.mapper;

import org.mall.pojo.User;

public interface UserMapper {

    void saveUser(User user);

    void deleteUser(Long  id);

    void updateUser(Long id);

    User queryUserById(Long id);


}
