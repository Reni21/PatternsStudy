package reni.com.chainofresponsibility.chainstage;


import reni.com.chainofresponsibility.entity.Account;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.entity.TransactionType;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;


public class SendEmailReportStage extends TransactionStage {

    public SendEmailReportStage(TransactionType transactionType) {
        super(transactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Send email stage execute...");
        Account account = transaction.getAccount();
        System.out.format("Send report to email=%s: %s operation was performed on the account %s on amount %d USD.%n",
                account.getUserEmail(),
                transaction.getTransactionType(),
                account.getNumber(),
                transaction.getAmount());

        executeNextStage(transaction);
    }
}
