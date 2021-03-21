package me.aurium.beetle.defaults.task.sync;

import me.aurium.beetle.api.task.sync.BlockingBehavior;

import java.util.concurrent.locks.LockSupport;

public class TimerSleepBehavior implements BlockingBehavior {

    //this needs review. I'm hoping that parknanos will halt the thread of it's invoker, which means behavior, which
    //hopefully means the syncfuture that activated it.

    //if it stops the thread of whatever initialized TimerSleepBehavior we have an issue, i think.

    @Override
    public void behavior() {
        LockSupport.parkNanos(500L);
    }
}
