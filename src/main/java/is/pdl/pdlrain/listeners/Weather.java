package is.pdl.pdlrain.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Weather implements Listener {
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        if (e.toWeatherState() == true){
            e.setCancelled(true);
        }
    }
}
