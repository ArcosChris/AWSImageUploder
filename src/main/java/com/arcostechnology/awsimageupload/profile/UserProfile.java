package com.arcostechnology.awsimageupload.profile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserProfile {

    private final UUID userProfileId;
    private final String username;
    private String userProfileImageLink; //S3 key

    public UserProfile(UUID userProfileId, String username, String userProfileImageLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileImageLink = userProfileImageLink;
    }

    public UUID getUserProfileId() {
        return userProfileId;
    }

    public String getUsername() {
        return username;
    }

    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        //using Objects equals for null check
        return Objects.equals(getUserProfileId(), that.getUserProfileId()) &&
                Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getUserProfileImageLink(), that.getUserProfileImageLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserProfileId(), getUsername(), getUserProfileImageLink());
    }
}