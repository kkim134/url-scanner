Dependencies:
Playwright
Spring
Jackson

How to run:
1. Run UrlScannerApplication
2. Send a request to the "/api/scan" endpoint with the url in the request body. Example curl:

curl --location 'http://localhost:8080/api/scan' \
--header 'Content-Type: application/json' \
--data '{
    "url": "https://google.com"
}'
