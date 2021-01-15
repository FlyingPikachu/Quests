/*******************************************************************************************************
 * Continued by PikaMug (formerly HappyPikachu) with permission from _Blackvein_. All rights reserved.
 * 
 * THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN
 * NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************************************/

package me.blackvein.quests.listeners;

import me.blackvein.quests.Quests;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import de.erethon.dungeonsxl.api.event.group.GroupCreateEvent;
import de.erethon.dungeonsxl.api.event.group.GroupDisbandEvent;
import de.erethon.dungeonsxl.api.event.group.GroupPlayerJoinEvent;
import de.erethon.dungeonsxl.api.event.group.GroupPlayerLeaveEvent;
import me.blackvein.quests.util.Lang;

public class DungeonsListener implements Listener {
    private final Quests plugin;
    
    public DungeonsListener(final Quests plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onGroupCreate(final GroupCreateEvent event) {
        if (plugin.getSettings().canShareUseDungeonXL() && Lang.get("questDungeonsCreate").length() > 0) {
            event.getCreator().sendMessage(ChatColor.YELLOW + Lang.get("questDungeonsCreate"));
        }
    }
    
    @EventHandler
    public void onGroupDisbandEvent(final GroupDisbandEvent event) {
        if (plugin.getSettings().canShareUseDungeonXL() && Lang.get("questDungeonsDisband").length() > 0) {
            event.getDisbander().sendMessage(ChatColor.RED + Lang.get("questDungeonsDisband"));
        }
    }
    
    @EventHandler
    public void onPlayerJoinEvent(final GroupPlayerJoinEvent event) {
        if (plugin.getSettings().canShareUseDungeonXL()
                && event.getGroup() != null
                && event.getPlayer() != null) {
            final Player i = event.getGroup().getLeader();
            final Player p = event.getPlayer().getPlayer();
            if (i != null && p != null) {
                if (Lang.get("questDungeonsInvite").length() > 0) {
                    i.sendMessage(ChatColor.GREEN + Lang.get(i, "questDungeonsInvite")
                            .replace("<player>", p.getName()));
                }
                if (Lang.get("questDungeonsJoin").length() > 0) {
                    p.sendMessage(ChatColor.GREEN + Lang.get(p, "questDungeonsJoin").replace("<player>", i.getName()));
                }
            }
        }
    }
    
    @EventHandler
    public void onPlayerLeaveEvent(final GroupPlayerLeaveEvent event) {
        if (plugin.getSettings().canShareUseDungeonXL()
                && event.getGroup() != null
                && event.getPlayer() != null) {
            final Player k = event.getGroup().getLeader();
            final Player p = event.getPlayer().getPlayer();
            if (k != null && p != null) {
                if (Lang.get("questDungeonsKicked").length() > 0) {
                    k.sendMessage(ChatColor.RED + Lang.get(k, "questDungeonsKicked").replace("<player>", k.getName()));
                }
                if (Lang.get("questDungeonsLeave").length() > 0) {
                    p.sendMessage(ChatColor.RED + Lang.get(p, "questDungeonsLeave").replace("<player>", p.getName()));
                }
            }
        }
    }
}
