package com.tianhe.foreach.serviceImpl;

import com.tianhe.foreach.entity.test;
import com.tianhe.foreach.mapper.sun.testMapper;
import com.tianhe.foreach.mapper.xu.xutestMapper;
import com.tianhe.foreach.service.testService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class testServiceImpl implements testService {
    @Resource
    testMapper testMapper;
    @Resource
    xutestMapper xtestMapper;
    @Override
    public List<test> queryall() {
        List<test> queryall = testMapper.queryall();
        return queryall;
    }

    @Override
    public List<test> queryxu() {
        List<test> queryall = xtestMapper.queryall();
        return queryall;
    }


}
