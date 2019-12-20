package reni.com.chainofresponsibility.service;

import reni.com.chainofresponsibility.chainstage.*;
import reni.com.chainofresponsibility.entity.PaymentType;
import reni.com.chainofresponsibility.entity.TransactionType;

public class TransactionChainsFactory {

    public static TransactionStage createTransactionStageChain(PaymentType paymentType, TransactionType transactionType) {
        TransactionStage transactionStage;
        switch (paymentType) {
            case SIMPLE:
                transactionStage = createTransactionChainForSimplePayment(transactionType);
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
        return transactionStage;
    }

    private static TransactionStage createTransactionChainForSimplePayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsFactory.createDepositTypeTransactionChainForSimplePayment();
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsFactory.createWithdrawTransactionChainForSimplePayment();
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    private static TransactionStage createTransactionChainForGovernmentPayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsFactory.createDepositTransactionChainForGovernmentPayment();
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsFactory.createWithdrawTransactionChainForGovernmentPayment();
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    private static TransactionStage createTransactionChainForInnerBankPayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsFactory.createDepositTransactionChainForInnerBankPayment();
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsFactory.createWithdrawTransactionChainForInnerBankPayment();
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    private static TransactionStage createTransactionChainForPreferentialPayment(TransactionType transactionType) {
        if (transactionType.equals(TransactionType.DEPOSIT)) {
            return TransactionChainsFactory.createDepositTransactionChainForPreferentialPayment();
        }
        if (transactionType.equals(TransactionType.WITHDRAW)) {
            return TransactionChainsFactory.createWithdrawTransactionChainForPreferentialPayment();
        }
        throw new IllegalArgumentException("Incorrect transaction type: " + transactionType);
    }

    // Simple Payment chain
    private static TransactionStage createWithdrawTransactionChainForSimplePayment() {
        TransactionType withdraw = TransactionType.WITHDRAW;
        TransactionStage transactionStage1 = new BalanceValidationStage(withdraw);
        TransactionStage transactionStage2 = new MainWithdrawOperationStage(withdraw);
        TransactionStage transactionStage3 = new TaxWithdrawStage(withdraw);
        TransactionStage transactionStage4 = new CashBackDepositStage(withdraw);
        TransactionStage transactionStage5 = new SendEmailReportStage(withdraw);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        transactionStage3.setNextStage(transactionStage4);
        transactionStage4.setNextStage(transactionStage5);
        return transactionStage1;
    }

    // Government Payment chain
    private static TransactionStage createWithdrawTransactionChainForGovernmentPayment() {
        TransactionType withdraw = TransactionType.WITHDRAW;
        TransactionStage transactionStage1 = new BalanceValidationStage(withdraw);
        TransactionStage transactionStage2 = new MainWithdrawOperationStage(withdraw);
        TransactionStage transactionStage3 = new TaxWithdrawStage(withdraw);
        TransactionStage transactionStage4 = new SendEmailReportStage(withdraw);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        transactionStage3.setNextStage(transactionStage4);
        return transactionStage1;
    }

    // Inner Bank Payment chain
    private static TransactionStage createWithdrawTransactionChainForInnerBankPayment() {
        TransactionType withdraw = TransactionType.WITHDRAW;
        TransactionStage transactionStage1 = new BalanceValidationStage(withdraw);
        TransactionStage transactionStage2 = new MainWithdrawOperationStage(withdraw);
        TransactionStage transactionStage3 = new SendEmailReportStage(withdraw);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        return transactionStage1;
    }

    // Preferential Payment chain
    private static TransactionStage createWithdrawTransactionChainForPreferentialPayment() {
        return createDepositTransactionChainForInnerBankPayment();
    }

    // Simple Payment chain
    private static TransactionStage createDepositTypeTransactionChainForSimplePayment() {
        TransactionType deposit = TransactionType.DEPOSIT;
        TransactionStage transactionStage1 = new MainDepositOperationStage(deposit);
        TransactionStage transactionStage2 = new SendEmailReportStage(deposit);

        transactionStage1.setNextStage(transactionStage2);
        return transactionStage1;
    }

    // Government Payment chain
    private static TransactionStage createDepositTransactionChainForGovernmentPayment() {
        TransactionType deposit = TransactionType.DEPOSIT;
        TransactionStage transactionStage1 = new MainDepositOperationStage(deposit);
        TransactionStage transactionStage2 = new TaxWithdrawStage(deposit);
        TransactionStage transactionStage3 = new SendEmailReportStage(deposit);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        return transactionStage1;
    }

    // Inner Bank Payment chain
    private static TransactionStage createDepositTransactionChainForInnerBankPayment() {
        return createDepositTypeTransactionChainForSimplePayment();
    }

    // Preferential Payment chain
    private static TransactionStage createDepositTransactionChainForPreferentialPayment() {
        return createDepositTypeTransactionChainForSimplePayment();
    }

}
