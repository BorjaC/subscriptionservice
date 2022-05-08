package com.adidas.subscription.application.rest;


import com.adidas.subscription.application.rest.mapper.SubscriptionApiMapper;
import com.adidas.subscription.domain.Subscription;
import com.adidas.subscription.domain.repository.SubscriptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class GetSubControllerTest {

    @Mock
    private SubscriptionApiMapper mapper;
    @Mock
    private SubscriptionRepository repository;
    @InjectMocks
    private GetSubController controller;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    

    @Test
    public void findById_ok() throws Exception {

        when(repository.findById(any())).thenReturn(new Subscription());

        mockMvc.perform(get("/subscriptions/{id}", 1))
                .andExpect(status().isOk());

        verify(repository).findById(any());
        verify(mapper).toResponse(any(Subscription.class));

    }

}
