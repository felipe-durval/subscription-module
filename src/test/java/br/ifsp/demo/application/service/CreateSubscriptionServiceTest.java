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
        UUID customerId = UUID.randomUUID();
        User user = User.builder()
                .id(customerId)
                .name("John")
                .lastname("Snow")
                .email("john.snow@email.com")
                .password("123456")
                .role(Role.USER)
                .build();

        JpaUserRepository userRepository = mock(JpaUserRepository.class);
        when(userRepository.findById(customerId)).thenReturn(Optional.of(user));

        CreateSubscriptionService service = new CreateSubscriptionService(userRepository);

        Subscription subscription = service.create(customerId, PlanType.BASIC, BillingCycle.MONTHLY);

        assertEquals(customerId, subscription.getCustomerId());
        assertEquals(SubscriptionStatus.ACTIVE, subscription.getStatus());
        assertEquals(PlanType.BASIC, subscription.getPlanType());
        assertEquals(BillingCycle.MONTHLY, subscription.getBillingCycle());
        assertEquals(new BigDecimal("29.90"), subscription.getAmount());

        verify(userRepository).findById(customerId);
    }
}