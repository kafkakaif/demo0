package mypackage;

import java.util.Random;

public class hello {
    public static void main(String[] args) {
        System.out.println("=== Cloud Simulation Mock Output ===\n");

        int numCloudlets = 35;
        int numVMs = 6;
        int numBrokers = 35; // each cloudlet has its own broker

        // Create VM and Broker names
        String[] vms = {"VM1", "VM2", "VM3", "VM4", "VM5", "VM6"};
        String[] brokers = new String[numBrokers];
        for (int i = 0; i < numBrokers; i++) {
            brokers[i] = "Broker" + (i + 1);
        }

        Random rand = new Random();

        // Step 1: Assign Cloudlets to VMs by Brokers
        System.out.println("Assigning Cloudlets to VMs by Brokers:\n");
        for (int i = 0; i < numCloudlets; i++) {
            String cloudletID = "Cloudlet" + (i + 1);
            String vmID = vms[rand.nextInt(numVMs)];
            System.out.println(brokers[i] + " assigns " + cloudletID + " to " + vmID);
        }

        // Step 2: Cloudlets execution timeline
        System.out.println("\nCloudlets execution simulation (mock timeline):\n");
        int currentTime = 0;
        int[] cloudletStartTimes = new int[numCloudlets];
        int[] cloudletFinishTimes = new int[numCloudlets];
        int[] cloudletExecTimes = new int[numCloudlets];
        String[] cloudletVMs = new String[numCloudlets];
        String[] cloudletBrokers = new String[numCloudlets];

        for (int i = 0; i < numCloudlets; i++) {
            cloudletVMs[i] = vms[rand.nextInt(numVMs)];
            cloudletBrokers[i] = brokers[i];
            cloudletExecTimes[i] = rand.nextInt(5) + 1; // 1-5s
            cloudletStartTimes[i] = currentTime;
            cloudletFinishTimes[i] = currentTime + cloudletExecTimes[i];
            System.out.println("Cloudlet" + (i + 1) + " executed on " + cloudletVMs[i] + " via " +
                               cloudletBrokers[i] + " during " + cloudletStartTimes[i] + "-" +
                               cloudletFinishTimes[i] + "s");
            currentTime += cloudletExecTimes[i];
        }

        // Step 3: Cloudlet Execution Details Table
        System.out.println("\nCloudlet Execution Details:\n");
        System.out.printf("%-10s %-10s %-10s %-12s %-12s %-14s %-12s\n",
                          "CloudletID", "Status", "VMID", "StartTime", "FinishTime", "ExecTime", "WaitingTime");

        for (int i = 0; i < numCloudlets; i++) {
            String status = "SUCCESS";
            double waitingTime = rand.nextInt(5); // 0-4s
            System.out.printf("%-10s %-10s %-10s %-12.2f %-12.2f %-14.2f %-12.2f\n",
                              "Cloudlet" + (i + 1), status, cloudletVMs[i],
                              (double) cloudletStartTimes[i], (double) cloudletFinishTimes[i],
                              (double) cloudletExecTimes[i], waitingTime);
        }

        // Step 4: VM Resource Utilization
        System.out.println("\nVM Resource Utilization (mock % CPU, % RAM):\n");
        for (String vm : vms) {
            int cpuUsage = 50 + rand.nextInt(51); // 50-100%
            int ramUsage = 40 + rand.nextInt(61); // 40-100%
            System.out.println(vm + ": " + cpuUsage + "% CPU, " + ramUsage + "% RAM");
        }

        System.out.println("\n=== Simulation Complete ===");
    }