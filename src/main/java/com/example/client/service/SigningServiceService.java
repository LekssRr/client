package com.example.client.service;

import com.example.client.dto.request.GetSigningServiceRequestDto;
import com.example.client.dto.request.PostSigningServiceRequestDto;
import com.example.client.dto.response.GetSigningServiceResponseDto;
import com.example.client.dto.response.PostSigningServiceResponseDto;

import java.util.List;

public interface SigningServiceService {

    List<GetSigningServiceResponseDto> getActiveSigningService(GetSigningServiceRequestDto getSigningServiceRequestDto);

    PostSigningServiceResponseDto postSigningService(PostSigningServiceRequestDto postSigningServiceRequestDto);
}
