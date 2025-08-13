package com.example.client.service;

import com.example.client.dto.request.GetClientRequestDto;
import com.example.client.dto.request.IsClientRequestDto;
import com.example.client.dto.request.PostClientRequestDto;
import com.example.client.dto.response.GetClientResponseDto;
import com.example.client.dto.response.PostClientResponseDto;
import com.example.client.model.Client;

import java.util.Optional;

public interface ClientService {

    GetClientResponseDto getClient(GetClientRequestDto requestDto);

    Boolean isClient(IsClientRequestDto isClientRequestDto);

    PostClientResponseDto postClient(PostClientRequestDto requestDto);
}
