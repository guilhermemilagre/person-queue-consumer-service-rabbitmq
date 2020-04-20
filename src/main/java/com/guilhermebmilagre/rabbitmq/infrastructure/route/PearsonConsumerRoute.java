package com.guilhermebmilagre.rabbitmq.infrastructure.route;

import com.guilhermebmilagre.rabbitmq.domain.internal.Pearson;
import com.guilhermebmilagre.rabbitmq.domain.service.PearsonProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PearsonConsumerRoute extends RouteBuilder {

    private final PearsonProcessor pearsonProcessor;

    @Override
    public void configure() throws Exception {
        from("{{application.rabbitmq.queues.person}}")
                .unmarshal()
                .json(JsonLibrary.Jackson, Pearson.class)
                .process(pearsonProcessor);
    }
}
