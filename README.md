# PerfX — Samsung Performance Control

**By @whoisfadi**  
Starter version: 0.1.0

## What this starter contains

- Android app shell with a basic device/RAM dashboard.
- Modern libxposed API 102 entry point.
- Initial LSPosed scope for `com.android.systemui` and the virtual `system` process.
- Samsung manufacturer check and LSPosed log output.

## Important: current scope

This is a **monitoring-only starter**, not a performance-tuning release. It does not change CPU/GPU frequencies, governors, voltage, thermal policy, scheduler settings, or memory-killer behavior. It does not install any hooks yet.

Samsung One UI internals vary by device, chipset, Android release, and firmware build. Do not add guessed method hooks. Each future hook needs to be verified against the exact Samsung firmware and tested with a recovery/rollback plan. Thermal protections must remain enabled.

## Build

1. Open this folder in Android Studio.
2. Use JDK 17.
3. Allow Gradle to sync (requires internet for Android Gradle Plugin and Maven Central).
4. Build > Build APK(s).
5. Install the APK as a normal app.
6. In LSPosed, enable PerfX and select only the listed scope entries.
7. Reboot, then check LSPosed logs for `PerfX loaded on Samsung`.

## Project identity

- App/module: PerfX
- Package: `dev.whoisfadi.perfx`
- Developer: `@whoisfadi`
- API: Modern libxposed 102.0.0
- Minimum Android SDK in app: 26

## Compatibility note

The project is configured for the Modern libxposed API 102. It requires an LSPosed-compatible framework that supports API 102. It is not a legacy Xposed module.
