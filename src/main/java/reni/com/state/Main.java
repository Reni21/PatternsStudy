package reni.com.state;

import reni.com.state.entity.GrantRequest;

public class Main {

    public static void main(String[] args) {

        GrantRequest grantRequest = new GrantRequest(100, "Just Because");

        while (!grantRequest.isPaymentAvailable()) {
            System.out.println("Grant payment is not available, grant in status: " + grantRequest.getState());
            grantRequest.moveToNextState();
        }

        System.out.println("\nSomething happened and commission changed it's decision");
        grantRequest.rejectGrantRequest();

        try {
            grantRequest.getPayment();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
}
