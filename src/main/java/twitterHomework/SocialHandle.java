package twitterHomework;

import java.util.HashSet;

public class SocialHandle {

    // Properties
    HashSet<String> listOfHandles = new HashSet<>();

    public String createHandle(String yourSocialHandle) {
        // Check if the input handle is empty
        if (yourSocialHandle.trim().isEmpty()) {
            return "Invalid handle";
        }

        // Make handle to lowercase
        yourSocialHandle = yourSocialHandle.toLowerCase();

        // Check length and add @
        if (yourSocialHandle.length() <= 9) {
            return "@" + yourSocialHandle;
        }

        // If more than 9 characters, trim to 9 and add @
        return "@" + yourSocialHandle.substring(0, 9);
    }

    public void addHandle(String yourSocialHandle) {
        String handle = createHandle(yourSocialHandle);

        if (!handle.equals("Invalid handle")) {
            listOfHandles.add(handle);
        }
    }

    public void removeHandle(String yourSocialHandle) {
        String handle = createHandle(yourSocialHandle);
        listOfHandles.remove(handle);
    }

    public HashSet<String> getHandles() {
        return listOfHandles;
    }
}

