package is.pdl.pdlrain.commands;

import is.pdl.pdlrain.PdlRain;
import net.minecraft.server.v1_16_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class RainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player;
            float rainState;
            if (args.length == 0){
                rainState = 0;
            }else {
                try{
                    rainState = Float.parseFloat(args[0]);
                }catch (Exception e){
                    sender.sendMessage(ChatColor.RED + "Incorrect usage!");
                    return true;
                }
            }
            if (args.length <= 1){
                player = (Player) sender;
            }else{
                player = Bukkit.getPlayerExact(args[1]);
            }
            if (player == null){
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }
            sendPacket(player, rainState);
        }
        return true;
    }
    private void sendPacket(Player player, float rainState){
        PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.h,rainState);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
