package com.pariyajafari.todolistproject.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum Status {

    TODO("STATUS_TODO"),
    DOING("STATUS_DOING"),
    DONE("STATUS_DONE");

    private final String value;

    public static Status getStatus(String value) {
        for (Status status : Status .values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
