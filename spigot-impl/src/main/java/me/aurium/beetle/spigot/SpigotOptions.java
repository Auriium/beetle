package me.aurium.beetle.spigot;

import me.aurium.beetle.api.BeetleOptions;
import me.aurium.beetle.api.task.sync.TaskCoordinator;
import me.aurium.beetle.defaults.task.sync.TimerSleepBehavior;

import java.util.Objects;
import java.util.concurrent.Executor;

public final class SpigotOptions implements BeetleOptions {

    private final boolean isDebug;

    private final Executor platformExecutor;
    private final Thread mainThread;
    private final TaskCoordinator blockingBehavior;

    SpigotOptions(boolean isDebug, Executor platformExecutor, Thread mainThread, TaskCoordinator blockingBehavior) {
        this.isDebug = isDebug;
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

    public Thread getMainThread() {
        return mainThread;
    }

    public TaskCoordinator getBlockingBehavior() {
        return blockingBehavior;
    }

    public static class Builder {
        private boolean isDebug;

        private Executor platformExecutor;
        private Thread mainThread;
        private TaskCoordinator blockingBehavior;

        public Builder() {
            isDebug = false;

            platformExecutor = null;
            mainThread = null;
            blockingBehavior = new TimerSleepBehavior();
        }

        public Builder isDebug(boolean e) {
            this.isDebug = e;

            return this;
        }

        public Builder withPlatformExecutor(Executor e) {
            Objects.requireNonNull(e);

            this.platformExecutor = e;

            return this;
        }

        public Builder withMainThread(Thread e) {
            Objects.requireNonNull(e);

            this.mainThread = e;

            return this;
        }

        public Builder withBlockingBehavior(TaskCoordinator e) {
            Objects.requireNonNull(e);

            this.blockingBehavior = e;

            return this;
        }

        public SpigotOptions build() {
            Objects.requireNonNull(mainThread);
            Objects.requireNonNull(platformExecutor);
            Objects.requireNonNull(blockingBehavior);

            return new SpigotOptions(isDebug, platformExecutor,mainThread,blockingBehavior);
        }
    }
}
