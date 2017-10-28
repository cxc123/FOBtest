package Config;

/**
 * Created by aakumar on 27/10/17.
 */
public class AppiumExecution {
    private String deviceName;
    private String device;
    private String platformName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private String uuid;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getAppiumUrl() {
        return appiumUrl;
    }

    public void setAppiumUrl(String appiumUrl) {
        this.appiumUrl = appiumUrl;
    }

    public String getAppiumPort() {
        return appiumPort;
    }

    public void setAppiumPort(String appiumPort) {
        this.appiumPort = appiumPort;
    }

    private String appiumUrl;
    private String appiumPort;
}
