package com.demo.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@Api(tags = "公共controller")
@RestController
@RequestMapping(value="/common")
public class CommonController {

    private static final String[] COMMON_FILE_URLS = {
            "D:/ResourceOneHome_DA/config/SystemConfig.xml",
            "D:/hxbaudit/config/apache-tomcat-7.0.82/conf/context.xml",
            "D:/hxbaudit/config/apache-tomcat-7.0.82/conf/Catalina/localhost/ROOT.xml"
    };

    @RequestMapping(value = "/changeLocal", method = RequestMethod.GET)
    public String changeLocal() {
        //切换为本地数据库
        for (String s : COMMON_FILE_URLS) {
            File file0 = new File(s);
            File file1 = new File(s + ".local");
            if (file0.exists() && file1.exists()) {
                file0.renameTo(new File(s + ".company"));
                file1.renameTo(new File(s));
            }
        }
        return JSON.toJSONString("已经切换为本地数据库配置");
    }

    @RequestMapping(value = "/changeFar", method = RequestMethod.GET)
    public String changeFar() {
        for (String s : COMMON_FILE_URLS) {
            File file0 = new File(s);
            File file1 = new File(s + ".company");
            if (file0.exists() && file1.exists()) {
                file0.renameTo(new File(s + ".local"));
                file1.renameTo(new File(s));
            }
        }
        return JSON.toJSONString("已经切换为服务器数据库配置");
    }

}
