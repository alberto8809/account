package com.icodeap.apirest.Accounts;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.icodeap.apirest.model.Account;
import com.icodeap.apirest.model.Payment;
import java.util.concurrent.atomic.AtomicInteger;

public final class SimpleInterestCalculator {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    public static Account calculatePayments(Account account) {
        if (account.getId() == 0 ){ account.setId(ID_GENERATOR.getAndIncrement());}
        List<Payment> payments = new ArrayList<>();

        double principal = account.getAmount();
        double rate = account.getRate() / 100.0 / account.getTerms();
        int terms = account.getTerms();

        double weeklyInterest = principal * rate;
        double remainingAmount = principal;

        double weeklyPaymentAmount = principal / terms;

        Date startDate = new Date();

        for (int i = 1; i <= terms; i++) {
            double paymentAmount = i == terms ? remainingAmount : weeklyPaymentAmount;
            remainingAmount -= paymentAmount;

            Payment payment = new Payment(ID_GENERATOR.getAndIncrement(),i, roundToTwoDecimals(paymentAmount),calculatePaymentDate(startDate, i));
            payments.add(payment);
        }
        account.setPayments(payments);
        return account;
    }

    private static Date calculatePaymentDate(Date startDate, int paymentNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.WEEK_OF_YEAR, paymentNumber);
        return calendar.getTime();
    }

    private static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}

