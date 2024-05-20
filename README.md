# Todo List:
1. [ ] implement commands in 1.17.1 and below for Forge
2. [ ] add Quilt sub-project
3. [ ] test client and server commands
4. [ ] common mixins: in build.gradle: don't rename common to loaderCommon (does it work with Forgix then??)
5. [ ] support: Bukkit, Paper, Sponge, Folia, Purpur, Spigot (is there mixin support in all of them?)
6. [ ] rename everything:
   1. [ ] put function in name: "example_mod_id", "Example Mod Name", ...
7. [ ] make auto-copy and renaming script (include mode to change names if already modified); init **new** README with name (and state that this template was used); modify license notices (include that this template was used + what was used to make the template); .bat file that controls a gradle task and gets the parameters like the build.gradle gets the version...
8. [ ] make autotest script:
   1. [ ] copy every .jar in compatible client or server <- configurable !
   2. [ ] this should test all jars in lowest and highest supported version of that .jar
   3. [ ] test modes: (start via cmd or sth...; use [portablemc](https://github.com/mindstorm38/portablemc), AT-Launcher, installer .jar from loader or similar ?)
      1. [ ] manual version selection
      2. [ ] all jars in sequence: auto open 1., manual close 1., auto open 2. ...
      3. [ ] auto open all in sequence (just tests if .jar launches)
9. [ ] implement config handling:
   1. [ ] abstract config in common (client-, common- and server- config), annotate command configuration with Java Annotations
   2. [ ] onConfigChanged event
   3. [ ] Cloth / YACL example
   4. [ ] changeable with commands:  (on server: admins; on client: player; common on server and client)
   5. [ ] modmenu, catalogue, mod-loader stuff, and other mod list screens
   6. [ ] config in versions before Cloth and YACL ???
10. [ ] implement Mod Publisher with Better F3 changelog system
11. [ ] Logger Wrapper with option to send to chat (with color: info = yellow/white?; warning = orange; error = red)
12. [ ] work on every TODO and FIXME comment
13. [ ] final cleanup pass

# Release:
1. [ ] check license notices (include what was used to make the template)
2. [ ] check if all changes are stated with author and date in class java doc
3. [ ] make Readme for this template
   1. [ ] basic info
   2. [ ] tutorial; mention Manifold and Minecraft Development plugins; also look at [MultiLoader-Template](https://github.com/jaredlll08/MultiLoader-Template) for inspiration
   3. [ ] include what code I used at bottom + no affiliations disclaimer
   4. [ ] link to usefull wikis from loaders (version selectors; also legacy fabric), etc...
   5. [ ] make feature compatibility table
4. [ ] make Repository public
5. [ ] link to RemotePlayerWaypoints mod as example (once moved to this template...)

# Code used:
- [Disant Horizons](https://gitlab.com/jeseibel/distant-horizons): build scripts and project structure
- [Better F3](https://github.com/TreyRuffy/BetterF3): changelog system
- [Chunky](https://github.com/pop4959/Chunky): inspiration for plugin multi-loader setup

# Libraries in use:
- [Architectury](https://github.com/architectury): just Loom to compile (Neo)Forge
- [modpublisher](https://github.com/firstdarkdev/modpublisher): to publish the mod
- [Forgix](https://github.com/PacifistMC/Forgix): to merge different loader jars
- [Cloth Config](https://github.com/shedaniel/cloth-config): for config
- [Manifold](https://github.com/manifold-systems): Java preprocessor
- [Gradle Shadow](https://github.com/johnrengelman/shadow): to combine code jars
- [Portable Minecraft Launcher](https://github.com/mindstorm38/portablemc): to test builds