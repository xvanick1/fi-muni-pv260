package pv260.solid.dip.original;

import pv260.solid.dip.original.model.OpenWeatherMapResponse;

import java.io.IOException;

public interface IOpenWeatherMapService {
    OpenWeatherMapResponse query() throws IOException;
}
