# AutoRestart

AutoRestart is a Minecraft plugin designed to automatically restart your server at a configurable interval. This plugin is perfect for server administrators who want to ensure their server runs smoothly by periodically restarting it. The plugin includes a configuration file to set the restart interval, and it also provides a command to manually restart the server if needed.

## Install

1. Download the AutoRestart plugin JAR file from the releases section of the GitHub repository.
2. Place the JAR file in the `plugins` folder of your Minecraft server.
3. Start or restart your server to load the plugin.

## Use

1. After installing the plugin, a `config.yml` file will be created in the `plugins/AutoRestart` directory.
2. Open the `config.yml` file and set the `restart-interval` to the desired time in milliseconds. For example, to set a restart interval of 5 hours, use `18000000`.
3. Save the `config.yml` file.
4. The server will now automatically restart at the specified interval. Players will receive a warning message 5 minutes before the restart.
5. To manually restart the server, use the `/restart` command. This command requires the `serverrestart.restart` permission, which is granted by default to server operators.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/e568d576-2809-4eaf-ab53-41eb06ace7df?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=e568d576-2809-4eaf-ab53-41eb06ace7df
