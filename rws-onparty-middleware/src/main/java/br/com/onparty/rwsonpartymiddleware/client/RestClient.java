package br.com.onparty.rwsonpartymiddleware.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class RestClient {

    private String server;
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient(String server) {
        this.server = server;
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    public String get(String uri) {
        try {
            HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
            ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, String.class);
            this.setStatus(responseEntity.getStatusCode());
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    public String post(String json) {
        try {
            HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
            ResponseEntity<String> responseEntity = rest.exchange(server, HttpMethod.POST, requestEntity, String.class);
            this.setStatus(responseEntity.getStatusCode());
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    public String put(String json) {
        try {
            HttpEntity<String> requestEntity = new HttpEntity<String>(json, headers);
            ResponseEntity<String> responseEntity = rest.exchange(server, HttpMethod.PUT, requestEntity, String.class);
            this.setStatus(responseEntity.getStatusCode());
            return responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    public void delete(String uri) {
        try {
            HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
            ResponseEntity<String> responseEntity = rest.exchange(server + uri, HttpMethod.DELETE, requestEntity, String.class);
            this.setStatus(responseEntity.getStatusCode());
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getRawStatusCode()));
        }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}