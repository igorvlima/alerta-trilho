package com.br.alertmessagesendler.service;

import com.br.alertmessagesendler.domain.Delay.DelayRequest;
import com.br.alertmessagesendler.domain.Delay.Line;
import com.br.alertmessagesendler.feign.MessageSenderUpstreamService;
import com.br.alertmessagesendler.repository.LinesRepository;
import com.br.alertmessagesendler.repository.PassengerLineRepository;
import com.br.alertmessagesendler.repository.PassengersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class MessageSenderServiceTest {

    @Mock
    private LinesRepository linesRepository;

    @Mock
    private PassengerLineRepository passengerLineModel;

    @Mock
    private PassengersRepository passengersRepository;

    @Mock
    private MessageSenderUpstreamService messageSenderUpstreamService;

    @InjectMocks
    private MessageSenderService messageSenderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendMessageWhenNoUsersAssociatedWithAffectedLine() {
        when(linesRepository.findByLineByName(anyString())).thenReturn(1);
        when(passengerLineModel.findAllPassengersIdByLineId(anyInt())).thenReturn(Collections.emptyList());


         messageSenderService.sendMessage(DelayRequest.builder()
                .delayTime(LocalDateTime.now())
                .description("teste")
                .line(Line.TURQUESA)
                .build());

        verify(messageSenderUpstreamService, never()).sendMessage(any());
    }



    @Test
    public void testSendMessageWhenMultipleUsersAssociatedWithAffectedLine() {

        when(linesRepository.findByLineByName(anyString())).thenReturn(1);
        List<Integer> passengerIds = List.of(1, 2, 3);
        when(passengerLineModel.findAllPassengersIdByLineId(anyInt())).thenReturn(passengerIds);
        when(passengersRepository.getPessengerPhoneNumber(anyInt())).thenReturn("123456789", "987654321", "555555555");


        messageSenderService.sendMessage(DelayRequest.builder()
                .delayTime(LocalDateTime.now())
                .description("teste")
                .line(Line.RUBI)
                .build());


        verify(messageSenderUpstreamService, times(3)).sendMessage(any());
    }


}
