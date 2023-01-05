## RESTWeatherApp

> weather station project with rest api

## Using
- Create sensor: POST `/sensor/registration`
  * Example JSON query:
    ```json
    {
      "name": "Test Sensor"
    }
    ```
- Send measurement: POST `/measurements/add`
  * Example JSON query:
    ```json
    {
      "value": 42,
      "raining": true,
      "sensor": {
        "name": "Test Sensor"
      }
    }
    ```
- Get all measurements: GET `/measurements`
  * Example JSON response:
      ```json
      {
        "measurements": [
          {
            "value": 42,
            "raining": true,
            "sensor": {
              "name": "Test Sensor"
            }
          }
        ]
      }
      ```
- Get raining days count: GET `/measurements/rainyDaysCount`
    * Example JSON response:
      ```json
      1
      ```

## Details
- Use `WeatherSensorEmulator` to test