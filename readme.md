# **Beetle**
A beetle is tough, resilient, hard to kill, and rises above everyone else on an elytra

An easy to use, powerful and modular utility system meant to be the replacement and killer for ElytraForce's old aUtils system.

Beetle has a large focus on being object oriented and scalable.

# What can Beetle do?
Beetle is a:

- **Service registry system**
  1. **Registry** - This can function as a simple interface to implementation binder
  2. **Versioning** - Handle versioning simply with binding (ParticleManager.class to 1_12ParticleManager, for instance)
- **Database interaction system**
  1. **DataCore and Transaction** - Allows for super easy transactional database interaction. Ridiculously powerful and can operations fully asynchronously while still feeling as easy as synchronous operations for the api user.
  2. **HikariCP Support** - Use the power of pooling with HikariCP - Beetle's DataCore will let you interact asynchronously and transactionally with it!
  3. **CoreSource and Factory** - Allows for modular data-sources through the CoreSource interface. Easily switch between SQLite or MySQL, H2 or MariaDB
  4. **Directive Non-Included Module** - Through the power of JDBCaesar you can easily turn long sql queries into something more manageable
- **File management system**
  1. **File Registry** - Register all of your files in one place, and access them easily with a key as simple as a String!
  2. **Producer, ProducerKey and Options** - Thanks to the super modular key system you can integrate literally any type of filetype you can think of simply, without ever touching a single File or anything more complex than a Key.
  3. **Expandable** - Make producers and keys for literally any type of data you can think of. If you want to store configurable custom items templates, you can do that! Log some offline statistics, make the design of a GUI? That too! (*Disclaimer - These do not come prebuilt with Beetle. Beetle is a framework.*) 
  3. **Configuration and Local Data(Think SQLite)** - Comes prebuilt with two example keytypes, MutableConfKey, for simple configurations, and LocalSourceKey, for producing SQLite / H2 databases without ever touching the drivermanager or a single file. (As simple as new LocalSourceKey!)
  4. **FileExtension** - Automatically handles file ending types. Never again worry if that config should be .yml or .conf! For a beginner API user an H2 database is as simple as registering a key with (DBExtensions.H2,"myDatabaseName")
  5. **Gears Non-Included Module** - More configuration adapters, configuration types (ImmutableConf and AuriumUtilsConf), and the coming soon *tm* NodeMap configuration!
- **Runnable controller system** *(Tasker)*
  1. **TaskRunner** - Run synchronous and asynchronous actions platform-independent with ease!
  2. **TaskQueue** - Synchronous queue for runnables!
- **Logger system**
  1. **Logger** - This system consolidates your loggers under one name. Yes, this is an antipattern, ~~no, i don't care~~ but for someone who just wants version-independing logging with your plugin/app name on it, this is a fine solution.
- *(Platform specific)* **Command Registration**
  1. **Command and Command Source Abstraction** - It doesn't matter if you're on spigot or bungeecord, you can still use the same AbstractCommand interface! Since abstract commands are typed with the corresponding command data (Like a CommandSender or Player, but wrapped) you can register an AbstractCommand on any supported Beetle version!
  2. **Automatic CommandMap and TabComplete support on Spigot/Paper** - The command registry can automatically register your command into the commandmap, hide it if permissions are missing, set up aliases, and more. You can also use tabcomplete on supported versions, with async tabcomplete coming on paper soon!
  3. **Branch Non-Included Module** - Easily make commands that split into 3 subcommands, have variable arguments, require a combination of special arguments, with automatic tabcomplete built in! /kitpvp createkit (cost) (permission) (name) is as simple as a split-branch and a variable branch.


Thanks to maven modules, beetle is able to stay lightweight and modularized. If want spigot support, add it. If not, you aren't carrying all those dead classes around
If you just want to interact solely with the API, you can do that. If you want just the generic defaults and the API, you can have that. Want bungeecord, waterfall, and velocity support? 
Beetle can help with that!

# That sounds pretty cool! Where can I find more information on how to get started with beetle?

- To get started, head over to our **Wiki**
- To see an example plugin, check the module named **Examples**! The source code of the plugin additionally contains lots of documentation
- We do not currently have javadoc hosting. If I can get hosting then I will link it here.

# What are Beetle's non-included modules and where can I find them?

These non-included modules are simply not built into this git repository. They
are still packaged under the Beetle package allowing you to shade all of beetle at once
if you so desire.

- **Gears** (More options for configuration as well as more advanced configuration and more config adapters)
- **Branch** (A powerful command framework built around branching collections. Really easy on the end user thanks to its intuitive builder format)
- **Directive** (Wrapper for A248's JDBCaesar to make interacting with transacts and connections less annoying)

1. Gears Repo: -TO LINK-
2. Branch Repo: -TO LINK-
3. Directive Repo: -NOT DONE-
     
# What platforms does Beetle operate on?

- Spigot
- **Paper**
- **Velocity** (Soon!)
- Bungeecord (Soon!)
- Discord(Soon!)
- Generic Java
- Literally any other platform you can think of thanks to the power of interfaces 

# How can I ask for support?

DM **Aesthetik#9784** on discord!

# Contributing

Make pull requests and I accept them. It's about that simple, just don't shitcode.

# What *can't* Beetle do?

- Scoreboards (Beetle is a platform-neutral framework so something like scoreboards would go in a submodule)
- GUI management (There are plenty of open source frameworks that handle this, like IF or Canvas)
- Items, Serialization or Minigames (Check my other repositories!)
- Holograms (No.)
- EzReflection (What the fuck?)
- Slimefun addons (No.)
- EssentialsX replacement (No.)
- Be a minecraft plugin (No- I mean you can stick it *in* a plugin, but unlike some other utilities you can leave this on the classpath or shade it in. It isn't a fucking minecraft plugin)
- Fix all your problems magically

# Repositories
```
    <dependencies>
        <dependency>
            <groupId>me.aurium</groupId>
            <artifactId>beetle-spigot-impl</artifactId>
            <version>0.2.1</version>
        </dependency>
    </dependencies>
```
```
    <repositories>
        <repository>
            <id>aurium</id>
            <url>https://repo.repsy.io/mvn/elytraforce/default</url>
        </repository>
    </repositories>
```
