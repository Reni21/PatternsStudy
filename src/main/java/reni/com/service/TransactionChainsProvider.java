package reni.com.service;

import reni.com.chainstage.*;
import reni.com.entity.TransactionType;

public class TransactionChainsProvider {

    // Simple Payment chain
    public static TransactionStage buildWithdrawTypeTransactionChainForSimplePayment(TransactionType transactionType) {
        TransactionStage transactionStage1 = new BalanceValidationStage(transactionType);
        TransactionStage transactionStage2 = new MainWithdrawOperationStage(transactionType);
        TransactionStage transactionStage3 = new TaxWithdrawStage(transactionType);
        TransactionStage transactionStage4 = new CashBackDepositStage(transactionType);
        TransactionStage transactionStage5 = new SendEmailReportStage(transactionType);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        transactionStage3.setNextStage(transactionStage4);
        transactionStage4.setNextStage(transactionStage5);
        return transactionStage1;
    }

    // Government Payment chain
    public static TransactionStage buildWithdrawTransactionChainForGovernmentPayment(TransactionType transactionType) {
        TransactionStage transactionStage1 = new BalanceValidationStage(transactionType);
        TransactionStage transactionStage2 = new MainWithdrawOperationStage(transactionType);
        TransactionStage transactionStage3 = new TaxWithdrawStage(transactionType);
        TransactionStage transactionStage4 = new SendEmailReportStage(transactionType);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        transactionStage3.setNextStage(transactionStage4);
        return transactionStage1;
    }

    // Inner Bank Payment chain
    public static TransactionStage buildWithdrawTransactionChainForInnerBankPayment(TransactionType transactionType) {
        TransactionStage transactionStage1 = new BalanceValidationStage(transactionType);
        TransactionStage transactionStage2 = new MainWithdrawOperationStage(transactionType);
        TransactionStage transactionStage3 = new SendEmailReportStage(transactionType);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        return transactionStage1;
    }

    // Preferential Payment chain
    public static TransactionStage buildWithdrawTransactionChainForPreferentialPayment(TransactionType transactionType) {
        return buildDepositTypeTransactionChainForInnerBankPayment(transactionType);
    }

    // Simple Payment chain
    public static TransactionStage buildDepositTypeTransactionChainForSimplePayment(TransactionType transactionType) {
        TransactionStage transactionStage1 = new MainDepositOperationStage(transactionType);
        TransactionStage transactionStage2 = new SendEmailReportStage(transactionType);

        transactionStage1.setNextStage(transactionStage2);
        return transactionStage1;
    }

    // Government Payment chain
    public static TransactionStage buildDepositTypeTransactionChainForGovernmentPayment(TransactionType transactionType) {
        TransactionStage transactionStage1 = new MainDepositOperationStage(transactionType);
        TransactionStage transactionStage2 = new TaxWithdrawStage(transactionType);
        TransactionStage transactionStage3 = new SendEmailReportStage(transactionType);

        transactionStage1.setNextStage(transactionStage2);
        transactionStage2.setNextStage(transactionStage3);
        return transactionStage1;    }

    // Inner Bank Payment chain
    public static TransactionStage buildDepositTypeTransactionChainForInnerBankPayment(TransactionType transactionType) {
        return buildDepositTypeTransactionChainForSimplePayment(transactionType);
    }

    // Preferential Payment chain
    public static TransactionStage buildDepositTypeTransactionChainForPreferentialPayment(TransactionType transactionType) {
        return buildDepositTypeTransactionChainForSimplePayment(transactionType);
    }

}
