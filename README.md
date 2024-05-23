# Todo List:
1. [x] test client and server commands
2. [ ] common mixins: in build.gradle: don't rename common to loaderCommon (does it work with Forgix then??)
3. [ ] support: Bukkit, Paper, Sponge, Folia, Purpur, Spigot (is there mixin support in all of them?)
4. [ ] rename everything:
   1. [ ] put function in name: "example_mod_id", "Example Mod Name", ...
5. [ ] make auto-copy and renaming script (include mode to change names if already modified); init **new** README with name (and state that this template was used); modify license notices (include that this template was used + what was used to make the template); .bat file that controls a gradle task and gets the parameters like the build.gradle gets the version...
6. [ ] make autotest script:
   1. [ ] copy every .jar in compatible client or server <- configurable !
   2. [ ] this should test all jars in the lowest and highest supported version of that .jar
   3. [ ] test modes: (start via cmd or sth...; use [portablemc](https://github.com/mindstorm38/portablemc), AT-Launcher, installer .jar from loader or similar ?)
      1. [ ] manual version selection
      2. [ ] all jars in sequence: auto open 1., manual close 1., auto open 2. ...
      3. [ ] auto open all in sequence (just tests if .jar launches)
7. [ ] implement config handling:
   1. [ ] abstract config in common (client-, common- and server-config), annotate command configuration with Java Annotations
   2. [ ] onConfigChanged event
   3. [ ] Cloth / YACL example
   4. [ ] changeable with commands: (on server: admins; on client: player; common on server and client)
   5. [ ] modmenu, catalogue, mod-loader stuff, and other mod list screens
   6. [ ] config in versions before Cloth and YACL ???
8. [ ] implement Mod Publisher with Better F3 changelog system
9. [ ] Logger Wrapper with an option to send to chat (with color: info = yellow/white?; warning = orange; error = red)
10. [ ] work on every TODO and FIXME comment
11. [ ] final cleanup pass & order functions: more important once to the top & change MC version to latest

# Release:
1. [ ] check license notices (include what was used to make the template)
2. [ ] check if all changes are stated with author and date in class java doc
3. [ ] make Readme for this template
   1. [ ] basic info
   2. [ ] tutorial; mention Manifold and Minecraft Development plugins; also look at [MultiLoader-Template](https://github.com/jaredlll08/MultiLoader-Template) for inspiration
   3. [ ] include what code I used at bottom + no affiliations disclaimer
   4. [ ] link to useful wikis from loaders (version selectors; also legacy fabric), etc...
   5. [ ] make feature compatibility table
4. [ ] make server only, client only and legacy version branches + mention in Readme
5. [ ] make the Repository public
6. [ ] link to RemotePlayerWaypoints mod as example (once moved to this template...)

# Code used:
- [Disant Horizons](https://gitlab.com/jeseibel/distant-horizons): build scripts and project structure
- [Better F3](https://github.com/TreyRuffy/BetterF3): changelog system
- [Chunky](https://github.com/pop4959/Chunky): inspiration for plugin multi-loader setup

# Libraries in use:
- [Architectury](https://github.com/architectury): Loom to compile (Neo)Forge
- [modpublisher](https://github.com/firstdarkdev/modpublisher): to publish the mod
- [Forgix](https://github.com/PacifistMC/Forgix): to merge different loader jars
- [Cloth Config](https://github.com/shedaniel/cloth-config): for config
- [Manifold](https://github.com/manifold-systems): Java preprocessor
- [Gradle Shadow](https://github.com/johnrengelman/shadow): to combine code jars
- [Portable Minecraft Launcher](https://github.com/mindstorm38/portablemc): to test builds