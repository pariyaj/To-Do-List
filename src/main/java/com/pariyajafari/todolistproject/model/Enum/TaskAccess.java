package com.pariyajafari.todolistproject.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskAccess {
    USER("ROLE_USER"),
    VIEWER("ROLE_VIEWER"),
    ADMIN("ROLE_ADMIN");

    private final String value;

    public static TaskAccess getTaskAccess(String value) {
        for (TaskAccess taskAccess : TaskAccess .values()) {
            if (taskAccess.getValue().equals(value)) {
                return taskAccess;
            }
        }
        return null;
    }
}
