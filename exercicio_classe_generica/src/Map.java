public class Map <tipo1,tipo2>{
		
	tipo1 chaves[];
	tipo2 values[];
	
	int ultimo;
	
	@SuppressWarnings("unchecked")
	public Map (){
		chaves = (tipo1[]) new Object[100];
		values = (tipo2[]) new Object[100];

		ultimo = 0;
	}
	
	/*
	public void add(tipo1 key, tipo2 value) {
		chaves[ultimo] = key;
		values[ultimo] = value;
		ultimo++;
	}*/
	
	public void add(tipo1 key, tipo2 value) {
		chaves[ultimo] = key;
		values[(int)key] = value;
		ultimo++;
	}
	
	public tipo2 getValue(tipo1 key) {
		return values[(int)key];
	}
	
	public boolean containsKey(tipo1 key) {
		if(values[(int)key] == null) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public boolean containsValue(tipo2 value) {
		for(int i = 0; i < ultimo; i++) {
			if(values[(int)chaves[i]].equals(value)){
				return true;	
			}
		}
		
		return false;
	}

}
