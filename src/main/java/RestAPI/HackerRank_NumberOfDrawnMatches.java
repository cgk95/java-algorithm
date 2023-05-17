package RestAPI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HackerRank_NumberOfDrawnMatches {


    public static int getNumDraws(int year) throws IOException {
        final String endPoint = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year;
        int maxGoal = 10;
        int totalDrawn = 0;
        for (int goal = 0; goal <= maxGoal; goal++) {
            totalDrawn += getDrawnNumber(String.format(endPoint + "&team1goals=%d&team2goals=%d", goal, goal));
        }
        return totalDrawn;
    }

    private static int getDrawnNumber(String requestURL) throws IOException {
        URL url = new URL(requestURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.addRequestProperty("Content-Type", "application/json");

        int status = conn.getResponseCode();
        InputStream in = (status < 200 || status > 299) ? conn.getErrorStream() : conn.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String responseLine;
        StringBuilder responseContent = new StringBuilder();
        while ((responseLine = br.readLine()) != null) {
            responseContent.append((responseLine));
        }
        br.close();
        conn.disconnect();

        String jsonResponse = responseContent.toString();
        JsonObject jsonObject = new Gson().fromJson(jsonResponse, JsonObject.class);

        return jsonObject.get("total").getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        int result = HackerRank_NumberOfDrawnMatches.getNumDraws(year);
        System.out.println(result);
        bufferedReader.close();
    }

}
