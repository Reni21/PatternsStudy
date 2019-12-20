package reni.com.chainofresponsibility.chainstage;

import reni.com.chainofresponsibility.entity.Account;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.entity.TransactionType;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;


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
