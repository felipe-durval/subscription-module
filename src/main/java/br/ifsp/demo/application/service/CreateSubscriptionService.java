package br.ifsp.demo.application.service;

import org.springframework.stereotype.Service;
import br.ifsp.demo.model.BillingCycle;
import br.ifsp.demo.model.PlanType;
import br.ifsp.demo.model.Subscription;
import br.ifsp.demo.model.SubscriptionStatus;

import java.util.UUID;


@Service
public class CreateSubscriptionService {
    public Subscription create(UUID customerId, PlanType planType, BillingCycle billingCycle) {
        return new Subscription(planType, billingCycle, SubscriptionStatus.ACTIVE);
    }
}
