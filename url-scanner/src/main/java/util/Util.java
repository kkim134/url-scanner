package util;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SecurityDetails;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;

public class Util {
    public static UrlData extractData(String url) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch();
            Page page = browser.newPage();
            //"https://playwright.dev/"
            Response response = page.navigate(url);

            //Get Screenshot and save to file
            String screenshotName = UUID.randomUUID().toString();
            Path screenshotPath = Paths.get(screenshotName);
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(screenshotPath)
                    .setFullPage(true));
            Path absolutePath = screenshotPath.toAbsolutePath();

            //Get IP Address
            String ipAddress = response.serverAddr().ipAddress;

            //Get destination url
            String destinationUrl = response.request().url();

            //Get redirected urls
            ArrayList<String> redirectUrls = new ArrayList<>();
            Request request = response.request();
            while (request.redirectedFrom() != null) {
                redirectUrls.add(0,response.request().redirectedFrom().url());
                request = request.redirectedFrom().redirectedFrom();
            }

            //Get security details
            SecurityDetails sslInfo = response.securityDetails();

            //Get Page source
            String pageSource = page.content();


            UrlData urlData = new UrlData();
            urlData.setScreenshotPath(absolutePath.toString());
            urlData.setIpAddress(ipAddress);
            urlData.setDestinationUrl(destinationUrl);
            urlData.setRedirectUrls(redirectUrls);
            urlData.setSslInfo(sslInfo);
            urlData.setPageSource(pageSource);

            return urlData;
        }
        catch(Exception e) {
            System.out.println("Failed extracting URL data: " + e.getMessage());
            return null;
        }
    }
}
