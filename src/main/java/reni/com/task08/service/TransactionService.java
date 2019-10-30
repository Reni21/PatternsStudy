package reni.com.task08.service;

import reni.com.task08.chainstage.TransactionStage;
import reni.com.task08.entity.PaymentType;
import reni.com.task08.entity.Transaction;
import reni.com.task08.exception.TransactionStageRejectException;

public class TransactionService {

    public void handlePayment(PaymentType paymentType, Transaction transaction) throws TransactionStageRejectException {
        TransactionStage transactionStage = TransactionChainsFactory
                .createTransactionStageChain(paymentType, transaction.getTransactionType());
        transactionStage.runTransactionStage(transaction);
    }
}
