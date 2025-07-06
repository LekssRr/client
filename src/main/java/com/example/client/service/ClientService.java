package com.example.client.service;

import com.example.client.dto.request.GetClientRequestDto;
import com.example.client.dto.request.PostClientRequestDto;
import com.example.client.dto.response.GetClientResponseDto;
import com.example.client.dto.response.PostClientResponseDto;

public interface ClientService {

    GetClientResponseDto getClient(GetClientRequestDto requestDto);



    PostClientResponseDto postClient(PostClientRequestDto requestDto);
}
