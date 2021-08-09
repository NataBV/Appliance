package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.criteria.SearchCriteria;

public class TabletPC implements Appliance{
	
	private String batCapacity, dispInchs, memRom, flashMemCapacity, color;

	public TabletPC(String batCapacity, String dispInchs, String memRom, String flashMemCapacity, String color) {

		this.batCapacity = batCapacity;
		this.dispInchs = dispInchs;
		this.memRom = memRom;
		this.flashMemCapacity = flashMemCapacity;
		this.color = color;
		
	}

	public TabletPC(Map<String, Object> tabletDetails) {
		
		this.batCapacity = (String)tabletDetails.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString());
		this.dispInchs = (String)tabletDetails.get(SearchCriteria.TabletPC.DISPLAY_INCHES.toString());
		this.memRom = (String)tabletDetails.get(SearchCriteria.TabletPC.MEMORY_ROM.toString());
		this.flashMemCapacity = (String)tabletDetails.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString());
		this.color = (String)tabletDetails.get(SearchCriteria.TabletPC.COLOR.toString());
		
	}
	
	@Override
	public Map<String, Object> getParametrs() {
		Map<String, Object> parametrs = new HashMap<String, Object>();
		parametrs.put("BATTERY_CAPACITY", batCapacity);
		parametrs.put("DISPLAY_INCHES", dispInchs);
		parametrs.put("MEMORY_ROM", memRom);
		parametrs.put("FLASH_MEMORY_CAPACITY", flashMemCapacity);
		parametrs.put("COLOR", color);
		
		return parametrs;
	}

	
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public String toString() {
		return "TabletPC [batCapacity=" + batCapacity + ", dispInchs="
				+ dispInchs + ", memRom=" + memRom + ", flashMemCapacity="
				+ flashMemCapacity + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batCapacity == null) ? 0 : batCapacity.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((dispInchs == null) ? 0 : dispInchs.hashCode());
		result = prime * result + ((flashMemCapacity == null) ? 0 : flashMemCapacity.hashCode());
		result = prime * result + ((memRom == null) ? 0 : memRom.hashCode());
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
		TabletPC other = (TabletPC) obj;
		if (batCapacity == null) {
			if (other.batCapacity != null)
				return false;
		} else if (!batCapacity.equals(other.batCapacity))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dispInchs == null) {
			if (other.dispInchs != null)
				return false;
		} else if (!dispInchs.equals(other.dispInchs))
			return false;
		if (flashMemCapacity == null) {
			if (other.flashMemCapacity != null)
				return false;
		} else if (!flashMemCapacity.equals(other.flashMemCapacity))
			return false;
		if (memRom == null) {
			if (other.memRom != null)
				return false;
		} else if (!memRom.equals(other.memRom))
			return false;
		return true;
	}	
		
}
