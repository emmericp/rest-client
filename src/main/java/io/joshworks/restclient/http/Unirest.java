package io.joshworks.restclient.http;

import io.joshworks.restclient.request.GetRequest;
import io.joshworks.restclient.request.HttpRequestWithBody;

/**
 * Created by Josh Gontijo on 6/3/17.
 */
public class Unirest {

    private static RestClient client;

    private synchronized static RestClient getClient() {
        if (client == null) {
            client = RestClient.builder().build();
        }
        return client;
    }
    
    public synchronized static void setClient(RestClient client) {
        close();
        Unirest.client = client;
    }

    public synchronized static void close() {
        if (client != null) {
            client.close();
            client = null;
        }
    }

    public static GetRequest get(String url) {
        return getClient().get(url);
    }

    public static GetRequest head(String url) {
        return getClient().head(url);
    }

    public static HttpRequestWithBody options(String url) {
        return getClient().options(url);
    }

    public static HttpRequestWithBody post(String url) {
        return getClient().post(url);
    }

    public static HttpRequestWithBody delete(String url) {
        return getClient().delete(url);
    }

    public static HttpRequestWithBody patch(String url) {
        return getClient().patch(url);
    }

    public static HttpRequestWithBody put(String url) {
        return getClient().put(url);
    }


}
