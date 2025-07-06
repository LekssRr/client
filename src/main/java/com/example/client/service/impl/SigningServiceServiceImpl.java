package com.example.client.service.impl;

import com.example.client.dto.request.GetSigningServiceRequestDto;
import com.example.client.dto.request.PostSigningServiceRequestDto;
import com.example.client.dto.response.GetSigningServiceResponseDto;
import com.example.client.dto.response.PostSigningServiceResponseDto;
import com.example.client.model.Client;
import com.example.client.model.SigningService;
import com.example.client.repository.ClientRepository;
import com.example.client.repository.SigningServiceRepository;
import com.example.client.service.SigningServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SigningServiceServiceImpl implements SigningServiceService {

    private final SigningServiceRepository signingServiceRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public SigningServiceServiceImpl(SigningServiceRepository signingServiceRepository, ClientRepository clientRepository) {
        this.signingServiceRepository = signingServiceRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<GetSigningServiceResponseDto> getActiveSigningService(GetSigningServiceRequestDto getSigningServiceRequestDto) {
        if (clientRepository.findById(getSigningServiceRequestDto.getClientId()).isPresent()) {
            if (getSigningServiceRequestDto.isActive()){
                return signingServiceRepository
                        .getActiveSigningServiceBy(getSigningServiceRequestDto.getClientId()).stream()
                        .map(s -> new GetSigningServiceResponseDto(
                                s.getReasonDiscription(),
                                s.getDateSigningService()
                        ))
                        .toList();
            }else {
                return signingServiceRepository
                        .getAllSigningServiceBy(getSigningServiceRequestDto.getClientId()).stream()
                        .map(s -> new GetSigningServiceResponseDto(
                                s.getReasonDiscription(),
                                s.getDateSigningService()
                        ))
                        .toList();
            }
        }
        throw new RuntimeException("Нет такого клиента");
    }


    @Override
    public PostSigningServiceResponseDto postSigningService(PostSigningServiceRequestDto postSigningServiceRequestDto) {
        Optional<Client> clientOptional = clientRepository.findById(postSigningServiceRequestDto.getClientId());
        if (clientOptional.isPresent()) {
            signingServiceRepository.save(new SigningService(
                    clientOptional.get(),
                    postSigningServiceRequestDto.getReasonDiscription(),
                    postSigningServiceRequestDto.getDate(),
                    postSigningServiceRequestDto.getVinCodeAuto(),
                    true
            ));
            return new PostSigningServiceResponseDto(true, postSigningServiceRequestDto.getDate());
        }
        throw new RuntimeException("Нет клиента");
    }
}
