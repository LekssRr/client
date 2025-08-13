package com.example.client.controller;

import com.example.client.dto.request.GetClientRequestDto;
import com.example.client.dto.request.IsClientRequestDto;
import com.example.client.dto.request.PostClientRequestDto;
import com.example.client.dto.response.GetClientResponseDto;
import com.example.client.dto.response.PostClientResponseDto;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public ResponseEntity<GetClientResponseDto> getClient(@RequestBody GetClientRequestDto getClientRequestDto){
        return ResponseEntity.ok(clientService.getClient(getClientRequestDto));
    }
    @PostMapping("/")
    public ResponseEntity<PostClientResponseDto> postClient(@RequestBody PostClientRequestDto postClientRequestDto){
        return ResponseEntity.ok(clientService.postClient(postClientRequestDto));
    }
    @GetMapping("/is")  // ✅ GET с query-параметрами
    public ResponseEntity<Boolean> isClient(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam(required = false) String middleName
    ) {
        IsClientRequestDto dto = new IsClientRequestDto(firstName, lastName, middleName);
        return ResponseEntity.ok(clientService.isClient(dto));
    }
}
