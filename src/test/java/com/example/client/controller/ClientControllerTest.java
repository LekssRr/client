package com.example.client.controller;


import com.example.client.dto.response.GetClientResponseDto;
import com.example.client.dto.response.PostClientResponseDto;
import com.example.client.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    void getClient_ShouldReturnOk() throws Exception {
        // Подготавливаем мок
        when(clientService.getClient(any())).thenReturn(new GetClientResponseDto("AAA", "aaaa", "AAA", "aaaa", new ArrayList<>()));

        // Выполняем запрос и проверяем статус
        mockMvc.perform(get("/api/v1/client/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }
    @Test
    void postClient_ShouldReturnOk() throws Exception {
        // Подготавливаем мок
        when(clientService.postClient(any())).thenReturn(new PostClientResponseDto( true));

        // Выполняем запрос и проверяем статус
        mockMvc.perform(post("/api/v1/client/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void isClient_ShouldReturnOk() throws Exception {
        // Подготавливаем мок
        when(clientService.isClient(any())).thenReturn(true);

        // Выполняем запрос и проверяем статус
        mockMvc.perform(get("/api/v1/client/is")
                        .param("firstName", "John")
                        .param("lastName", "Doe"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
    @Test
    void isClient_WithMiddleName_ShouldReturnOk() throws Exception {
        // Подготавливаем мок
        when(clientService.isClient(any())).thenReturn(true);

        // Выполняем запрос и проверяем статус
        mockMvc.perform(get("/api/v1/client/is")
                        .param("firstName", "John")
                        .param("lastName", "Doe")
                        .param("middleName", "Michael"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
