package com.tianhe.foreach.service;

import com.tianhe.foreach.entity.test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface testService {
    List<test> queryall();
    List<test> queryxu();
}
