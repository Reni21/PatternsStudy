package reni.com.chainofresponsibility.chainstage;

import reni.com.chainofresponsibility.entity.Account;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.entity.TransactionType;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;


public class MainDepositOperationStage extends TransactionStage {

    public MainDepositOperationStage(TransactionType supportedTransactionType) {
        super(supportedTransactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Main deposit operation stage execute...");
        Account account = transaction.getAccount();
        long newBalance = account.getBalance() + transaction.getAmount();
        account.setBalance(newBalance);
        executeNextStage(transaction);
    }
}
