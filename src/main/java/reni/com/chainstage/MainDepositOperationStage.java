package reni.com.chainstage;

import reni.com.entity.Account;
import reni.com.entity.Transaction;
import reni.com.entity.TransactionType;
import reni.com.exception.TransactionStageRejectException;


public class MainDepositOperationStage extends TransactionStage {

    public MainDepositOperationStage(TransactionType supportedTransactionType) {
        super(supportedTransactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Main deposit operation stage execute...");
        Account account = transaction.getAccount();
        validateNotNull(account, "Account");

        long newBalance = account.getBalance() + transaction.getAmount();
        account.setBalance(newBalance);
        executeNextStage(transaction);
    }
}
