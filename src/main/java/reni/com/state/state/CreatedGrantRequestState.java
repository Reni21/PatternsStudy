package reni.com.state.state;

import reni.com.state.entity.GrantRequest;

public class CreatedGrantRequestState implements GrantRequestState{

    @Override
    public boolean isPaymentAvailable() {
        return false;
    }

    @Override
    public void moveToNextState(GrantRequest grantRequest) {
        System.out.println("Grant request move to CONSIDERATION sate");
        grantRequest.setState(new ConsiderationGrantRequestState());

    }

    @Override
    public String toString() {
        return "CREATED";
    }
}
