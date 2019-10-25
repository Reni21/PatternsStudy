package reni.com.chainstage;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import reni.com.entity.Transaction;
import reni.com.entity.TransactionType;
import reni.com.exception.TransactionStageRejectException;

@RequiredArgsConstructor
@Getter
public abstract class TransactionStage {
    @NonNull
    private TransactionType supportedTransactionType;
    @Setter
    private TransactionStage nextStage;

    public void runTransactionStage(Transaction transaction) throws TransactionStageRejectException {
        validateNotNull(transaction, "Transaction");
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

    void validateNotEmpty(String field, String fieldName, String accountNumber) {
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException(
                    "Exception in account: " + accountNumber +
                    "Required field is absent or equals null: " + fieldName
            );
        }
    }

    void validateNotNull(Object field, String fieldName) {
        if (field == null) {
            throw new IllegalArgumentException("Required field equals null: " + fieldName);
        }
    }

}
