package reni.com.task07.state;


import reni.com.task07.entity.GrantRequest;

public interface GrantRequestState {

    boolean isPaymentAvailable();

    void moveToNextState(GrantRequest grantRequest);

}


