package co.com.middleware.broker;

import java.util.List;

public class WrapperJSONArray<T> {
 
    private final List<T> wrapperJSON;
 
    public WrapperJSONArray(List<T> wrapperJSON) {
        this.wrapperJSON = wrapperJSON;
    }

	public List<T> getWrapperJSON() {
		return wrapperJSON;
	}
 
    
    
}
