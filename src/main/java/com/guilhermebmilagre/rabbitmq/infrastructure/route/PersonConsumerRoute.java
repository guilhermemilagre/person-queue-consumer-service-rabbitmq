package com.guilhermebmilagre.rabbitmq.infrastructure.route;

import com.guilhermebmilagre.rabbitmq.domain.internal.Person;
import com.guilhermebmilagre.rabbitmq.domain.service.PersonProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonConsumerRoute extends RouteBuilder {

    private final PersonProcessor personProcessor;

    @Override
    public void configure() throws Exception {
        from("{{application.rabbitmq.queues.person}}")
                .unmarshal()
                .json(JsonLibrary.Jackson, Person.class)
                .process(personProcessor);
    }
}
