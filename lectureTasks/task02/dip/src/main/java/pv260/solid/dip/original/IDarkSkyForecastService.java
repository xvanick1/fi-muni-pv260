package pv260.solid.dip.original;

import pv260.solid.dip.original.model.DarkSkyForecastResponse;

import java.io.IOException;

public interface IDarkSkyForecastService {
    DarkSkyForecastResponse queryService() throws IOException;
}
