package reni.com.service;

import reni.com.chainstage.TransactionStage;
import reni.com.entity.PaymentType;
import reni.com.entity.Transaction;
import reni.com.exception.TransactionStageRejectException;

public class TransactionService {

    public void handlePayment(PaymentType paymentType, Transaction transaction) throws TransactionStageRejectException {
        TransactionStage transactionStage = TransactionChainsFactory
                .createTransactionStageChain(paymentType, transaction.getTransactionType());
        transactionStage.runTransactionStage(transaction);
    }
}
