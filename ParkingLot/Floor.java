import java.util.*;
public class Floor {
    HashMap<SlotType, List<Slot>> slotMap;

    public Floor(){

        slotMap = new HashMap<SlotType, List<Slot>>();
        initializeFloor(); 

    }

    private void initializeFloor(){
        List<Slot> slots = new ArrayList<Slot>();
        for(int i=0;i<20;i++){
            Slot slot = new Slot(SlotType.BIG,true,200);
            slots.add(slot);
        }
        slotMap.put(SlotType.BIG, slots);
        
        slots = new ArrayList<Slot>();
        for(int i=0;i<50;i++){
            Slot slot = new Slot(SlotType.MEDIUM,true,100);
            slots.add(slot);
        }
        slotMap.put(SlotType.MEDIUM, slots);
        slots = new ArrayList<Slot>();
        for(int i=0;i<30;i++){
            Slot slot = new Slot(SlotType.SMALL,true,50);
            slots.add(slot);
        }
        slotMap.put(SlotType.SMALL, slots);
    }

    Slot getSlot(SlotType slotType){
        for(Slot slot: slotMap.get(slotType)){
            if(slot.getAvailability()){
                return slot;
            }
        }
        return null;
    }
}
