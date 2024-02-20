package util;

import com.microsoft.playwright.options.SecurityDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UrlData {
    private String screenshotPath;
    private String ipAddress;
    private String destinationUrl;
    private ArrayList<String> redirectUrls;
    private String pageSource;

    public String getPageSource() {
        return pageSource;
    }

    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }

    private SecurityDetails sslInfo;

    public String getScreenshotPath() {
        return screenshotPath;
    }

    public void setScreenshotPath(String screenshotPath) {
        this.screenshotPath = screenshotPath;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDestinationUrl() {
        return destinationUrl;
    }

    public void setDestinationUrl(String destinationUrl) {
        this.destinationUrl = destinationUrl;
    }

    public ArrayList<String> getRedirectUrls() {
        return redirectUrls;
    }

    public void setRedirectUrls(ArrayList<String> redirectUrls) {
        this.redirectUrls = redirectUrls;
    }

    public SecurityDetails getSslInfo() {
        return sslInfo;
    }

    public void setSslInfo(SecurityDetails sslInfo) {
        this.sslInfo = sslInfo;
    }
}
