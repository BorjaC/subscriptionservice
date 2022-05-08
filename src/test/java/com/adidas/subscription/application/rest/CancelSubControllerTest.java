package com.adidas.subscription.application.rest;


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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CancelSubControllerTest {

    @Mock
    private SubscriptionRepository repository;
    @InjectMocks
    private CancelSubController controller;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void cancel_ok() throws Exception {

        doNothing().when(repository).cancel(any());

        mockMvc.perform(delete("/subscriptions/{id}", 1))
                .andExpect(status().isOk());

        verify(repository).cancel(any());
    }

}
