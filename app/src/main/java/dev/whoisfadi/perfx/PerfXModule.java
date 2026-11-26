package dev.whoisfadi.perfx;

import android.os.Build;
import android.util.Log;

import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface.ModuleLoadedParam;

/**
 * PerfX Modern libxposed entry point.
 *
 * This first milestone intentionally does not hook or modify Samsung services.
 * It only confirms that LSPosed loaded the module in the selected scope.
 */
public final class PerfXModule extends XposedModule {
    private static final String TAG = "PerfX";

    @Override
    public void onModuleLoaded(ModuleLoadedParam param) {
        String manufacturer = Build.MANUFACTURER == null
                ? "" : Build.MANUFACTURER;

        if (!manufacturer.toLowerCase().contains("samsung")) {
            log(Log.INFO, TAG, "Skipped non-Samsung process: "
                    + param.getProcessName());
            return;
        }

        log(Log.INFO, TAG, "PerfX loaded on Samsung in process: "
                + param.getProcessName());
    }
}
