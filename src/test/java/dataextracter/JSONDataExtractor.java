package dataextracter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import enums.JSONKeys;
import frameconstans.FrameConstants;

public final class JSONDataExtractor {
	
	private JSONDataExtractor() {}
	
	public static HashMap<String,Object> getJSONData() throws StreamReadException, DatabindException, IOException{
		
		return new ObjectMapper().readValue(new File(FrameConstants.getJsonFilePath()), new TypeReference<HashMap<String,Object>>() {
		});
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		List<String> list = (List<String>) getJSONData().get(JSONKeys.PASSWORD.toString().toLowerCase());
		
		System.out.println(list);

	}
	
	
	
	
}
