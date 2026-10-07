export interface CurrentWeather {
  time: string;
  temperature_2m: number;       
  relative_humidity_2m: number;  
  apparent_temperature: number;  
  precipitation: number;
  wind_speed_10m: number;        
  weather_code: number;          
}

export interface DailyMeteo {
  time: string[];
  weather_code: number[];
  temperature_2m_max: number[];  
  temperature_2m_min: number[];  
  precipitation_probability_max: number[];
}

export interface MeteoResponse {
  latitude: number;
  longitude: number;
  timezone: string;
  current: CurrentWeather;
  daily: DailyMeteo;
}