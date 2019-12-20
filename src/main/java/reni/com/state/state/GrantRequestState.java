package reni.com.state.state;


import reni.com.state.entity.GrantRequest;

public interface GrantRequestState {

    boolean isPaymentAvailable();

    void moveToNextState(GrantRequest grantRequest);

}


