package com.example.twu.repository;

public interface CheckoutBookRepository {
    boolean checkoutBook(Integer bookId, String userId);

}
