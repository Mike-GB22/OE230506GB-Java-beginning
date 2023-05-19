package S06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DZ_Task {
    public static void main(String[] args) {
        Set<DZ_Laptop> laptops = new HashSet<>();
        
        laptops.add(new DZ_Laptop("Asus A1", 32, 2000, "Windows 95", "red"));
        laptops.add(new DZ_Laptop("Acer H8", 16, 1200, "Windows 98", "green"));
        laptops.add(new DZ_Laptop("Apfel Pro", 2, 128, "MacOS", "white"));
        laptops.add(new DZ_Laptop("Apple Pro", 8, 128, "MacOS", "white"));        
        System.out.println("\n-------------------------------");
        System.out.println("We have laptops:");
        System.out.println(laptops);

        
        Map<String, Object> mapToFind =  getFiltersFromConsole();
    
        
        Set<DZ_Laptop> weHaveFoundLaptops = new HashSet<>();        
        for (DZ_Laptop dz_Laptop : laptops) {
            if(dz_Laptop.isThisLaptopInFilter(mapToFind)){
                weHaveFoundLaptops.add(dz_Laptop);
            }
        }

        System.out.println("\n-------------------------------");
        System.out.print("We have filters: ");
        System.out.println(mapToFind.toString());
        System.out.println("We have found laptops:");
        System.out.println(weHaveFoundLaptops);
    }

    public static Map<String, Object> getFiltersFromConsole(){
        Map<String, Object> mapToFind = new HashMap<>();
        
        System.out.println("\n-------------------------------");
        System.out.print("Input date to filter: ");
        
        Scanner scan = new Scanner(System.in);

        System.out.print ("RAM (Gb): ");
        String ram = scan.nextLine();
        try{
            int ramInt = Integer.parseInt(ram);
            if (ramInt >=1) mapToFind.put("ram", ramInt);
        } catch (Exception ex) {}
        
        System.out.print ("HDD (Gb): ");
        String hdd = scan.nextLine();        
        try{
            int hddInt = Integer.parseInt(hdd);
            if (hddInt >=1) mapToFind.put("hdd", hddInt);
        } catch (Exception ex) {}
        
        System.out.print ("OS: ");
        String os = scan.nextLine();                
            if(os != null && !os.equals("")) mapToFind.put("os", os);

        System.out.print ("Color: ");            
        String color = scan.nextLine();                
            if(color != null && !color.equals("")) mapToFind.put("color", color);

        //mapToFind.put("ram", 10);
    return mapToFind;
    }
}
