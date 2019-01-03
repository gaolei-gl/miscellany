package com.lei.snippet;

import java.util.*;

public class RoundRobinScheduler {
    private class Task {
        private int arrival;
        private int execution;
        private int lastExecution;

        public Task(int arrival, int execution) {
            this.arrival = arrival;
            this.execution = execution;
            this.lastExecution = arrival;
        }

        @Override
        public String toString() {
            return arrival + " " + execution + " " + lastExecution;
        }
    }


    public double averageWaitTime(int[] arrival, int[] execution, int slice) {
        Queue<Task> q = new LinkedList<>();
        List<Task> tasks = new ArrayList<>(arrival.length);
        for (int i = 0; i < arrival.length; i++) {
            tasks.add(new Task(arrival[i], execution[i]));
        }
        Collections.sort(tasks, Comparator.comparingInt(o -> o.arrival));
        int waitTime = 0, curTime = tasks.get(0).arrival;
        q.add(tasks.remove(0));
        while (!q.isEmpty()) {
            Task task = q.poll();
            int execSlice = task.execution > slice ? slice : task.execution;
            waitTime += curTime - task.lastExecution;
            curTime += execSlice;
            task.lastExecution = curTime;
            task.execution -= execSlice;
            Iterator<Task> iter = tasks.iterator();
            while (iter.hasNext()) {
                Task t = iter.next();
                if (t.arrival <= curTime) {
                    q.offer(t);
                    iter.remove();
                }
            }
            if (task.execution > 0) q.offer(task);
            if (q.isEmpty() && !tasks.isEmpty()) {
                Task t = tasks.remove(0);
                curTime = t.arrival;
                q.offer(t);
            }
        }
        return 1.0 * waitTime / arrival.length;
    }

    public static void main(String[] args) {
        RoundRobinScheduler rrs = new RoundRobinScheduler();
//        System.out.println(rrs.averageWaitTime(new int[]{0, 1, 3, 9}, new int[]{2, 1, 7, 5}, 2));
        System.out.println(rrs.averageWaitTime(new int[]{0, 1, 4}, new int[]{5, 2, 3}, 3));
        System.out.println(rrs.averageWaitTime(new int[]{0, 2, 4, 5}, new int[]{7, 4, 1, 4}, 3));
    }
}
