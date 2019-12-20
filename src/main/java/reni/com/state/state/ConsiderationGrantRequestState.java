package reni.com.state.state;

import reni.com.state.entity.GrantRequest;

public class ConsiderationGrantRequestState implements GrantRequestState {
    @Override
    public boolean isPaymentAvailable() {
        return false;
    }

    @Override
    public void moveToNextState(GrantRequest grantRequest) {
        System.out.println("Grant request move to APPROVED sate");
        grantRequest.setState(new ApprovedGrantRequestState());

    }

    @Override
    public String toString() {
        return "CONSIDERATION";
    }
}
