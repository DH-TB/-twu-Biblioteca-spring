package com.example.twu.demo.repository.impl;

import com.example.twu.demo.entities.Menu;
import com.example.twu.demo.repository.MenuRepository;
import com.example.twu.demo.repository.storage.MenuStorage;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    @Override
    public Menu getMenus() {
        return MenuStorage.getMenus();
    }
}
