package com.example.client.service.impl;

import com.example.client.dto.request.GetClientRequestDto;
import com.example.client.dto.request.IsClientRequestDto;
import com.example.client.dto.request.PostClientRequestDto;
import com.example.client.dto.response.GetClientResponseDto;
import com.example.client.dto.response.PostClientResponseDto;
import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public GetClientResponseDto getClient(GetClientRequestDto requestDto) {
        if (clientRepository.findById(requestDto.getClientId()).isPresent()) {
            Client client = clientRepository.findById(requestDto.getClientId()).get();
            return new GetClientResponseDto(
                    client.getFirstName(),
                    client.getMiddleName(),
                    client.getLastName(),
                    client.getVinCodeAuto(),
                    client.getSigningServiceList());
        }
        throw new RuntimeException("Клиента нет");
    }

    @Override
    public Boolean isClient(IsClientRequestDto isClientRequestDto) {
        return clientRepository.findByFirstNameAndLastNameAndMiddleName(
                        isClientRequestDto.getFirstName(),
                        isClientRequestDto.getLastName(),
                        isClientRequestDto.getMiddleName())
                .isPresent();
    }

    @Override
    public PostClientResponseDto postClient(PostClientRequestDto requestDto) {
        if (clientRepository.getClientByVinCodeAuto(requestDto.getVinCodeAuto()) == null) {
            clientRepository.save(new Client(
                    requestDto.getFirstName(),
                    requestDto.getMiddelName(),
                    requestDto.getLastName(),
                    requestDto.getVinCodeAuto(),
                    new ArrayList<>()
            ));
            return new PostClientResponseDto(true);

        }
        return new PostClientResponseDto(false);
    }
}
