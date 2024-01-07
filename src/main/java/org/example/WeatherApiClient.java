package org.example;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WeatherApiClient {

    public static void main(String[] args) {
        String Station = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m,relative_humidity_2m,precipitation&daily=temperature_2m_max,temperature_2m_min,wind_speed_10m_max&past_days=92&forecast_days=1";
        // Виклик функції для виконання HTTP-запиту та отримання відповіді
        String apiResponse = makeHttpRequest(Station);

        // Тепер ви можете обробити та вивести обрані дані
        processApiResponse(apiResponse);
    }

    private static String makeHttpRequest(String apiUrl) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void processApiResponse(String apiResponse) {
        if (apiResponse != null) {
            // Використання Gson для розбору JSON
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(apiResponse, JsonObject.class);

            // Отримання конкретних полів з об'єкта JSON
            double[] temperatures = gson.fromJson(jsonObject.getAsJsonObject("hourly").getAsJsonArray("temperature_2m"), double[].class);
            double[] humiditys = gson.fromJson(jsonObject.getAsJsonObject("hourly").getAsJsonArray("relative_humidity_2m"), double[].class);
             String[] time_data = gson.fromJson(jsonObject.getAsJsonObject("daily").getAsJsonArray("time"), String[].class);
            double[] windy_speed_data = gson.fromJson(jsonObject.getAsJsonObject("daily").getAsJsonArray("wind_speed_10m_max"), double[].class);
            double[] daily_tempereture_data = gson.fromJson(jsonObject.getAsJsonObject("daily").getAsJsonArray("temperature_2m_max"), double[].class);
            double[] precipitation = gson.fromJson(jsonObject.getAsJsonObject("hourly").getAsJsonArray("precipitation"), double[].class);



            List<String> timeData = new ArrayList<>();
            for (String day : time_data) {
                timeData.add(day);
            }


            List<Double> precipitationDataAll = new ArrayList<>();
            for (double item : precipitation) {
                precipitationDataAll.add(item);
            }

            List<Double> windData = Arrays.stream(windy_speed_data)
                    .boxed()
                    .collect(Collectors.toList());


            List<Double> temperaturesData = Arrays.stream(temperatures)
                    .boxed()
                    .collect(Collectors.toList());


            List<Double> humiditysData = Arrays.stream(humiditys)
                    .boxed()
                    .collect(Collectors.toList());


            List<Double> precipitationData = Arrays.stream(precipitation)
                    .boxed()
                    .collect(Collectors.toList());

                //Середня глобальна температура

            List<Double> month1_temperature = temperaturesData.stream()
                    .limit(744)
                    .collect(Collectors.toList());


            List<Double> month2_temperature = temperaturesData.stream()
                    .skip(744)
                    .limit(744)
                    .collect(Collectors.toList());

            List<Double> month3_temperature = temperaturesData.stream()
                    .skip(1488)
                    .limit(744)
                    .collect(Collectors.toList());




            double month1_global_temperature_avg = month1_temperature.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month2_global_temperature_avg = month2_temperature.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month3_global_temperature_avg = month3_temperature.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            System.out.println(" ");
            System.out.println(" Середня глобальна температура за 1 мiсяць " + String.format("%.2f °C", month1_global_temperature_avg) );
            System.out.println(" Середня глобальна температура за 2 мiсяць " + String.format("%.2f °C", month2_global_temperature_avg) );
            System.out.println(" Середня глобальна температура за 3 мiсяць " + String.format("%.2f °C", month3_global_temperature_avg) );
//

            //Середня глобальна вологість

            List<Double> month1_humidity = humiditysData.stream()
                    .limit(744)
                    .collect(Collectors.toList());


            List<Double> month2_humidity = humiditysData.stream()
                    .skip(744)
                    .limit(744)
                    .collect(Collectors.toList());

            List<Double> month3_humidity = humiditysData.stream()
                    .skip(1488)
                    .limit(744)
                    .collect(Collectors.toList());




            double month1_global_humidity_avg = month1_humidity.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month2_global_humidity_avg = month2_humidity.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month3_global_humidity_avg = month3_humidity.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            System.out.println(" ");
            System.out.println(" Середня глобальна вологість за 1 мiсяць " + String.format("%.2f ", month1_global_humidity_avg) );
            System.out.println(" Середня глобальна вологість за 2 мiсяць " + String.format("%.2f ", month2_global_humidity_avg) );
            System.out.println(" Середня глобальна вологість за 3 мiсяць " + String.format("%.2f ", month3_global_humidity_avg) );


            //Середнiй глобальний рівень опадів / мiлiмметр

            List<Double> month1_precipitation = precipitationData.stream()
                    .limit(744)
                    .collect(Collectors.toList());


            List<Double> month2_precipitation = precipitationData.stream()
                    .skip(744)
                    .limit(744)
                    .collect(Collectors.toList());

            List<Double> month3_precipitation = precipitationData.stream()
                    .skip(1488)
                    .limit(744)
                    .collect(Collectors.toList());




            double month1_global_precipitation_avg = month1_precipitation.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month2_global_precipitation_avg = month2_precipitation.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month3_global_precipitation_avg = month3_precipitation.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            System.out.println(" ");
            System.out.println(" Середнiй глобальний рівень опадів за 1 мiсяць: " + String.format("%.3f мл", month1_global_precipitation_avg));
            System.out.println("Середнiй глобальний рівень опадів за 2 мiсяць: " + String.format("%.3f мл", month2_global_precipitation_avg));
            System.out.println(" Середнiй глобальний рівень опадів за 3 мiсяць: " + String.format("%.3f мл", month3_global_precipitation_avg));


            List<Double> month1 = windData.stream()
                    .limit(31)
                    .collect(Collectors.toList());


            List<Double> month2 = windData.stream()
                    .skip(31) // пропускаем первые 30 элементов (индексы 0-29)
                    .limit(30) // берем следующие 30 элементов (индексы 30-59)
                    .collect(Collectors.toList());

            List<Double> month3 = windData.stream()
                    .skip(61)
                    .limit(31)
                    .collect(Collectors.toList());


            double month1Mean = month1.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month2Mean = month2.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double month3Mean = month3.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(Double.NaN);

            double maxMean = Math.max(month1Mean, month2Mean);

            maxMean = Math.max(maxMean, month3Mean);

            int maxMeanMonth = 0;
            if (maxMean == month1Mean) {
                maxMeanMonth = 1;
            } else if (maxMean == month2Mean) {
                maxMeanMonth = 2;
            } else {
                maxMeanMonth = 3;
            }
            System.out.println(" ");
            System.out.println("Саме велике середнє значення вiтру " + maxMean + " (мiсяць " + maxMeanMonth + ")");

            List<Double> firstSevenElements = precipitationData.stream()
                    .filter(precipitationDataItem -> precipitationDataItem > 0.0)
                    .limit(30)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(" ");
            System.out.println(" більше 7 послідовних днів опадів.: " + firstSevenElements);

            for (int i = 0; i < firstSevenElements.size(); i++) {
                int index = precipitationDataAll.indexOf(firstSevenElements.get(i));
                System.out.println("Опади за  " + (i+1) + " день : " + timeData.get(index));
            }

            System.out.println(" ");
            // Средняя максимальная температура
            double averageMaximumTemperature = Arrays.stream(temperatures)
                    .filter(temperature -> temperature > 0)
                    .average()
                    .orElse(0);

// Средняя минимальная температура
            double averageMinimumTemperature = Arrays.stream(temperatures)
                    .filter(temperature -> temperature < 0)
                    .average()
                    .orElse(0);

// Максимальные влажности
            List<Double> maximumHumiditys = Arrays.stream(humiditys)
                    .filter(humidity -> humidity > 0)
                    .boxed()
                    .collect(Collectors.toList());

// Средняя максимальная влажность
            double averageMaximumHumidity = maximumHumiditys.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);


            // Виведення результатів
            System.out.println("Середня максимальна температура: " + averageMaximumTemperature + "°C");
            System.out.println("Середня мінімальна температура: " + averageMinimumTemperature + "°C");
            System.out.println("Середня максимальна волога: " + averageMaximumHumidity  );

        }
    }

}
