package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Laptop implements Appliance{
	// add variables, hash, equals and toString
	// BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000,
	//CPU=1.2, DISPLAY_INCHS=18
	
	private int battCapacity, memoryRoom, sysMemory, dispInchs;
	private double cpu;
	private String os;
	
	public Laptop(int battCapacity, int memoryRoom, int sysMemory,
			int dispInchs, double cpu, String os) { 
		
		this.battCapacity = battCapacity;
		this.memoryRoom = memoryRoom;
		this.sysMemory = sysMemory;
		this.dispInchs = dispInchs;
		this.cpu = cpu;
		this.os = os;
		
	}
	
	public Laptop(Map<String, Object> laptopDetails) { 
		
		this.battCapacity = (int)laptopDetails.get(SearchCriteria.Laptop.BATTERY_CAPACITY.toString());
		this.memoryRoom = (int)laptopDetails.get(SearchCriteria.Laptop.MEMORY_ROM.toString());
		this.sysMemory = (int)laptopDetails.get(SearchCriteria.Laptop.SYSTEM_MEMORY.toString());
		this.dispInchs = (int)laptopDetails.get(SearchCriteria.Laptop.DISPLAY_INCHS.toString());
		this.cpu = (double)laptopDetails.get(SearchCriteria.Laptop.CPU.toString());
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
	
	/*@Override
	public String toLine() {
		String result = this.getClass().getSimpleName() + " : " + this.parametrs.toString().replace("{", "").replace("}", "") ;
		System.out.println(result);
		return result;
	}*/
	
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	
	
	@Override
	public String toString() {
		return "Laptop [battCapacity=" + battCapacity + ", memoryRoom=" + memoryRoom + ", sysMemory=" + sysMemory
				+ ", dispInchs=" + dispInchs + ", cpu=" + cpu + ", os=" + os + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + battCapacity;
		long temp;
		temp = Double.doubleToLongBits(cpu);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + dispInchs;
		result = prime * result + memoryRoom;
		result = prime * result + ((os == null) ? 0 : os.hashCode());
		result = prime * result + sysMemory;
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
		if (battCapacity != other.battCapacity)
			return false;
		if (Double.doubleToLongBits(cpu) != Double.doubleToLongBits(other.cpu))
			return false;
		if (dispInchs != other.dispInchs)
			return false;
		if (memoryRoom != other.memoryRoom)
			return false;
		if (os == null) {
			if (other.os != null)
				return false;
		} else if (!os.equals(other.os))
			return false;
		if (sysMemory != other.sysMemory)
			return false;
		return true;
	}
	
	
}
