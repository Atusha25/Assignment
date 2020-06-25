
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonComparision {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonStringActual ="{\r\n" + 
				"	\"audienceSegments\": [56047, 30060],\r\n" + 
				"	\"browsers\": [],\r\n" + 
				"	\"carriers\": null,\r\n" + 
				"	\"ownerType\": 7,\r\n" + 
				"	\"geos\": [\"UK\", \"USA\"],\r\n" + 
				"	\"domainList\": [\"abc.com\"],\r\n" + 
				"	\"latLong\": \"false\",\r\n" + 
				"	\"data\": {\r\n" + 
				"		\"segment_id\": [\"Aud_1\"],\r\n" + 
				"		\"price\": 31.22\r\n" + 
				"	}\r\n" + 
				"}";
		
		String jsonStringExpected ="{\r\n" + 
				"	\"data\": {\r\n" + 
				"		\"price\": 31.22,\r\n" + 
				"		\"segment_id\": [\"Aud_1\"]\r\n" + 
				"	},\r\n" + 
				"	\"audienceSegments\": [56047, 30060],\r\n" + 
				"	\"browsers\": [],\r\n" + 
				"	\"carriers\": null,\r\n" + 
				"	\"ownerType\": 7,\r\n" + 
				"	\"geos\": [\"UK\", \"USA\"],\r\n" + 
				"	\"domainList\": [\"abc.com\"]\r\n" + 
				"}";


	Map<String, Object> m1 = mapper.readValue(jsonStringActual, Map.class);
	Map<String, Object> m2 = mapper.readValue(jsonStringExpected, Map.class);
	System.out.println(m1);
	System.out.println(m2);
	
	boolean isCurrentNodeEqual = false;
	for(Map.Entry<String,Object> entry: m1.entrySet()) {
		String actualMapEntry = entry.getKey();
		Object actualMapValue =entry.getValue();
		isCurrentNodeEqual = false;
		if(!m2.containsKey(actualMapEntry)) {
			isCurrentNodeEqual = true;
		}
		else {
			for(Map.Entry<String, Object> entry2: m2.entrySet()) {
				String ExpectedMapEntry = entry2.getKey();
				Object ExpectedMapValue =entry2.getValue();
				if(actualMapEntry.equals(ExpectedMapEntry)) {
					if(null!=actualMapValue &&  actualMapValue.equals(ExpectedMapValue)) {
						isCurrentNodeEqual = true;
						break;
					}else if(null==actualMapValue && null==ExpectedMapValue) {
						isCurrentNodeEqual = true;
						break;
					}
					
				}
			}
		}
	
		
		if(!isCurrentNodeEqual) {
			break;
		}
	}
	
	if(isCurrentNodeEqual) {
		System.out.println("True");
	}else {
		System.out.println("False");
	}
	
	
	
	}}
