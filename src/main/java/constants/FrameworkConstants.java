package constants;

import java.time.Duration;

public final class FrameworkConstants {
	
	private FrameworkConstants ()
	{
		
	}
	public static  final Duration timeout_wait= Duration.ofSeconds(10);

	public static final  String config_path = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
	public static final  String exel_path = System.getProperty("user.dir") + "\\testdata\\Book2.xlsx";
	public static final  String sc_path = System.getProperty("user.dir")+"\\Screenshots\\";
	public static final  String report_path =System.getProperty("user.dir")+"/Reports/" ;
	
	

	
	
}
