package reni.com.chainofresponsibility.entity;

import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
public class Account {
    @NonNull
    private Bank bank;
    @NonNull
    private String number;
    @NonNull
    private String userEmail;

    @Setter
    private int cashBackPercent = 0;
    @Setter
    private long balance = 0;
    @Setter
    private long cashBakBalance = 0;

}
