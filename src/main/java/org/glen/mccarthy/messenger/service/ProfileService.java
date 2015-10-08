package org.glen.mccarthy.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.glen.mccarthy.messenger.database.DataBaseClass;
import org.glen.mccarthy.messenger.model.Profile;

public class ProfileService {
	
	Map<String, Profile> profiles = DataBaseClass.getProfiles();

	public ProfileService(){
		profiles.put("gmccarthy", new Profile(1l, "gmccarthy", "Glen", "McCarthy"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profile){
		return profiles.get(profile);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProile(String profileName){
		return profiles.remove(profileName);
	}

}
