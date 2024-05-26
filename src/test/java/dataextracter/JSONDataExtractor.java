package dataextracter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import frameconstans.FrameConstants;

public final class JSONDataExtractor {
	
	private JSONDataExtractor() {}
	
	public static HashMap<String,Object> getJSONData() throws StreamReadException, DatabindException, IOException{
		
		return new ObjectMapper().readValue(new File(FrameConstants.getJsonFilePath()), new TypeReference<HashMap<String,Object>>() {
		});
		
	}
	
	
	

}
