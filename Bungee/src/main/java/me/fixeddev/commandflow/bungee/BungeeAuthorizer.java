package me.fixeddev.commandflow.bungee;

import me.fixeddev.commandflow.Authorizer;
import me.fixeddev.commandflow.Namespace;
import net.md_5.bungee.api.CommandSender;

public class BungeeAuthorizer implements Authorizer {

    @Override
    public boolean isAuthorized(Namespace namespace, String permission) {
        if (permission.isEmpty()) {
            return true;
        }

        CommandSender sender = namespace.getObject(CommandSender.class, BungeeCommandManager.SENDER_NAMESPACE);
        return sender.hasPermission(permission);
    }

}
