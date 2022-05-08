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

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class GetAllSubControllerTest {

    @Mock
    private SubscriptionApiMapper mapper;
    @Mock
    private SubscriptionRepository repository;
    @InjectMocks
    private GetAllSubController controller;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    

    @Test
    public void findAll_ok() throws Exception {

        when(repository.findAll()).thenReturn(List.of(new Subscription()));

        mockMvc.perform(get("/subscriptions"))
                .andExpect(status().isOk());

        verify(repository).findAll();
        verify(mapper).toResponse(anyList());

    }

}
