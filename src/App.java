import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entities.Drone;


public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        List<Drone> drones = new ArrayList<>();
        List<String> deliveryData = new ArrayList<>();

        List<String> droneData = Arrays.asList(scanner.nextLine().split(", "));

        registerNewDrone(droneData, drones);

        registerDelivery(scanner, deliveryData);

        scanner.close();
        
        calculeDroneDelivery(deliveryData, drones);

        presentationData(drones);

    }

    private static void registerNewDrone(List<String> droneData, List<Drone> drones) {
        for (int i = 0; i < droneData.size(); i += 2) {
            String droneName = droneData.get(i);
            int maxWeight = Integer.parseInt(droneData.get(i + 1));
            drones.add(new Drone(droneName, maxWeight));
        }
    }

    private static void registerDelivery(Scanner scanner, List<String> deliveryData) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                break;
            }
            deliveryData.add(line);
        }
    }

    private static void calculeDroneDelivery(List<String> deliveryData, List<Drone> drones) {
        for (String delivery : deliveryData) {

            List<String> deliveryInfo = Arrays.asList(delivery.split(", "));

            String locationName = deliveryInfo.get(0);
            int packageWeight = Integer.parseInt(deliveryInfo.get(1));
            int minDeliveries = Integer.MAX_VALUE;

            for (Drone drone : drones) {
                if (drone.getWeight() >= packageWeight && drone.getDeliveries().size() < minDeliveries) {
                    drone.addDelivery(locationName);
                    minDeliveries = drone.getDeliveries().size();
                }
            }
        }

    }

    private static void presentationData(List<Drone> drones) {
        for (Drone drone : drones) {
            System.out.println("Drone id: " + drone.getName());
            int tripCount = 1;

            for (String delivery : drone.getDeliveries()) {
                System.out.println("--> Trip #" + tripCount);
                System.out.println("------> Location: " + delivery);
                tripCount++;
            }
            System.out.println();
        }
    }

}
