package reni.com.chainstage;

import reni.com.entity.Account;
import reni.com.entity.Transaction;
import reni.com.entity.TransactionType;
import reni.com.exception.TransactionStageRejectException;


public class CashBackDepositStage extends TransactionStage {

    public CashBackDepositStage(TransactionType transactionType) {
        super(transactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Deposit cash back stage execute...");
        Account account = transaction.getAccount();
        validateNotNull(account, "Account");

        long cashBackPercent = account.getCashBackPercent();
        if (cashBackPercent > 0) {
            long cashBackAmount = transaction.getAmount() / 100 * cashBackPercent;
            account.setCashBakBalance(cashBackAmount);
            System.out.println("Accrued cash back: " + cashBackAmount + " USD");
        }
        executeNextStage(transaction);
    }
}
