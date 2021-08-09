package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Laptop implements Appliance{
	
	private String battCapacity, memoryRoom, sysMemory, dispInchs, cpu, os;
	

	public Laptop(String battCapacity, String memoryRoom, String sysMemory,
			String dispInchs, String cpu, String os) {
		
		super();
		this.battCapacity = battCapacity;
		this.memoryRoom = memoryRoom;
		this.sysMemory = sysMemory;
		this.dispInchs = dispInchs;
		this.cpu = cpu;
		this.os = os;
		
	}

	public Laptop(Map<String, Object> laptopDetails) { 
		
		this.battCapacity = (String)laptopDetails.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString());
		this.memoryRoom = (String)laptopDetails.get(SearchCriteria.Laptop.MEMORY_ROM.toString());
		this.sysMemory = (String)laptopDetails.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString());
		this.dispInchs = (String)laptopDetails.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString());
		this.cpu = (String)laptopDetails.get(SearchCriteria.Laptop.CPU.toString());
		this.os = (String)laptopDetails.get(SearchCriteria.Laptop.OS.toString());
		
	}
	
	@Override
	public Map<String, Object> getParametrs() {
		Map<String, Object> parametrs = new HashMap<String, Object>();
		parametrs.put("BATTERY_CAPACITY", battCapacity);
		parametrs.put("MEMORY_ROM", memoryRoom);
		parametrs.put("SYSTEM_MEMORY", sysMemory);
		parametrs.put("DISPLAY_INCHS", dispInchs);
		parametrs.put("CPU", cpu);
		parametrs.put("OS", os);
		
		return parametrs;
	}
	
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	
	
	@Override
	public String toString() {
		return "Laptop [battCapacity=" + battCapacity + ", memoryRoom="
				+ memoryRoom + ", sysMemory=" + sysMemory + ", dispInchs="
				+ dispInchs + ", cpu=" + cpu + ", os=" + os + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((battCapacity == null) ? 0 : battCapacity.hashCode());
		result = prime * result + ((cpu == null) ? 0 : cpu.hashCode());
		result = prime * result + ((dispInchs == null) ? 0 : dispInchs.hashCode());
		result = prime * result + ((memoryRoom == null) ? 0 : memoryRoom.hashCode());
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + ((sysMemory == null) ? 0 : sysMemory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (battCapacity == null) {
			if (other.battCapacity != null)
				return false;
		} else if (!battCapacity.equals(other.battCapacity))
			return false;
		if (cpu == null) {
			if (other.cpu != null)
				return false;
		} else if (!cpu.equals(other.cpu))
			return false;
		if (dispInchs == null) {
			if (other.dispInchs != null)
				return false;
		} else if (!dispInchs.equals(other.dispInchs))
			return false;
		if (memoryRoom == null) {
			if (other.memoryRoom != null)
				return false;
		} else if (!memoryRoom.equals(other.memoryRoom))
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (sysMemory == null) {
			if (other.sysMemory != null)
				return false;
		} else if (!sysMemory.equals(other.sysMemory))
			return false;
		return true;
	}

	
	
}
