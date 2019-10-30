package reni.com.task08.chainstage;

import reni.com.task08.entity.Account;
import reni.com.task08.entity.Transaction;
import reni.com.task08.entity.TransactionType;
import reni.com.task08.exception.TransactionStageRejectException;


public class CashBackDepositStage extends TransactionStage {

    public CashBackDepositStage(TransactionType transactionType) {
        super(transactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Deposit cash back stage execute...");
        Account account = transaction.getAccount();

        long cashBackPercent = account.getCashBackPercent();
        if (cashBackPercent > 0) {
            long cashBackAmount = transaction.getAmount() / 100 * cashBackPercent;
            account.setCashBakBalance(cashBackAmount);
            System.out.println("Accrued cash back: " + cashBackAmount + " USD");
        }
        executeNextStage(transaction);
    }
}
