package com.demo.service;


import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface CountService {

    /**
     * 分页查询账单列表
     */
    PageInfo queryPage(String startDate, String endDate, int currentPage, int pageSize);

}
