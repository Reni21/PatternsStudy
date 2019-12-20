package reni.com.chainofresponsibility.chainstage;

import reni.com.chainofresponsibility.entity.Account;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.entity.TransactionType;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;


public class BalanceValidationStage extends TransactionStage {

    public BalanceValidationStage(TransactionType transactionType) {
        super(transactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Balance validation stage execute...");
        Account account = transaction.getAccount();

        long balance = account.getBalance();
        long amount = transaction.getAmount();
        if (balance < amount) {
            throw new TransactionStageRejectException("Not enough money in account: " + account.getNumber());
        } else {
            executeNextStage(transaction);
        }
    }
}
