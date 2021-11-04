package com.callor.student.controller;

import com.callor.student.model.StudentVO;
import com.callor.student.service.StService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j // log를 쓰기위해서
public class StController2 {

    // 인터페이스로 선언만 하기
//    @Autowired // 붙여놓으면 아래  18번줄 코드가 spring이 자동생성하여 외부에서 주입한다.
    private StService stService;

    // setter()를 통해서 객체를 주입받도록 하기
    public void setStService(StService stService){
        this.stService = stService;
    }

    public void list() {
        List<StudentVO> stList = stService.selectAll();
        for(StudentVO vo : stList){
            log.debug(vo.toString());
        }

    }
}
