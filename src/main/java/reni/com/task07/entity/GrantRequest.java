package reni.com.task07.entity;

import reni.com.task07.state.CancelledGrantRequestState;
import reni.com.task07.state.CreatedGrantRequestState;
import reni.com.task07.state.GrantRequestState;
import reni.com.task07.state.RejectedGrantRequestState;

public class GrantRequest {
    private int sum;
    private String purpose;
    private GrantRequestState state = new CreatedGrantRequestState();

    public GrantRequest(int sum, String purpose) {
        this.sum = sum;
        this.purpose = purpose;
    }

    public void setState(GrantRequestState state) {
        this.state = state;
    }

    public GrantRequestState getState() {
        return state;
    }

    public boolean isPaymentAvailable() {
        return state.isPaymentAvailable();
    }

    public void cancelGrantRequest() {
        state = new CancelledGrantRequestState();
    }

    public void rejectGrantRequest() {
        state = new RejectedGrantRequestState();
    }

    public Integer getPayment() {
        if (!isPaymentAvailable()) {
            throw new IllegalStateException("Grant payment is not available in this state: " + state.toString());
        }
        return sum;
    }

    public void moveToNextState() {
        state.moveToNextState(this);
    }
}
