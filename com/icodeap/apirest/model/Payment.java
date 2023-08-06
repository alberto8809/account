package com.icodeap.apirest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @Setter
    private Account account;

    @Column(name = "payment_number", nullable = false)
    @Getter
    @Setter
    private int paymentNumber;

    @Column(nullable = false,length = 10, precision = 2)
    @Getter
    @Setter
    private double amount;

    @Column(name = "payment_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date paymentDate;


    public Payment(int id, int paymentNumber, double amount, Date paymentDate) {
        this.id = id;
        this.paymentNumber = paymentNumber;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Payment() {

    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentNumber=" + paymentNumber +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
