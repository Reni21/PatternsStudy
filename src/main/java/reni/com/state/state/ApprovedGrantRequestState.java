package reni.com.state.state;

import reni.com.state.entity.GrantRequest;

public class ApprovedGrantRequestState implements GrantRequestState {
    @Override
    public boolean isPaymentAvailable() {
        return true;
    }

    @Override
    public void moveToNextState(GrantRequest grantRequest) {
        System.out.println("Yore grant request is: " + this.toString() + " and it is fully processed. You can get paid at any time.");
    }

    @Override
    public String toString() {
        return "APPROVED";
    }
}
