package com.example.twu.repository.storage;

import com.example.twu.entities.CheckoutBook;

import java.util.ArrayList;
import java.util.List;

public class CheckoutBookStorage {
    private static final List<CheckoutBook> CHECKOUT_BOOK = new ArrayList<>();

    public static void clear() {
    }

    public static boolean checkoutBook(Integer bookId, String userId) {
        return CHECKOUT_BOOK.add(new CheckoutBook(userId, bookId));
    }
}
