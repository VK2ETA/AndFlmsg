# AndFlmsg Agent Guide

## Project Overview

AndFlmsg is an Android port of Fldigi and Flmsg for portable amateur-radio
operation. It combines Fldigi digital modems with Flmsg message forms.

The project is GPL-3.0. Treat the native code and HTML forms as
interoperability-sensitive.

## Essential Commands

```bash
./gradlew :andFlmsg:assembleDebug
```

There are no unit or instrumented test source sets. Do not claim tests ran.
The gate for a change is a successful debug build and a manual test on a
device or emulator. For modem/audio changes, test at least one RX
and one TX path. For form changes, test both entry and display.

## Coding Conventions

- Java + XML Views.
- Match the surrounding style; keep diffs focused and avoid reformatting
  unrelated code.
- Guard newer APIs with `Build.VERSION.SDK_INT`; do not raise `minSdk` without
  discussion.
- Use `BuildConfig` for version strings; do not hardcode version names.
- Use AndroidX `FileProvider`.
- Put user-visible strings in `res/values/strings.xml`.

## Security

- Never commit keystores, passwords, `local.properties`, tokens, or signing
  secrets.

## Pull requests

- One concern per PR. Include what changed and why, the commands you ran, the
  device/emulator and Android versions used for manual testing, screenshots for
  UI changes, and known limitations.
- Do not include generated build outputs, IDE files, or unrelated formatting.
- Keep commit messages descriptive.
- A human must review and submit every change; agents must not open issues or pull  requests autonomously.

## Ask first

- Changing `applicationId`, signing, `targetSdk`, `compileSdk`, NDK version, or
  the release workflow.
- Major dependency upgrades or new libraries.

## AI policy

Autonomous contributions are not accepted: a human must review, understand, and be able to explain every change before it is submitted. Do not open issues or pull requests autonomously, and do not post comments on behalf of a user without their review.
