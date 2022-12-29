package com.arcostechnology.awsimageupload.bucket;

public enum BucketName {
    PROFILE_IMAGE("aws-image-project");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
