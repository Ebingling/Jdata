package com.demo.service.impl;

import com.demo.common.util.DateUtil;
import com.demo.entity.Count;
import com.demo.mapper.CountMapper;
import com.demo.service.CountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CountServiceImpl implements CountService {

    @Resource
    private CountMapper countMapper;

    @Override
    public PageInfo queryPage(String startDate, String endDate, int currentPage, int pageSize) {
        //1.解析查询参数
        startDate = startDate != null ? startDate :
                DateUtil.dateToStr(DateUtil.strToDate(DateUtil.getFirstDayOfTargetMonth()), DateUtil.DATE_PATTERN);
        endDate = endDate != null ? endDate :
                DateUtil.dateToStr(DateUtil.strToDate(DateUtil.getLastDayOfTargetMonth()), DateUtil.DATE_PATTERN);
        //2.分页查询
        Example example = new Example(Count.class);
        if(StringUtils.isNotBlank(startDate) && StringUtils.isNotBlank(endDate)) {
            example.createCriteria().andBetween("createTime", startDate, endDate);
        }
        PageHelper.startPage(currentPage, pageSize);
        List<Count> countList = countMapper.selectByExample(example);
        //3.返回结果
        return new PageInfo<>(countList);
    }


}
