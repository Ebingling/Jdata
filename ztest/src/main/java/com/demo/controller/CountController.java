package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.common.server.WebSocketServer;
import com.demo.entity.Exam;
import com.demo.service.CountService;
import com.demo.service.ExamService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "账单统计")
@RestController
@RequestMapping(value="/count")
public class CountController {

    @Autowired
    private CountService countService;

    @ApiOperation("查看账单统计列表(默认查看当月账单)")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String selectAll(@RequestParam(required = false) String startDate,
                            @RequestParam(required = false) String endDate,
                            @RequestParam(required = false, defaultValue = "1") int currentPage,
                            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageInfo page = countService.queryPage(startDate, endDate, currentPage, pageSize);
        return JSON.toJSONString(page);
    }





}
