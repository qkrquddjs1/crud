package com.ohgiraffers.crud.menu.model.service;

import com.ohgiraffers.crud.menu.model.dao.MenuMapper;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* 클래스 레벨에 설정하는 것도 가능하며 해당 클래스의 메소드에 전체 적용 or value 설정 메소드에 적용 */
//@Transactional(value = "")
@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }


    /* 읽기 전용 트랜잭션 설정 가능 -> 성능 최적화 */
    @Transactional(readOnly = true)
    public List<CategoryDTO> findCategoryList() {
        return menuMapper.findCategoryList();
    }

    /* 메소드 내에서 하나의 트랜잭션으로 여러 처리들이 진행 되고 수행 중 Exception 발생 시 rollback
    * 정상 수행 완료 시 commit 처리 */
    @Transactional
    public void registMenu(MenuDTO menu) {
        menuMapper.registMenu(menu);
    }
}
