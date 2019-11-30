package org.geysermc.floodgate.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BedrockData {
    public static final int EXPECTED_LENGTH = 6;
    private String version;
    private String username;
    private String xuid;
    private int deviceId;
    private String languageCode;
    private int inputMode;
    private int dataLength;

    public BedrockData(String version, String username, String xuid, int deviceId, String languageCode, int inputMode) {
        this(version, username, xuid, deviceId, languageCode, inputMode, 6);
    }

    public static BedrockData fromString(String data) {
        String[] split = data.split("\0");
        if (split.length != 5) return null;
        return new BedrockData(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4], split.length);
    }

    public static BedrockData fromRawData(byte[] data) {
        return fromString(new String(data));
    }

    public String toString() {
        return version +"\0"+ username +"\0"+ xuid +"\0"+ deviceId +"\0"+ languageCode +"\0"+ inputMode;
    }
}