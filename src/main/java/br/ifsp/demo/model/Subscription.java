package br.ifsp.demo.model;

import java.math.BigDecimal;

public class Subscription {
    private final PlanType planType;
    private final BillingCycle billingCycle;
    private final SubscriptionStatus status;
    private final BigDecimal amount;

    public Subscription(PlanType planType, BillingCycle billingCycle, SubscriptionStatus status, BigDecimal amount) {
        this.planType = planType;
        this.billingCycle = billingCycle;
        this.status = status;
        this.amount = amount;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
