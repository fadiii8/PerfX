package dev.whoisfadi.perfx;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class MainActivity extends Activity {
    private int dp(float value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView text(String value, float size, int color) {
        TextView view = new TextView(this);
        view.setText(value);
        view.setTextSize(size);
        view.setTextColor(color);
        view.setPadding(0, dp(7), 0, dp(7));
        return view;
    }

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        int bg = 0xFF090B10;
        int fg = 0xFFF4F5F7;
        int muted = 0xFF9AA4B2;

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(24), dp(32), dp(24), dp(24));
        page.setBackgroundColor(bg);

        TextView title = text("PerfX", 34, fg);
        title.setGravity(Gravity.CENTER_VERTICAL);
        page.addView(title);

        page.addView(text("SAMSUNG PERFORMANCE CONTROL", 12, 0xFF9B8CFF));
        page.addView(text("by @whoisfadi", 14, muted));

        boolean samsung = Build.MANUFACTURER != null
                && Build.MANUFACTURER.toLowerCase().contains("samsung");

        page.addView(text(
                samsung ? "Samsung device detected" : "Samsung device not detected",
                18, samsung ? 0xFF76D7A5 : 0xFFFFB86B));

        page.addView(text("Device: " + Build.MODEL, 15, fg));
        page.addView(text("Android: " + Build.VERSION.RELEASE
                + " (API " + Build.VERSION.SDK_INT + ")", 15, fg));

        ActivityManager manager =
                (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memory = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(memory);
        long totalMb = memory.totalMem / (1024L * 1024L);
        long availableMb = memory.availMem / (1024L * 1024L);

        page.addView(text("RAM total: " + totalMb + " MB", 15, fg));
        page.addView(text("RAM available: " + availableMb + " MB", 15, fg));

        TextView note = text(
                "Starter build: monitoring-only. Performance profiles and "
                + "Samsung-specific hooks are not enabled yet. "
                + "No CPU/GPU clocks, governors, voltage, or thermal limits "
                + "are changed.",
                14, muted);
        note.setPadding(0, dp(22), 0, dp(12));
        page.addView(note);

        TextView footer = text("PerfX 0.1.0  •  @whoisfadi", 12, muted);
        footer.setGravity(Gravity.CENTER);
        page.addView(footer);

        setContentView(page, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
