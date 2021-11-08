package com.callor.student.service.impl;

import com.callor.student.models.StudentVO;
import com.callor.student.repository.StudentDao;
import com.callor.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stSErviceV1")
public class StudentServiceImplV1 implements StudentService {

    private final StudentDao stDao;

    // alt + insert 로 생성자 클래스 만들기

    /**
     * 생성자 주입으로 StudentDao 를 wiring 하기
     * 메모리 누수 방지
     * 혹시나 발생할 수 있는 NullPointException을 아예 방지할 수 있다.
     */
    public StudentServiceImplV1(StudentDao stDao) {
        this.stDao = stDao;
    }

    @Override
    public List<StudentVO> selectAll() {
        return stDao.findAll();
    }

    @Override
    public StudentVO findById(String st_num) {

        /**
         * findById 는 Optional type으로 데이터가 추출되므로
         * get() method를 한번 통과해 주어야 한다.
         */
        return stDao.findById(st_num).get();
    }

    @Override
    public void insert(StudentVO stVO) {
        stDao.save(stVO);
    }

    @Override
    public void update(StudentVO stVO) {
        stDao.save(stVO);
    }

    @Override
    public void delete(String st_num) {
        stDao.deleteById(st_num);
    }

    // 따로 추가한 매개변수 없는 insert

    /**
     * 학생정보를 추가(새로 등록) 할 때
     * 학번을 자동으로 생성하여 학생 model 객체를 생성한 후
     * Controller 에서 write.jsp 로 보내기
     */
    @Override
    public StudentVO insert() {

        StudentVO stVO = StudentVO.builder()
                .st_num("20210001")
                .build();

        return stVO;
    }
}
