package com.example.demo.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class DataController {

    private static final List<DataPacket> list = new LinkedList<>(Arrays.asList(
            new DataPacket(1L, "first"),
            new DataPacket(2L, "second"),
            new DataPacket(3L, "third")
    ));

    @GetMapping(path = "data")
    public List<DataPacket> getData() {
        return list;
    }

    @PostMapping(path = "data")
    @ResponseStatus(HttpStatus.CREATED)
    public DataPacket createDataPacket(@RequestBody DataPacket payload) {
        list.add(payload);
        return payload;
    }

    @Data
    private static class DataPacket {

        private final Long id;

        private final String payload;
    }
}
