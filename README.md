# HeartPlugin
Minecraft server plugin for setting heart counts per player or all players. Resets heart count on respawn.

## Platform Information
- Tested on PaperMC (https://papermc.io/) version 1.18.1
- Java version: OpenJDK 17
- Dev Platform: IntelliJ Community Edition

## Installation
1. Using IntelliJ open the pom.xml file
2. Click the icon to import Maven dependencies (this may take a few moments)
3. Expand the Maven tab on the top right to access Maven commands
4. Expand "HeartPlugin" > "Lifecycle" and double click on "Package"
5. Check the console for errors. If there are no errors look in your local project folder for a new folder called "target" This is where you will find the compiled jar file.
6. Place compiled jar (HeartPlugin-1.0.jar) in the server "plugins" folder and restart:

    
    Example:
    /opt/minecraft/paper/plugins/HeartPlugin-1.0.jar

## Usage:
Note: This plugin is only available to Operators

    Enable plugin: 
    /addlove on

    Disable plugin:
    /addlove off

    Get plugin status:
    /addlove status

    Set max hearts to 20 for specific user:
    /addlove USERNAME 20

    Set max hearts for all players to 20
    /addlove @a 20

