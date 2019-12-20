package reni.com.chainofresponsibility.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Transaction {
    @NonNull
    private TransactionType transactionType;
    @NonNull
    private Account account;
    @NonNull
    private long amount;

    @Setter
    private int tax;

}
