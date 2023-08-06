package com.icodeap.apirest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "account")
public class Account {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "amount", nullable = false,length = 10, precision = 2)
    @Check(constraints = "amount >= 0")
    @Getter
    @Setter
    private double amount;

    @Column(name = "terms", nullable = false)
    @Check(constraints = "terms >= 4")
    @Getter
    @Setter
    private Integer terms;

    @Column(name = "rate",nullable = false, length = 10, precision = 2)
    @Check(constraints = "rate >= 0 AND rate <= 100")
    @Getter
    @Setter
    private double rate;

    // Add a one-to-many relationship to payments
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter
    @Setter
    private List<Payment> payments = new ArrayList<>();

    public Account() {

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", amount=" + amount +
                ", terms=" + terms +
                ", rate=" + rate +
                '}';
    }
}
