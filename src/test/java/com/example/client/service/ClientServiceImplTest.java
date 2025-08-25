package com.example.client.service;
import com.example.client.dto.request.GetClientRequestDto;
import com.example.client.dto.request.IsClientRequestDto;
import com.example.client.dto.request.PostClientRequestDto;
import com.example.client.dto.response.GetClientResponseDto;
import com.example.client.dto.response.PostClientResponseDto;
import com.example.client.model.Client;
import com.example.client.repository.ClientRepository;
import com.example.client.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void getClient_ShouldReturnClient_WhenExists() {
        // Arrange
        GetClientRequestDto request = new GetClientRequestDto(1, "ddd", "aaaa", "sss");
        Client client = createTestClient();

        when(clientRepository.findById(1)).thenReturn(Optional.of(client));

        // Act
        GetClientResponseDto result = clientService.getClient(request);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }
    @Test
    void getClient_ShouldThrowException_WhenNotExists() {
        // Arrange
        GetClientRequestDto request = new GetClientRequestDto(1, "ddd", "aaaa", "sss");

        when(clientRepository.findById(1)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> clientService.getClient(request));
    }
    @Test
    void isClient_ShouldReturnTrue_WhenClientExists() {
        // Arrange
        IsClientRequestDto request = new IsClientRequestDto("John", "Doe", "Michael");
        Client client = createTestClient();

        when(clientRepository.findByFirstNameAndLastNameAndMiddleName("John", "Doe", "Michael"))
                .thenReturn(Optional.of(client));

        // Act
        Boolean result = clientService.isClient(request);

        // Assert
        assertTrue(result);
    }
    @Test
    void isClient_ShouldReturnFalse_WhenClientNotExists() {
        // Arrange
        IsClientRequestDto request = new IsClientRequestDto("John", "Doe", "Michael");

        when(clientRepository.findByFirstNameAndLastNameAndMiddleName("John", "Doe", "Michael"))
                .thenReturn(Optional.empty());

        // Act
        Boolean result = clientService.isClient(request);

        // Assert
        assertFalse(result);
    }
    @Test
    void postClient_ShouldReturnTrue_WhenNewClient() {
        // Arrange
        PostClientRequestDto request = new PostClientRequestDto("John", "Michael", "Doe", "VIN123");

        when(clientRepository.getClientByVinCodeAuto("VIN123")).thenReturn(null);

        // Act
        PostClientResponseDto result = clientService.postClient(request);

        // Assert
        verify(clientRepository, times(1)).save(any(Client.class));
    }
    @Test
    void postClient_ShouldReturnFalse_WhenClientExists() {
        // Arrange
        PostClientRequestDto request = new PostClientRequestDto("John", "Michael", "Doe", "VIN123");
        Client existingClient = createTestClient();

        when(clientRepository.getClientByVinCodeAuto("VIN123")).thenReturn(existingClient);

        // Act
        PostClientResponseDto result = clientService.postClient(request);

        // Assert
        verify(clientRepository, never()).save(any(Client.class));
    }
    private Client createTestClient() {
        return new Client("John", "Michael", "Doe", "VIN123", new ArrayList<>());
    }
}
