package reni.com.service;

import reni.com.chainstage.*;
import reni.com.entity.PaymentType;
import reni.com.entity.Transaction;
import reni.com.entity.TransactionType;
import reni.com.exception.TransactionStageRejectException;

public class TransactionService {

    public void handlePayment(PaymentType paymentType, Transaction transaction) throws TransactionStageRejectException {
        checkNotNull(transaction, "Transaction");
        TransactionType transactionType = transaction.getTransactionType();
        checkNotNull(transactionType, "Transaction type");

        TransactionStage transactionStage = null;
        switch (paymentType) {
            case SIMPLE:
                transactionStage = buildTransactionChainForSimplePayment(transactionType);
                break;
            case GOVERNMENT:
                transactionStage = createTransactionChainForGovernmentPayment(transactionType);
                break;
            case INNER_BANK:
                transactionStage = createTransactionChainForInnerBankPayment(transactionType);
                break;
            case PREFERENTIAL:
                transactionStage = createTransactionChainForPreferentialPayment(transactionType);
                break;
            default:
                throw new IllegalArgumentException("Incorrect payment type: " + paymentType);
        }

        if (transactionStage != null) {
            transactionStage.runTransactionStage(transaction);
        }
    }

    private TransactionStage buildTransactionChainForSimplePayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsProvider.buildDepositTypeTransactionChainForSimplePayment(transactionType);
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsProvider.buildWithdrawTypeTransactionChainForSimplePayment(transactionType);
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    private TransactionStage createTransactionChainForGovernmentPayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsProvider.buildDepositTypeTransactionChainForGovernmentPayment(transactionType);
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsProvider.buildWithdrawTransactionChainForGovernmentPayment(transactionType);
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    private TransactionStage createTransactionChainForInnerBankPayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsProvider.buildDepositTypeTransactionChainForInnerBankPayment(transactionType);
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsProvider.buildWithdrawTransactionChainForInnerBankPayment(transactionType);
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    private TransactionStage createTransactionChainForPreferentialPayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsProvider.buildDepositTypeTransactionChainForPreferentialPayment(transactionType);
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsProvider.buildWithdrawTransactionChainForPreferentialPayment(transactionType);
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    private void checkNotNull(Object object, String objectName) {
        if (object == null) {
            throw new IllegalArgumentException(objectName + " is null.");
        }
    }


}
