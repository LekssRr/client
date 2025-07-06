package com.example.client.controller;

import com.example.client.dto.request.GetSigningServiceRequestDto;
import com.example.client.dto.request.PostSigningServiceRequestDto;
import com.example.client.dto.response.GetSigningServiceResponseDto;
import com.example.client.dto.response.PostSigningServiceResponseDto;
import com.example.client.service.SigningServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/v1/signingservice")
public class SigningServiceController {

    private final SigningServiceService signingServiceService;

    public SigningServiceController(SigningServiceService signingServiceService) {
        this.signingServiceService = signingServiceService;
    }

    @GetMapping("/")
    public ResponseEntity<List<GetSigningServiceResponseDto>> getSigningService(
            @RequestBody GetSigningServiceRequestDto requestDto) {
        return ResponseEntity.ok(signingServiceService.getActiveSigningService(requestDto));
    }

    @PostMapping("/")
    public ResponseEntity<PostSigningServiceResponseDto> postSigningService(
            @RequestBody PostSigningServiceRequestDto postSigningServiceRequestDto) {
        return ResponseEntity.ok(
                signingServiceService.postSigningService(new PostSigningServiceRequestDto(
                        postSigningServiceRequestDto.getClientId(),
                        postSigningServiceRequestDto.getVinCodeAuto(),
                        postSigningServiceRequestDto.getReasonDiscription(),
                        Date.from(Instant.now()))));
    }
}
