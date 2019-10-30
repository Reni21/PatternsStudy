package reni.com.task08.chainstage;

import reni.com.task08.entity.Account;
import reni.com.task08.entity.Transaction;
import reni.com.task08.entity.TransactionType;
import reni.com.task08.exception.TransactionStageRejectException;


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
