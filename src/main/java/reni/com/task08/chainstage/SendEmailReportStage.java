package reni.com.task08.chainstage;


import reni.com.task08.entity.Account;
import reni.com.task08.entity.Transaction;
import reni.com.task08.entity.TransactionType;
import reni.com.task08.exception.TransactionStageRejectException;


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
