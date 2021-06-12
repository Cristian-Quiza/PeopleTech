package co.com.middleware.broker;


public class WrapperJSON<T> {
 
    private final T wrapperJSON;
 
    public WrapperJSON(T wrapperJSON) {
        this.wrapperJSON = wrapperJSON;
    }

	public T getWrapperJSON() {
		return wrapperJSON;
	}
 
    
    
}
