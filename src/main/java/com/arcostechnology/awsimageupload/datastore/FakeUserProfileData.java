package com.arcostechnology.awsimageupload.datastore;

import com.arcostechnology.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
* FAKE DB to store fake userprofiles
*/

@Repository
public class FakeUserProfileData {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static{
        USER_PROFILES.add(new UserProfile(UUID.fromString("8e714f54-55b9-40ef-b9a4-4b68b7c56417"), "janetjones", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("0866d03f-5d87-4180-8dd2-cce8280e852c"), "antoniojunior", null));
    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}