package reni.com.chainofresponsibility.chainstage;

import reni.com.chainofresponsibility.entity.Account;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.entity.TransactionType;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;


public class MainWithdrawOperationStage extends TransactionStage {

    public MainWithdrawOperationStage(TransactionType supportedTransactionType) {
        super(supportedTransactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Main withdraw operation stage execute...");
        Account account = transaction.getAccount();

        long balance = account.getBalance();
        long transactionAmount = transaction.getAmount();
        if (balance < transactionAmount) {
            throw new TransactionStageRejectException("Not enough money in account: " + account.getNumber());
        }
        account.setBalance(balance - transactionAmount);

        executeNextStage(transaction);
    }
}
