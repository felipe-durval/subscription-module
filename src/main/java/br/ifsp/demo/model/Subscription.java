package br.ifsp.demo.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Subscription {
    private final UUID customerId;
    private final PlanType planType;
    private final BillingCycle billingCycle;
    private final SubscriptionStatus status;
    private final BigDecimal amount;

    public Subscription(UUID customerId, PlanType planType, BillingCycle billingCycle, SubscriptionStatus status, BigDecimal amount) {
        this.customerId = customerId;
        this.planType = planType;
        this.billingCycle = billingCycle;
        this.status = status;
        this.amount = amount;
    }

    public UUID getCustomerId() {
        return customerId;
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
