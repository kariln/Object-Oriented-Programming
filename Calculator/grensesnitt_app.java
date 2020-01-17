package app;

import java.io.File;

	public interface grensesnitt_app{

		public void vise(Integer input1, Integer input2, String operator, double svar, File fil);
		public String lese(File fil);

}
