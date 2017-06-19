package com.mrpowergamerbr.loritta.commands;

import com.mrpowergamerbr.loritta.commands.vanilla.administration.LimparCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.administration.RoleIdCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.discord.AvatarCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.discord.BotInfoCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.discord.EmojiCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.discord.ServerInfoCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.fun.*;
import com.mrpowergamerbr.loritta.commands.vanilla.magic.*;
import com.mrpowergamerbr.loritta.commands.vanilla.minecraft.McAvatarCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.minecraft.McQueryCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.minecraft.OfflineUUIDCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.misc.*;
import com.mrpowergamerbr.loritta.commands.vanilla.music.MusicInfoCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.music.TocarCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.music.VolumeCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.pokemon.PokedexCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.social.*;
import com.mrpowergamerbr.loritta.commands.vanilla.undertale.UndertaleBattleCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.undertale.UndertaleBoxCommand;
import com.mrpowergamerbr.loritta.commands.vanilla.utils.HexCommand;
import com.mrpowergamerbr.loritta.userdata.ServerConfig;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CommandManager {
    public List<CommandBase> commandMap = new ArrayList<CommandBase>();
    public Map<String, Class<?>> defaultCmdOptions = new HashMap<String, Class<?>>();

    public CommandManager() {
        commandMap.add(new BotInfoCommand());
        commandMap.add(new AjudaCommand());
        commandMap.add(new RollCommand());
        commandMap.add(new FaustaoCommand());
        commandMap.add(new CaraCoroaCommand());
        commandMap.add(new PedraPapelTesouraCommand());
        commandMap.add(new PingCommand());
        commandMap.add(new VaporondaCommand());
        commandMap.add(new QualidadeCommand());
        commandMap.add(new VaporQualidadeCommand());
        commandMap.add(new TristeRealidadeCommand());
        commandMap.add(new AngelCommand());
        commandMap.add(new TretaNewsCommand());
        commandMap.add(new MagicBallCommand());
        commandMap.add(new FraseToscaCommand());
        commandMap.add(new PackageInfoCommand());
        commandMap.add(new YouTubeCommand());
        commandMap.add(new TranslateCommand());
        commandMap.add(new EncurtarCommand());
        commandMap.add(new SAMCommand());
        commandMap.add(new NyanCatCommand());
        commandMap.add(new WikipediaCommand());
        commandMap.add(new QuoteCommand());
        commandMap.add(new WikiaCommand());
        commandMap.add(new TocarCommand());
        commandMap.add(new MusicInfoCommand());
        commandMap.add(new VolumeCommand());
        commandMap.add(new PrimeirasPalavrasCommand());
        commandMap.add(new MoneyCommand());
        commandMap.add(new DrakeCommand());
        commandMap.add(new InverterCommand());
        commandMap.add(new ReceitasCommand());

        // =======[ MISC ]======
        commandMap.add(new SayCommand());

        // =======[ SOCIAL ]======
        commandMap.add(new PerfilCommand());
        commandMap.add(new GamesCommand());
        commandMap.add(new BackgroundCommand());
        commandMap.add(new SobreMimCommand());

        // =======[ UTILS ]=======
        commandMap.add(new HexCommand());

        // =======[ DISCORD ]=======
        commandMap.add(new AvatarCommand());
        commandMap.add(new EmojiCommand());
        commandMap.add(new ServerInfoCommand());
        commandMap.add(new InviteCommand());

        // =======[ MINECRAFT ]========
        commandMap.add(new OfflineUUIDCommand());
        commandMap.add(new McAvatarCommand());
        commandMap.add(new McQueryCommand());
        commandMap.add(new McUUIDCommand());
        commandMap.add(new McStatusCommand());

        // =======[ UNDERTALE ]========
        commandMap.add(new UndertaleBoxCommand());
        commandMap.add(new UndertaleBattleCommand());

        // =======[ POKÉMON ]========
        commandMap.add(new PokedexCommand());

        // =======[ ADMIN ]========
        commandMap.add(new LimparCommand());
        commandMap.add(new RoleIdCommand());

        // =======[ MAGIC ]========
        commandMap.add(new ReloadCommand());
        commandMap.add(new EvalCommand());
        commandMap.add(new NashornTestCommand());
        commandMap.add(new ServerInvitesCommand());
        commandMap.add(new LorittaBanCommand());
        commandMap.add(new LorittaUnbanCommand());

        for (CommandBase cmdBase : this.getCommandMap()) {
            defaultCmdOptions.put(cmdBase.getClass().getSimpleName(), CommandOptions.class);
        }

        // Custom Options
        defaultCmdOptions.put(TristeRealidadeCommand.class.getSimpleName(), TristeRealidadeCommand.TristeRealidadeCommandOptions.class);
        defaultCmdOptions.put(YouTubeCommand.class.getSimpleName(), YouTubeCommand.YouTubeCommandOptions.class);
    }

    public List<CommandBase> getCommandsDisabledIn(ServerConfig conf) {
        List<CommandBase> commands = new ArrayList<CommandBase>();

        if (conf.debugOptions().enableAllModules()) {
            return commandMap;
        }

        for (CommandBase cmd : commandMap) {
            if (conf.disabledCommands().contains(cmd.getClass().getSimpleName())) {
                commands.add(cmd);
            }
        }

        return commands;
    }
}