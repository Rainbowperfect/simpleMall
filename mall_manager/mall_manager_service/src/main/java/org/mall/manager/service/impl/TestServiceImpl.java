package org.mall.manager.service.impl;

import org.mall.manager.mapper.TestMapper;
import org.mall.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl  implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public String queryData() {
        return testMapper.queryData();
    }
}
