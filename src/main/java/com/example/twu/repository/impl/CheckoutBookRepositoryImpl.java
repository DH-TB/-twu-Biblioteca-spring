package com.example.twu.repository.impl;

import com.example.twu.repository.CheckoutBookRepository;
import com.example.twu.repository.storage.CheckoutBookStorage;
import org.springframework.stereotype.Repository;

@Repository
public class CheckoutBookRepositoryImpl implements CheckoutBookRepository {

    @Override
    public boolean checkoutBook(Integer bookId, String userId) {
        return CheckoutBookStorage.checkoutBook(bookId, userId);
    }
}
