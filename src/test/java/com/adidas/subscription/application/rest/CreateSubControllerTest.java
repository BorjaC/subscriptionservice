package com.adidas.subscription.application.rest;


import com.adidas.subscription.application.request.SubscriptionRequest;
import com.adidas.subscription.application.rest.mapper.SubscriptionApiMapper;
import com.adidas.subscription.domain.usecase.CreateSubscriptionUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CreateSubControllerTest {

    @Mock
    private SubscriptionApiMapper mapper;
    @Mock
    private CreateSubscriptionUseCase useCase;
    @InjectMocks
    private CreateSubController controller;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }


    @Test
    public void findById_ok_complete() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setEmail("email@email.com");
        request.setConsent(true);
        request.setBirthday("10/10/2000");
        request.setName("test");
        request.setGender("FEMALE");
        request.setNewsletterId(1L);

        when(useCase.create(any())).thenReturn(1L);

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        verify(mapper).toDomain(any(SubscriptionRequest.class));
        verify(useCase).create(any());

    }

    @Test
    public void findById_ok_missingNameAndGender() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setEmail("email@email.com");
        request.setConsent(true);
        request.setBirthday("10/10/2000");
        request.setNewsletterId(1L);

        when(useCase.create(any())).thenReturn(1L);

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        verify(mapper).toDomain(any(SubscriptionRequest.class));
        verify(useCase).create(any());

    }

    @Test
    public void findById_badRequest_missingEmail() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setConsent(true);
        request.setBirthday("10/10/2000");
        request.setName("test");
        request.setGender("FEMALE");
        request.setNewsletterId(1L);

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void findById_badRequest_malformedEmail() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setEmail("email");
        request.setConsent(true);
        request.setBirthday("10/10/2000");
        request.setName("test");
        request.setGender("FEMALE");
        request.setNewsletterId(1L);

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void findById_badRequest_malformedGender() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setEmail("email@email.com");
        request.setConsent(true);
        request.setBirthday("10/10/2000");
        request.setName("test");
        request.setGender("OTHER");
        request.setNewsletterId(1L);

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void findById_badRequest_missingBirthday() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setEmail("email@email.com");
        request.setConsent(true);
        request.setName("test");
        request.setGender("FEMALE");
        request.setNewsletterId(1L);

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void findById_badRequest_missingConsent() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setEmail("email@email.com");
        request.setBirthday("10/10/2000");
        request.setName("test");
        request.setGender("FEMALE");
        request.setNewsletterId(1L);

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void findById_badRequest_missingNewsletterId() throws Exception {

        SubscriptionRequest request = new SubscriptionRequest();
        request.setEmail("email@email.com");
        request.setConsent(true);
        request.setBirthday("10/10/2000");
        request.setName("test");
        request.setGender("FEMALE");

        mockMvc.perform(post("/subscriptions")
                .content(objectMapper.writeValueAsBytes(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());

    }

}
