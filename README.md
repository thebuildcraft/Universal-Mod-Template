# Universal Mod Template by thebuildcraft

This is a multi-loader and multi-version minecraft mod template that supports client and server mods/plugins.
Most of the build scripts are originally from the Distant Horizons mod by James Seibel.
This template should take away the need to write setup boilerplate code.


> [!IMPORTANT]  
> This template is not finished and should not be used for now!
> Use at your own risk!
> 
> You can, however, provide any ideas you have or help with the development.

Maybe I overscoped a bit... but I will see how it goes :)

---

## Todo List:
1. [x] Fabric and Quilt support
2. [x] Forge support
3. [x] NeoForge support
4. [x] multi-version support
5. [x] selective jar merging with Forgix
6. [x] mixin examples
7. [x] Text wrappers to make debugging commands easier to write
8. [x] multi-loader and multi-version client and server commands
9. [ ] common mixins: in build.gradle: don't rename common to loaderCommon (does it work with Forgix then??)
10. [ ] support: Bukkit, Paper, Sponge, Folia, Purpur, Spigot (is there mixin support in all of them?)
11. [ ] rename everything:
    1. [ ] put function in name: "example_mod_id", "Example Mod Name", ...
12. [ ] make auto-copy and renaming script (include mode to change names if already modified); init **new** README with name (and state that this template was used); modify license notices (include that this template was used + what was used to make the template); .bat file that controls a gradle task and gets the parameters like the build.gradle gets the version...
13. [ ] make autotest script:
    1. [ ] copy every .jar in compatible client or server <- configurable !
    2. [ ] this should test all jars in the lowest and highest supported version of that .jar
    3. [ ] test modes: (start via cmd or sth...; use [portablemc](https://github.com/mindstorm38/portablemc), AT-Launcher, installer .jar from loader or similar ?)
       1. [ ] manual version selection
       2. [ ] all jars in sequence: auto open 1., manual close 1., auto open 2. ...
       3. [ ] auto open all in sequence (just tests if .jar launches)
14. [ ] implement config handling:
    1. [ ] abstract config in common (client-, common- and server-config), annotate command configuration with Java Annotations
    2. [ ] onConfigChanged event
    3. [ ] Cloth / YACL example
    4. [ ] changeable with commands: (on server: admins; on client: player; common on server and client)
    5. [ ] modmenu, catalogue, mod-loader stuff, and other mod list screens
    6. [ ] config in versions before Cloth and YACL ???
15. [ ] implement Mod Publisher with Better F3 changelog system
16. [ ] Logger Wrapper with an option to send to chat (with color: info = yellow/white?; warning = orange; error = red)
17. [ ] work on every TODO and FIXME comment
18. [ ] final cleanup pass & order functions: more important once to the top & change MC version to latest

## Notes for me before Release:
1. [ ] check license notices (include what was used to make the template)
2. [ ] check if all changes are stated with author and date in class java doc
3. [ ] make Readme for this template
   1. [ ] basic info
   2. [ ] tutorial; mention Manifold and Minecraft Development plugins; also look at [MultiLoader-Template](https://github.com/jaredlll08/MultiLoader-Template) for inspiration
   3. [ ] include what code I used at bottom + no affiliations disclaimer
   4. [ ] link to useful wikis from loaders (version selectors; also legacy fabric), etc...
   5. [ ] make feature compatibility table
4. [ ] make server only, client only and legacy version branches + mention in Readme
5. [ ] link to RemotePlayerWaypoints mod as example (once moved to this template...)

---

## Code used / want to use:
- [Disant Horizons](https://gitlab.com/jeseibel/distant-horizons): build scripts and project structure
- [Better F3](https://github.com/TreyRuffy/BetterF3): changelog system
- [Chunky](https://github.com/pop4959/Chunky): inspiration for plugin multi-loader setup

## Libraries in use / want to use:
- [Architectury](https://github.com/architectury): Loom to compile (Neo)Forge
- [modpublisher](https://github.com/firstdarkdev/modpublisher): to publish the mod
- [Forgix](https://github.com/PacifistMC/Forgix): to merge different loader jars
- [Cloth Config](https://github.com/shedaniel/cloth-config): for config
- [Manifold](https://github.com/manifold-systems): Java preprocessor
- [Gradle Shadow](https://github.com/johnrengelman/shadow): to combine code jars
- [Portable Minecraft Launcher](https://github.com/mindstorm38/portablemc): to test builds