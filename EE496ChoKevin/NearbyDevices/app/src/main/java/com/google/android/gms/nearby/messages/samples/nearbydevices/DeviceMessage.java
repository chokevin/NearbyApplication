package com.google.android.gms.nearby.messages.samples.nearbydevices;
import android.os.Build;

import com.google.android.gms.nearby.messages.Message;
import com.google.gson.Gson;

import java.nio.charset.Charset;

/**
 * Used to prepare the payload for a
 * {@link com.google.android.gms.nearby.messages.Message Nearby Message}. Adds a unique id
 * to the Message payload, which helps Nearby distinguish between multiple devices with
 * the same model name.
 */
public class DeviceMessage {
    private static final Gson gson = new Gson();

    private final String mUUID;
    private String mMessageBody;

    /**
     * Builds a new {@link Message} object using a unique identifier.
     */
    public static Message newNearbyMessage(String instanceId, String TOKEN_INFORMATION ) {
        DeviceMessage deviceMessage = new DeviceMessage(instanceId , TOKEN_INFORMATION);
        return new Message(gson.toJson(deviceMessage).getBytes(Charset.forName("UTF-8")));
    }

    /**
     * Creates a {@code DeviceMessage} object from the string used to construct the payload to a
     * {@code Nearby} {@code Message}.
     */
    public static DeviceMessage fromNearbyMessage(Message message) {
        String nearbyMessageString = new String(message.getContent()).trim();
        return gson.fromJson(
                (new String(nearbyMessageString.getBytes(Charset.forName("UTF-8")))),
                DeviceMessage.class);
    }

    private DeviceMessage(String uuid, String TOKEN_INFORMATION) {
        mUUID = uuid;
        mMessageBody = "https://ambientdynamix-nearby.mybluemix.net/landing?token=" + TOKEN_INFORMATION;
        // TODO(developer): add other fields that must be included in the Nearby Message payload.
    }

    protected String getMessageBody() {
        return mMessageBody;
    }



    public void setMessageBody(String Token){
        mMessageBody = "https://ambientdynamix-nearby.mybluemix.net/landing?token=" + Token;
    }
}