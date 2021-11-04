package com.callor.student.service.impl;

import com.callor.student.model.StudentVO;
import com.callor.student.repository.StDao;
import com.callor.student.repository.StDaoImpl;
import com.callor.student.service.StService;

import java.util.Collections;
import java.util.List;

public class StService2 implements StService {

    private StDao stDao2 = new StDaoImpl();

    public List<StudentVO> selectAll() {
        List<StudentVO> stList2 = stDao2.selectAll();
        return stList2;
    }
}
