package com.ohgiraffers.crud.menu.model.dao;


import com.ohgiraffers.crud.configuration.CrudApplication;
import com.ohgiraffers.crud.menu.model.dto.CarDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {CrudApplication.class})
public class CarMapperTests {

    @Autowired
    private CarMapper carMapper;

    @Test
    public void 매퍼_인터페이스_의존성_주입_테스트() {
        assertNotNull(carMapper);
    }

    @Test
    public void 전체_메뉴_조회_매퍼_테스트() {
        // given
        // when
        List<CarDTO> carList = carMapper.findAllCar();
        // then
        assertNotNull(carList);
    }

    @Test
    @DisplayName("신규 메뉴가 잘 추가 되는지 매퍼 인터페이스의 메소드 확인")
    @Transactional // -> 테스트 코드로 수행한 작업을 테스트 완료 후 rollback 하여 DB에 남기지 않음
    public void testRegistCar() {
        // given
        CarDTO car = new CarDTO();
        car.setCarCompany("테스트현대");
        car.setCarName("현대동차프라이드");
        car.setCarNumber("테스트11더1111");


        // when & then
        assertDoesNotThrow(() -> carMapper.registCar(car));
    }

    @Test
    @DisplayName("신규 메뉴 추가 실패 테스트")
    public void testRegistCar2() {
        // given
        CarDTO car = new CarDTO();
        car.setCarCompany("테스트현대");
        car.setCarName("현대동차프라이드");


        // when & then
        assertThrows(Exception.class, () -> carMapper.registCar(car));
    }
}
