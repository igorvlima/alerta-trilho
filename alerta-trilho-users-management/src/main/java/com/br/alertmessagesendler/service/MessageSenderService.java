package com.br.alertmessagesendler.service;

import com.br.alertmessagesendler.domain.Delay.DelayRequest;
import com.br.alertmessagesendler.domain.Message.MessageRequest;
import com.br.alertmessagesendler.feign.MessageSenderUpstreamService;
import com.br.alertmessagesendler.repository.LinesRepository;
import com.br.alertmessagesendler.repository.PassengerLineRepository;
import com.br.alertmessagesendler.repository.PassengersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageSenderService {

    private final MessageSenderUpstreamService messageSenderUpstreamService;
    private final LinesRepository linesRepository;
    private final PassengersRepository passengersRepository;
    private final PassengerLineRepository passengerLineModel;
    public void sendMessage(DelayRequest request){

        var lineId = linesRepository.findByLineByName(request.getLine().toString());

        var passengersIds = passengerLineModel.findAllPassengersIdByLineId(lineId);

        for(Integer passengerId : passengersIds){

            var pessengerPhoneNumber = passengersRepository.getPessengerPhoneNumber(passengerId);

            var message = MessageRequest.builder()
                    .phoneNumber("+55"+pessengerPhoneNumber)
                    .message(String.format("Identificamos um atraso na linha %s.", request.getLine()))
                    .build();

            log.info("Starting to send message notification");
            try {
                var smsRequest = messageSenderUpstreamService.sendMessage(message);
                log.info("Message sent with status code {}", smsRequest.status());
            } catch (Exception e) {
                log.error("An error occurred while sending the message: {}", e.getMessage());
            }
        }
    }
}
