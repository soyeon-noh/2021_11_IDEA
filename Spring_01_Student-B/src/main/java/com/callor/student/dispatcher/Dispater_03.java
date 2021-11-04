package com.callor.student.dispatcher;

import com.callor.student.controller.StController3;
import com.callor.student.service.StService;
import com.callor.student.service.impl.StService2;

public class Dispater_03 {

    // 생성자 주입방식
    public static void main(String[] args) {
        StService stService = new StService2();
        StController3 stCon = new StController3(stService);

        stCon.list();
    }
}
