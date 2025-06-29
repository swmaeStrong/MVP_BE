package com.swmStrong.demo.message.dto;

import lombok.Builder;
import org.bson.types.ObjectId;

public record LeaderBoardUsageMessage(
        String userId,
        String categoryId,
        double duration,
        double timestamp
) {
    @Builder
    public LeaderBoardUsageMessage(String userId, ObjectId categoryId, double duration, double timestamp) {
        this(
                userId,
                categoryId != null ? categoryId.toHexString() : null,
                duration,
                timestamp
        );
    }
}
