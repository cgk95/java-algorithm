package RestAPI;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HackerRank_TotalGoalsByATeam {
    public static int getTotalGoals(String team, int year) throws IOException {
        final String endPoint = "https://jsonmock.hackerrank.com/api/football_matches";
        int totalGoalsAtHome = getPageTotalGoals(
                String.format(endPoint + "?team1=%s&year=%d", URLEncoder.encode(team, "UTF-8"),year)
                ,"team1",1);
        int totalGoalsAtAway = getPageTotalGoals(
                String.format(endPoint + "?team1=%s&year=%d", URLEncoder.encode(team, "UTF-8"),year)
                ,"team2",1);

        return totalGoalsAtHome+totalGoalsAtAway;
    }

    private static int getPageTotalGoals(String requestURL, String team, int page) throws IOException{
        URL url = new URL(requestURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        conn.addRequestProperty("Content-Type", "application/json");

        return  0;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        int result = HackerRank_NumberOfDrawnMatches.getNumDraws(year);
        System.out.println(result);
        bufferedReader.close();
    }
}
