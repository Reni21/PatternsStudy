package reni.com.chainstage;


import reni.com.entity.Account;
import reni.com.entity.Transaction;
import reni.com.entity.TransactionType;
import reni.com.exception.TransactionStageRejectException;


public class SendEmailReportStage extends TransactionStage {

    public SendEmailReportStage(TransactionType transactionType) {
        super(transactionType);
    }

    @Override
    protected void executeStage(Transaction transaction) throws TransactionStageRejectException {
        System.out.println("Send email stage execute...");
        Account account = transaction.getAccount();
        validateNotNull(account, "Account");

        String userEmail = account.getUserEmail();
        validateNotEmpty(userEmail, "User Email", account.getNumber());
        System.out.format("Send report to email=%s: %s operation was performed on the account %s on amount %d USD.%n",
                account.getUserEmail(),
                transaction.getTransactionType(),
                account.getNumber(),
                transaction.getAmount());

        executeNextStage(transaction);
    }
}
