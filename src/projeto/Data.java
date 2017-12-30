package projeto;

import java.text.*;
import java.util.*;

public class Data {

	protected String StringData(int dia,int mes,int ano) {
		Date data = new GregorianCalendar(ano, mes, dia).getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date_form=format.format(data);
		return date_form;
		
	}
}
