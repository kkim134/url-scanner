package controller;

import com.example.urlscanner.Service.UrlService;
import com.example.urlscanner.entity.Url;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
    @PostMapping("/scan")
    public ResponseEntity<Url> scanUrl(@RequestBody String url) {
        return urlService.saveUrl(url);
    }
}
