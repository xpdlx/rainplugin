package is.pdl.pdlrain;

import is.pdl.pdlrain.commands.RainCommand;
import is.pdl.pdlrain.commands.ThunderCommand;
import is.pdl.pdlrain.listeners.Weather;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PdlRain extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("PdlRain has been Enabled!");
        Listener weather = new Weather();
        this.getServer().getPluginManager().registerEvents(weather, this);
        this.getCommand("rainstate").setExecutor(new RainCommand());
        this.getCommand("thunderstate").setExecutor(new ThunderCommand());
    }

    @Override
    public void onDisable() {
        System.out.println("PdlRain has been Disabled!");
    }
}
