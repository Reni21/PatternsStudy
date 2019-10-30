package reni.com.task08.chainstage;

import reni.com.task08.entity.Account;
import reni.com.task08.entity.Transaction;
import reni.com.task08.entity.TransactionType;
import reni.com.task08.exception.TransactionStageRejectException;


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
