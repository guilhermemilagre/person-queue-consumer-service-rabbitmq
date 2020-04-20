package com.guilhermebmilagre.rabbitmq.domain.service;

import com.guilhermebmilagre.rabbitmq.domain.internal.Pearson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PearsonProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        Pearson pearson = exchange.getIn().getBody(Pearson.class);

        Thread.sleep(100);

        log.info("processing queue, id: {} personName: {} ", pearson.getId()    , pearson.getName());
    }
}
