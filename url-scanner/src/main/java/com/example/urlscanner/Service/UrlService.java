package com.example.urlscanner.Service;

import com.example.urlscanner.entity.Url;
import com.example.urlscanner.repository.UrlRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import util.UrlData;
import util.Util;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public ResponseEntity<Url> saveUrl(String url) {
        Url newUrl = new Url();
        ObjectMapper objectMapper = new ObjectMapper();
        String data = "";
        UrlData urlData = Util.extractData(url);

        try {
            data = objectMapper.writeValueAsString(urlData);
        }
        catch (Exception e) {
            System.out.println("Error writing data as json: " + e.getMessage());
        }

        newUrl.setUrl(url);
        newUrl.setData(data);

        urlRepository.save(newUrl);
        return ResponseEntity.ok(newUrl);
    }
}
