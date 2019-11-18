package company;
import rate.*;
public class DianximCompany implements Company{

	public Rate producerate() {
		return new DianxinRate();
	}
   
}
