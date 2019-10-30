package reni.com.task08.chainstage;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import reni.com.task08.entity.Transaction;
import reni.com.task08.entity.TransactionType;
import reni.com.task08.exception.TransactionStageRejectException;

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
