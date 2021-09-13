package is.pdl.pdlrain.commands;

import net.minecraft.server.v1_16_R3.PacketPlayOutGameStateChange;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ThunderCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player;
            float thunderState;
            if (args.length == 0){
                thunderState = 0;
            }else {
                try{
                    thunderState = Float.parseFloat(args[0]);
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
            sendPacket(player, thunderState);
        }
        return true;
    }
    private void sendPacket(Player player, float thunderState){
        PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(PacketPlayOutGameStateChange.i,thunderState);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
}
