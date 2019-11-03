package reni.com.task07.state;

import reni.com.task07.entity.GrantRequest;

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
