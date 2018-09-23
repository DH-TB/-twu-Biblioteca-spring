package com.example.twu.repository.impl;

import com.example.twu.entities.Menu;
import com.example.twu.repository.MenuRepository;
import com.example.twu.repository.storage.MenuStorage;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRepositoryImpl implements MenuRepository {
    @Override
    public Menu getMenus() {
        return MenuStorage.getMenus();
    }
}
