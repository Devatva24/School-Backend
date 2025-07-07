package com.alibou.example1;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}
