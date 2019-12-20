package reni.com.chainofresponsibility.chainstage;

import reni.com.chainofresponsibility.entity.Account;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.entity.TransactionType;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;


public class TaxWithdrawStage extends TransactionStage {

    public TaxWithdrawStage(TransactionType supportedTransactionType) {
        super(supportedTransactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Withdraw tax stage execute...");
        long tax = transaction.getTax();
        if (tax > 0) {
            Account account = transaction.getAccount();
            long taxAmount = transaction.getAmount() / 100 * transaction.getTax();
            long balance = account.getBalance();
            if (balance < taxAmount) {
                throw new TransactionStageRejectException("Not enough money in account: " + account.getNumber());
            }
            account.setBalance(balance - taxAmount);
        }
        executeNextStage(transaction);
    }
}
