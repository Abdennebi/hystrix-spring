package org.bk.sample.controller;


import org.bk.sample.domain.Message;
import org.bk.sample.domain.MessageAcknowledgement;
import org.bk.sample.service.MessageHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MessageController {

    private final MessageHandlerService messageHandlerService;

    @Autowired
    public MessageController(MessageHandlerService messageHandlerService) {
        this.messageHandlerService = messageHandlerService;
    }

    @RequestMapping(value = "/message", method = POST)
    public DeferredResult<MessageAcknowledgement> pongMessage(@RequestBody Message input) {
        DeferredResult<MessageAcknowledgement> deferred = new DeferredResult<>();

        messageHandlerService.handleMessage(input)
                .subscribe(m -> deferred.setResult(m), e -> deferred.setErrorResult(e));

        return deferred;
    }

}
