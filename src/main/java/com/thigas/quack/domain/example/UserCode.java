package com.thigas.quack.domain.example;

public class UserCode {
    public int calculate(int n1, int n2) {
        int sum = 0;
        for (int i = n1; i <= n2; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}
