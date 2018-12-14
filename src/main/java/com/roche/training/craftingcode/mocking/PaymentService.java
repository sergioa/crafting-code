package com.roche.training.craftingcode.mocking;

public class PaymentService {

    private PaymentGateway paymentGateway;
    private UserValidationService userValidationService;

    public PaymentService(UserValidationService userValidationService,
                          PaymentGateway paymentGateway) {
        this.userValidationService = userValidationService;
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(User user, PaymentDetails paymentDetails)
            throws PaymentServiceException {

        if (!userValidationService.validate(user)) {
            throw new PaymentServiceException();
        }
        paymentGateway.process(user, paymentDetails);
    }
}


