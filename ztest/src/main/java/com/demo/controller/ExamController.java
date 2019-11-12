package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.common.server.WebSocketServer;
import com.demo.entity.Exam;
import com.demo.service.ExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "特殊功能测试接口")
@RestController
@RequestMapping(value="/examController")
public class ExamController {


    @Autowired
    private ExamService examService;

    @ApiOperation("生成随机测试题：")
    @RequestMapping(value = "/exam")
    public String selectAll(){
        List<Exam> examList = examService.selectAll();
        return JSON.toJSONString(examList);
    }

    @ApiOperation("实时消息推送测试：")
    @RequestMapping(value="/message", method=RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Map<String,Object> pushVideoListToWeb(@RequestBody Map<String,Object> param) {
        Map<String,Object> result =new HashMap<>();
        try {
            WebSocketServer.sendInfo("123");
            result.put("operationResult", true);
        }catch (IOException e) {
            result.put("operationResult", true);
        }
        return result;
    }

    @ApiOperation("消息测试：")
    @RequestMapping(value="/test")
    public String testMessage() {
        System.out.println("触发了一次测试按钮");
        RestTemplate restTemplate = new RestTemplate();
        String rep = restTemplate.getForObject("http://dev.maas.chelaile.net.cn/busmanager/sys/message/test?id=1", String.class);
        return rep;
    }

    @RequestMapping(value="/test1",  method=RequestMethod.GET)
    public String testMessage1(@RequestParam(value = "num") String num) {
        System.out.println("接收参数" + num);
        return JSON.toJSONString("SUCCESS");
    }



}
