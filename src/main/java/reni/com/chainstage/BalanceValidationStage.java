package reni.com.chainstage;

import reni.com.entity.Account;
import reni.com.entity.Transaction;
import reni.com.entity.TransactionType;
import reni.com.exception.TransactionStageRejectException;


public class BalanceValidationStage extends TransactionStage {

    public BalanceValidationStage(TransactionType transactionType) {
        super(transactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Balance validation stage execute...");
        Account account = transaction.getAccount();
        validateNotNull(account, "Account");

        long balance = account.getBalance();
        long amount = transaction.getAmount();
        if(balance < amount ) {
            throw new TransactionStageRejectException("Not enough money in account: " + account.getNumber());
        } else {
            executeNextStage(transaction);
        }
    }
}
