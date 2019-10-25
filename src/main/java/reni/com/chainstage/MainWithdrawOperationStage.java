package reni.com.chainstage;

import reni.com.entity.Account;
import reni.com.entity.Transaction;
import reni.com.entity.TransactionType;
import reni.com.exception.TransactionStageRejectException;


public class MainWithdrawOperationStage extends TransactionStage {

    public MainWithdrawOperationStage(TransactionType supportedTransactionType) {
        super(supportedTransactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Main withdraw operation stage execute...");
        Account account = transaction.getAccount();
        validateNotNull(account, "Account");

        long balance = account.getBalance();
        long transactionAmount = transaction.getAmount();
        if(balance < transactionAmount ) {
            throw new TransactionStageRejectException("Not enough money in account: " + account.getNumber());
        }
        account.setBalance(balance - transactionAmount);

        executeNextStage(transaction);
    }
}
