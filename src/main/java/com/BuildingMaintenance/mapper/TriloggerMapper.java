package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.TriloggerRequest;
import com.BuildingMaintenance.controller.response.TriloggerResponse;
import com.BuildingMaintenance.entity.Trilogger;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TriloggerMapper {

    public static Trilogger toTrilogger(TriloggerRequest triloggerRequest){
        Trilogger trilogger = new Trilogger();

        trilogger.setEmail(triloggerRequest.email());
        trilogger.setPassword(triloggerRequest.password());

        return trilogger;
    }

    public static TriloggerResponse toTriloggerResponse(Trilogger trilogger){
        return new TriloggerResponse(
                trilogger.getId(),
                trilogger.getEmail(),
                trilogger.getCreatedDate()
        );
    }

    public static List<TriloggerResponse> toListTriloggers(List<Trilogger> triloggers){
        return triloggers.stream()
                .map(trilogger -> new TriloggerResponse(
                        trilogger.getId(),
                        trilogger.getEmail(),
                        trilogger.getCreatedDate()
                ))
                .collect(Collectors.toList());
    }
}
