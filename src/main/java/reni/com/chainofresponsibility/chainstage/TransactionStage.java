package reni.com.chainofresponsibility.chainstage;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import reni.com.chainofresponsibility.entity.Transaction;
import reni.com.chainofresponsibility.entity.TransactionType;
import reni.com.chainofresponsibility.exception.TransactionStageRejectException;

@RequiredArgsConstructor
@Getter
public abstract class TransactionStage {
    @NonNull
    private TransactionType supportedTransactionType;
    @Setter
    private TransactionStage nextStage;

    public void runTransactionStage(Transaction transaction) throws TransactionStageRejectException {
        validateTransaction(transaction);
        if (this.supportedTransactionType.equals(transaction.getTransactionType())) {
            executeStage(transaction);
        }
    }

    void executeNextStage(Transaction transaction) throws TransactionStageRejectException {
        if (nextStage != null) {
            nextStage.runTransactionStage(transaction);
        }
    }

    protected abstract void executeStage(Transaction transaction) throws TransactionStageRejectException;

    private void validateTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction must be provided");
        }
        if (transaction.getAccount() == null) {
            throw new IllegalArgumentException("Account must be provided");
        }
    }
}
