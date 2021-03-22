package me.aurium.beetle.spigot;

import me.aurium.beetle.api.BeetleOptions;
import me.aurium.beetle.api.task.sync.BlockingBehavior;
import me.aurium.beetle.defaults.task.sync.TimerSleepBehavior;

import java.util.Objects;
import java.util.concurrent.Executor;

public class SpigotOptions implements BeetleOptions {

    private final boolean isDebug;
    private final boolean usePlatformExecutor;
    private final boolean useThisThread;

    private final Executor platformExecutor;
    private final Thread mainThread;
    private final BlockingBehavior blockingBehavior;

    public SpigotOptions(boolean isDebug, boolean usePlatformExecutor, boolean useThisThread, Executor platformExecutor, Thread mainThread, BlockingBehavior blockingBehavior) {
        this.isDebug = isDebug;
        this.usePlatformExecutor = usePlatformExecutor;
        this.useThisThread = useThisThread;
        this.platformExecutor = platformExecutor;
        this.mainThread = mainThread;
        this.blockingBehavior = blockingBehavior;
    }

    public boolean isDebug() {
        return isDebug;
    }
    public Executor getPlatformExecutor() {
        return platformExecutor;
    }
    public boolean isUsePlatformExecutor() {
        return usePlatformExecutor;
    }
    public boolean isUseThisThread() {
        return useThisThread;
    }
    public Thread getMainThread() {
        return mainThread;
    }

    public BlockingBehavior getBlockingBehavior() {
        return blockingBehavior;
    }

    public static class Builder {
        private boolean isDebug;
        private boolean usePlatformExecutor;
        private boolean useThisThread;

        private Executor platformExecutor;
        private Thread mainThread;
        private BlockingBehavior blockingBehavior;

        public Builder() {
            isDebug = false;
            usePlatformExecutor = false;
            useThisThread = true;

            platformExecutor = null;
            mainThread = Thread.currentThread();
            blockingBehavior = new TimerSleepBehavior();
        }

        public Builder isDebug(boolean e) {
            this.isDebug = e;

            return this;
        }

        public Builder withPlatformExecutor(Executor e) {
            Objects.requireNonNull(e);

            this.platformExecutor = e;
            this.usePlatformExecutor = true;

            return this;
        }

        public Builder withMainThread(Thread mainThread) {
            Objects.requireNonNull(e);

            this.mainThread = e;
            this.useThisThread = false;

            return this;
        }

        public Builder withBlockingBehavior(BlockingBehavior blockingBehavior) {
            Objects.requireNonNull(e);

            this.blockingBehavior = e;

            return this;
        }

        public SpigotOptions build() {
            return new SpigotOptions(isDebug,usePlatformExecutor,useThisThread,platformExecutor,mainThread,blockingBehavior);
        }
    }
}
