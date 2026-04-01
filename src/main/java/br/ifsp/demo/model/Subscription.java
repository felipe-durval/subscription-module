package br.ifsp.demo.model;

public class Subscription {
    private final PlanType planType;
    private final BillingCycle billingCycle;
    private final SubscriptionStatus status;

    public Subscription(PlanType planType, BillingCycle billingCycle, SubscriptionStatus status) {
        this.planType = planType;
        this.billingCycle = billingCycle;
        this.status = status;
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
}
