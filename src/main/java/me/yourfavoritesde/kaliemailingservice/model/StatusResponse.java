package me.yourfavoritesde.kaliemailingservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusResponse {
    private StatusCode status;
    private String additionalMessage;
}
