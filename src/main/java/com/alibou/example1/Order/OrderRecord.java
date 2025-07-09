package com.alibou.example1.Order;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
