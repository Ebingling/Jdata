package com.demo.service.impl;

import com.demo.entity.Exam;
import com.demo.mapper.ExamMapper;
import com.demo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExamServiceImpl implements ExamService {


    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Exam> selectAll() {
        Example example = new Example(Exam.class);
        example.createCriteria();
        List<Exam> exam = examMapper.selectByExample(example);
        List<Exam> result = new ArrayList<>();
        int count = exam.size();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        while(true){
            int num = random.nextInt(count - 1);
            Exam resultExam = exam.get(num);
            if(list.contains(resultExam.getId())) {
                continue;
            } else {
                result.add(resultExam);
                list.add(resultExam.getId());
            }
             if(list.size() == 5) {
                break;
            }
         }

//        for(int i = 0; i < countList.size(); i++) {
//
//        }

        return result;
    }
}
