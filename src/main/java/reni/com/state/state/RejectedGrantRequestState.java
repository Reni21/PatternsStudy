package reni.com.state.state;

import reni.com.state.entity.GrantRequest;

public class RejectedGrantRequestState implements GrantRequestState {
    @Override
    public boolean isPaymentAvailable() {
        return false;
    }

    @Override
    public void moveToNextState(GrantRequest grantRequest) {
        throw new UnsupportedOperationException("Your grant request is inactive in state: " + this.toString());
    }

    @Override
    public String toString() {
        return "REJECTED";
    }
}
