package com.swmStrong.demo.domain.userSubscription.entity;

import lombok.Getter;

@Getter
public enum UserSubscriptionStatus {
    ACTIVE("구독 활성"),
    EXPIRED("구독 만료"),
    CANCELLED("구독 취소");

    private final String description;

    UserSubscriptionStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
