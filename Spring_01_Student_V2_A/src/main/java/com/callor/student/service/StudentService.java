package com.callor.student.service;

import com.callor.student.models.StudentVO;

public interface StudentService extends GenericService<StudentVO, String> {

    // 학번을 지정하는?? 가상클래스
    public StudentVO insert();
}
