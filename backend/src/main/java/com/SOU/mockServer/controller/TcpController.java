package com.SOU.mockServer.controller;

import java.nio.charset.StandardCharsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

// inbound 요청을 서비스 계층 호출로 변환, 서비스 계층 반환 값을 아웃바운드 응답으로 변환하는 하나의 layer
// pipe & filter architecture 의 filter에 해당
// test flow에서 사용할 수 있는 여러 POJO(plain old java object) method 제공가능
@MessageEndpoint
@Component
public class TcpController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpController.class);

    @ServiceActivator(inputChannel = "fromTcp")
    public byte[] handleMessage(byte[] msg) {
        LOGGER.info("Received request: {}", new String(msg));
        return "test".getBytes(StandardCharsets.UTF_8);
    }
}