package reni.com.chainofresponsibility.service;

import reni.com.chainofresponsibility.chainstage.TransactionStage;
import reni.com.chainofresponsibility.entity.PaymentType;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;

public class TransactionService {

    public void handlePayment(PaymentType paymentType, Transaction transaction) throws TransactionStageRejectException {
        TransactionStage transactionStage = TransactionChainsFactory
                .createTransactionStageChain(paymentType, transaction.getTransactionType());
        transactionStage.runTransactionStage(transaction);
    }
}
