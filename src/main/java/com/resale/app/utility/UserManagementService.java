package com.resale.app.utility;

import javax.ejb.Singleton;
import javax.inject.Inject;

import com.resale.app.model.entity.User;

@Singleton
public class UserManagementService {

    @Inject
    private CacheManager cacheManager; // Inject your CacheManager here

    public void updateRoleToAdminForUser(User user) {
        // Code to update user's role to ADMIN in the database
        // ...

        // After successfully updating the role, clear the cache for the user's details
        cacheManager.clearUserCache(user.getUsername());
    }
}
