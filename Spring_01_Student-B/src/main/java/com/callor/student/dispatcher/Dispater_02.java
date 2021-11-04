package com.callor.student.dispatcher;

import com.callor.student.controller.StController2;
import com.callor.student.service.StService;
import com.callor.student.service.impl.StService1;

public class Dispater_02 {

    // service 1을 쓸지 2를 쓸지 dispater가 선택할 수 있다.
    public static void main(String[] args) {
        StController2 stCon = new StController2();
        StService stService = new StService1(); // 여기서 1 -> 2로 변경하면 됨
        stCon.setStService(stService);
        stCon.list();
    }
}
