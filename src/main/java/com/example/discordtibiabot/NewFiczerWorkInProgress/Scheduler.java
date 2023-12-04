package com.example.discordtibiabot.NewFiczerWorkInProgress;

import java.util.ArrayList;
import java.util.List;

public class Scheduler implements Runnable{

    private final List<Task> listOfTasksToRun = new ArrayList<>();

    //Delay co ile ma sie wywolywac funkcja
    public synchronized void addTask(Task task)
    {
        this.listOfTasksToRun.add(task);
    }

    @Override
    public void run() {

       //potem ustawic na pentle while i ustawic delay co ile ma wykonywac
        for (int i = 0; i < 5; i++) {
            for (Task t: listOfTasksToRun) {
                t.doTask();
            }
        }
    }
}
