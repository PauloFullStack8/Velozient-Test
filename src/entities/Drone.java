package entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drone {
    private String name;
    private int maxWeight;
    private List<String> deliveries;

    public Drone(String name, int maxWeight) {
        this.name = name;
        this.maxWeight = maxWeight;
        this.deliveries = new ArrayList<>();
    }

    public Map<String, Object> getInfo() {
        Map<String, Object> info = new HashMap<String, Object>();
        info.put("Name ID", this.name);
        info.put("maximum Weight", this.maxWeight);
        info.put("Address", this.deliveries);

        return info;
    }

    public String getName(){
        return this.name;
    }

    public Integer getWeight(){
        return this.maxWeight;
    }

    public List<String> getDeliveries(){
        return this.deliveries;
    }

    public void addDelivery(String delivery){
        this.deliveries.add(delivery);
    }
    
}
