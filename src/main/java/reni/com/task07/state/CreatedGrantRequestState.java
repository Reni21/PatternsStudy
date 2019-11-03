package reni.com.task07.state;

import reni.com.task07.entity.GrantRequest;

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
