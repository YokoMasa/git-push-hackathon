package com.example.masato.githubfeed.http;

import com.example.masato.githubfeed.http.HandyHttpURLConnection;

import java.util.concurrent.ExecutorService;

/**
 * Created by Masato on 2018/01/20.
 */

public class HttpConnectionPool {

    private ExecutorService executorService;
    private String authorizationToken;

    public void setToken(String token) {
        this.authorizationToken = token;
    }

    public HandyHttpURLConnection newConnection(String url) {
        HandyHttpURLConnection connection = new HandyHttpURLConnection(url, executorService);
        connection.setHeader("User-Agent", "YokoMasa");
        if (authorizationToken != null) {
            connection.setHeader("Authorization", "token " + authorizationToken);
        }
        return connection;
    }

    public HttpConnectionPool(ExecutorService executorService, String authorizationToken) {
        this.executorService = executorService;
        this.authorizationToken = authorizationToken;
    }

}
