package by.tc.task01.entity;

import java.util.HashMap;
import java.util.Map;

import by.tc.task01.entity.criteria.SearchCriteria;

public class Speakers implements Appliance{
	
	private String powerCon, numOfSpeakers, cordLength, freqRange;
	//class with plurally title 
	
	public Speakers(String powerCon, String numOfSpeakers, String cordLength,
			String freqRange) {

		this.powerCon = powerCon;
		this.numOfSpeakers = numOfSpeakers;
		this.cordLength = cordLength;
		this.freqRange = freqRange;
		
	}

	public Speakers(Map<String, Object> speakersDetails) { 
		
		this.powerCon = (String)speakersDetails.get(SearchCriteria.Speakers.POWER_CONSUMPTION.toString());
		this.numOfSpeakers = (String)speakersDetails.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString());
		this.cordLength = (String)speakersDetails.get(SearchCriteria.Speakers.CORD_LENGTH.toString());
		this.freqRange = (String)speakersDetails.get(SearchCriteria.Speakers.FREQUENCY_RANGE.toString());
		
	}

		@Override
		public Map<String, Object> getParametrs() {
			Map<String, Object> parametrs = new HashMap<String, Object>();
			parametrs.put("POWER_CONSUMPTION", powerCon);
			parametrs.put("NUMBER_OF_SPEAKERS", numOfSpeakers);
			parametrs.put("CORD_LENGTH", cordLength);
			parametrs.put("FREQUENCY_RANGE", freqRange);
			
			return parametrs;
		}
		
		@Override
		public String getClassName() {
			return this.getClass().getSimpleName();
		}

		@Override
		public String toString() {
			return "Speakers [powerCon=" + powerCon + ", numOfSpeakers="
					+ numOfSpeakers + ", cordLength=" + cordLength
					+ ", freqRange=" + freqRange + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cordLength == null) ? 0 : cordLength.hashCode());
			result = prime * result + ((freqRange == null) ? 0 : freqRange.hashCode());
			result = prime * result + ((numOfSpeakers == null) ? 0 : numOfSpeakers.hashCode());
			result = prime * result + ((powerCon == null) ? 0 : powerCon.hashCode());
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
			Speakers other = (Speakers) obj;
			if (cordLength == null) {
				if (other.cordLength != null)
					return false;
			} else if (!cordLength.equals(other.cordLength))
				return false;
			if (freqRange == null) {
				if (other.freqRange != null)
					return false;
			} else if (!freqRange.equals(other.freqRange))
				return false;
			if (numOfSpeakers == null) {
				if (other.numOfSpeakers != null)
					return false;
			} else if (!numOfSpeakers.equals(other.numOfSpeakers))
				return false;
			if (powerCon == null) {
				if (other.powerCon != null)
					return false;
			} else if (!powerCon.equals(other.powerCon))
				return false;
			return true;
		}

		
		
}
