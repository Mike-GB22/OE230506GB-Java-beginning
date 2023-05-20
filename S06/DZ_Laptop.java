//2023/05/19 mip
package S06;

import java.util.Map;

public class DZ_Laptop {
    private String model;
    private Integer ram;
    private Integer hdd;
    private String os;
    private String color;

    public DZ_Laptop(String model, Integer ram, Integer hdd, String os, String color){
        this.model = model;
        if (ram < 1) {throw new IllegalStateException("RAM less than 1Gb");}
        this.ram = ram;
        if (ram < 1) {throw new IllegalStateException("HDD less than 1Gb");}        
        this.hdd = hdd;
        this.os = os;
        if(color == null || color.equals("")) {color = "black";}
        this.color = color;
    }

    public boolean isThisLaptopInFilter(Map<String, Object> mapFilter){
        if(mapFilter.containsKey("ram")){
            if(ram < (Integer)mapFilter.get("ram")) return false;
        }
        if(mapFilter.containsKey("hdd")){
            if(hdd < (Integer)mapFilter.get("hdd")) return false;
        }
        if(mapFilter.containsKey("os")){
            if(!os.equals((String)mapFilter.get("os"))) return false;
        }
        if(mapFilter.containsKey("color")){
            if(!color.equals((String)mapFilter.get("color"))) return false;
        }
                
        return true;
    }

    public String toString(){
        return String.format("\n[Model: %s (RAM: %d; HDD: %d; OS: %s; Color: %s)]", model, ram, hdd, os, color);
    }

    public String getModel(){
        return model;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
      
}
