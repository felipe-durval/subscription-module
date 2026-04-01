package br.ifsp.demo.application.service;

import br.ifsp.demo.model.BillingCycle;
import br.ifsp.demo.model.PlanType;
import br.ifsp.demo.model.Subscription;
import br.ifsp.demo.model.SubscriptionStatus;
import br.ifsp.demo.repository.SubscriptionRepository;
import br.ifsp.demo.security.user.JpaUserRepository;
import br.ifsp.demo.security.user.Role;
import br.ifsp.demo.security.user.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@Tag("UnitTest")
@Tag("TDD")
class CreateSubscriptionServiceTest {

    @Test
    void shouldCreateSubscriptionWithBasicMonthlyPlanAndActiveStatus() {
        CreateSubscriptionService service = new CreateSubscriptionService();

        Subscription subscription = service.create(UUID.randomUUID(), PlanType.BASIC, BillingCycle.MONTHLY);

        assertEquals(SubscriptionStatus.ACTIVE, subscription.getStatus());
        assertEquals(PlanType.BASIC, subscription.getPlanType());
        assertEquals(BillingCycle.MONTHLY, subscription.getBillingCycle());
        assertEquals(new BigDecimal("29.90"), subscription.getAmount());
    }
}