package com.callor.student.service.impl;

import com.callor.student.repository.StDaoImpl;
import com.callor.student.model.StudentVO;
import com.callor.student.repository.StDao;
import com.callor.student.service.StService;

import java.util.Collections;
import java.util.List;

/**
 * StDao 형 객체를 생성하고 인스턴스가 만들어 지는 순간
 * StDao, StDaoImpl, StService 는 상당히 끈끈한 관계가 이루어 진다.
 * 결합이 발생한다.
 *
 * StDaoImpl 클래스의 변화(변경, 업데이트)가 발생하면
 * StService 에게 영향을 미치게 된다.
 *
 * 아래의 stDao 객체는 StService와의 결합도를 고민해야 한다.
 *      1번 코드는 StDaoImpl 클래스로 선언하고 클래스로 직접 객체를 생성
 *      2번 코드는 StDao 인터페이스로 선언하고 클래스로 간접 객체를 생성
 *
 * 이 코드에서 1번 코드는 2번 코드보다 결합도가 높다.
 *      1번 코드처럼 사용하면. DaoImpl을 개발하던 개발자가 method를 변경하면
 *
 *
 * Sub 로 작성된 클래스 모듈을 반드시 인터페이스를 생성하여
 * 결합도를 낮추는 작업이 필요.
 */
public class StService1 implements StService {

    // interface 로 선언하고 상속받은 class로 초기화(생성)하기
    //      StDaoImpl 클래스를 사용하여 StDao 형(type)의 stDao 객체 생성
    //      클래스의 생성자를 호출하여 객체를 생성하면
    //      이 객체는 StDao 형 인스턴스가 된다.
    //      이와같은 흐름을 객체의 lifecycle 라고도 한다.
    private StDaoImpl stDao1 = new StDaoImpl(); // 1번코드 : interface를 거치지않고 바로 생성
    private StDao stDao2 = new StDaoImpl(); // 2번코드

    public List<StudentVO> selectAll() {
        List<StudentVO> stList1 = stDao1.selectAll();
        stList1 = stDao1.findAll(); // selectAll말고 findAll을 써달라고 하면

        List<StudentVO> stList2 = stDao2.selectAll();
        // stList2 = stDao2.findAll(); // findAll은 interface에 없어서 오류남

        Collections.shuffle(stList2);
        return stList2;
    }
}
