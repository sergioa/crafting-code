package com.roche.training.craftingcode.mocking;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class PaymentServiceShould {

    @Test(expected = PaymentServiceException.class)
    public void fail_when_user_is_not_valid() throws PaymentServiceException {
        UserValidationService userValidationService = mock(UserValidationService.class);
        Mockito.when(userValidationService.validate(any(User.class))).thenReturn(false);

        User user = new User();
        PaymentService paymentService = new PaymentService(userValidationService, null);
        paymentService.processPayment(user, new PaymentDetails());
    }

    @Test
    public void process_a_payment_through_payment_gateway() throws PaymentServiceException {
        //stub
        UserValidationService userValidationService = mock(UserValidationService.class);
        Mockito.when(userValidationService.validate(any(User.class))).thenReturn(true);

        User user = new User();
        PaymentGateway paymentGateway = mock(PaymentGateway.class);

        PaymentDetails paymentDetails = new PaymentDetails();

        PaymentService paymentService = new PaymentService(userValidationService, paymentGateway);

        paymentService.processPayment(user, paymentDetails);

        //spy
        verify(paymentGateway, times(1)).process(user, paymentDetails);

    }
}
