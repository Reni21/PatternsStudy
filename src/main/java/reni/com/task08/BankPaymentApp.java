package reni.com.task08;

import lombok.AllArgsConstructor;
import reni.com.task08.entity.*;
import reni.com.task08.exception.TransactionStageRejectException;
import reni.com.task08.service.TransactionService;

@AllArgsConstructor
public class BankPaymentApp {
    private TransactionService transactionService;

    public static void main(String[] args) {
        try {
            new BankPaymentApp(new TransactionService()).runDemoBankPaymentApp();
        } catch (TransactionStageRejectException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void runDemoBankPaymentApp() throws TransactionStageRejectException {
        Account account1 = new Account(Bank.NATIONAL_BANK, "1111 1111", "user-one@gmail.com");
        account1.setBalance(1000);
        account1.setCashBackPercent(10);
        Account account2 = new Account(Bank.OTP, "2222 2222", "user-two@gmail.com");

        Transaction transaction1 = new Transaction(TransactionType.WITHDRAW, account1, 500);
        transaction1.setTax(3);
        Transaction transaction2 = new Transaction(TransactionType.DEPOSIT, account2, 500);

        transactionService.handlePayment(PaymentType.SIMPLE, transaction1);
        System.out.println("===========================================================================================================");
        transactionService.handlePayment(PaymentType.INNER_BANK, transaction2);
        System.out.println("===========================================================================================================");

        System.out.println(account1);
        System.out.println(account2);
    }
}
