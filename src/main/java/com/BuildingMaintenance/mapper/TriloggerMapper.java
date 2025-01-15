package com.BuildingMaintenance.mapper;

import com.BuildingMaintenance.controller.request.TriloggerRequest;
import com.BuildingMaintenance.controller.response.TriloggerResponse;
import com.BuildingMaintenance.entity.Trilogger;
import lombok.experimental.UtilityClass;

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
}
