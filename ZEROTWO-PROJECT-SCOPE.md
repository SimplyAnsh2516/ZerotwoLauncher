# ZeroTwo Launcher — Product Scope

## Non-negotiable project rules
- Keep the Zalith Launcher feature set. This is an additive fork, not a stripped-down replacement.
- Preserve existing account, authentication, profile, version, Java/runtime, downloads, settings, controls, storage, logs, and game-launch flows unless a change is required for compatibility and is documented.
- The entire Android launcher experience is forced landscape. Game rendering remains landscape as well.
- ZeroTwo visual identity: deep black/plum surfaces, crimson and neon-pink accents, readable high-contrast text, original ZeroTwo-inspired artwork and matching icons.
- No shader downloads, shader manager, shader presets, or shader-related promotion.
- Do not label a feature complete until it has been implemented, built, and tested on-device.

## Launcher experience
- Redesigned landscape home with ZeroTwo artwork, account/profile card, selected Minecraft version, clear Play action, status/download feedback, and quick access to existing Zalith tools.
- Preserve existing navigation and expose new tools as additional destinations.
- Microsoft sign-in and offline/local profiles. Offline profiles are not Microsoft-authenticated and cannot join servers requiring official online-mode authentication.
- Per-profile settings and skins where supported by the game/loader.

## Minecraft and content management
- Keep the existing version installer and add explicit compatibility validation for Minecraft 26.2 and 26.3 before advertising support.
- Fabric, Forge, NeoForge, and Quilt support only where the upstream launcher and target Minecraft version support them.
- Mod Hub with loader/version filtering, dependency checks, conflict warnings, source attribution, and safe install/remove/update flows.
- Performance collections/presets: Lite, Balanced, Extreme, and Low RAM. Candidate mods include Sodium, Sodium Extra, Lithium, FerriteCore, ImmediatelyFast, Entity Culling, More Culling, C2ME, Dynamic FPS, BadOptimizations, Enhanced Block Entities, ScalableLux, Moonrise, Alternate Current, Clumps, ServerCore, spark, Chunky, Language Reload, and Krypton. Compatibility and dependencies must be checked per version/loader; server-side-only mods must be labelled.
- Resource/texture pack manager. No shaders.
- Modpack import/export and per-instance configuration.

## In-game experience
- A separate Minecraft-side implementation is required for the ZeroTwo-themed title screen and pause menu.
- Desired title menu: Singleplayer, Multiplayer, Mods/Resource Packs, Settings, ZeroTwo artwork/background.
- Matching pause menu.
- Implement and test per Minecraft version and mod loader; do not pretend launcher UI changes can alter Minecraft's in-game menus.

## Additional quality-of-life features
- Download queue with pause/resume/retry and clear progress.
- Touch-control editor and presets.
- Crash/log analyzer with actionable explanations.
- Automatic world backups with restore controls.
- Optional performance overlay and session history.
- Screenshot gallery, skin studio, server shortcuts/hub, and storage manager.
- Runtime selector and advanced JVM arguments with safe defaults.

## Delivery gates
1. Inspect and preserve upstream behavior before modifying a flow.
2. Implement in small, reviewable commits.
3. Build debug APK in GitHub Actions after each meaningful batch.
4. Review build logs and resolve compile/resource/signing failures.
5. Test install, first launch, landscape behavior, account/profile flows, version selection, and game launch before calling a build a usable release.
6. Mark each feature as implemented, build-verified, or device-tested; these are different statuses.
