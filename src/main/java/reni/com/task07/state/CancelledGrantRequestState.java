package reni.com.task07.state;

import reni.com.task07.entity.GrantRequest;

public class CancelledGrantRequestState implements GrantRequestState {
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
        return "CANCELED";
    }
}