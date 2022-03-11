package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	protected AppiumDriver driver;
//	private final static String APP_APK_NAME = "ApiDemos-debug.apk";
//	private final static String DEVICE_NAME = "Pixel_4_API_30";
//	private final static String HOST_URL = "http://127.0.0.1:4723/wd/hub";
	private static AppiumDriverLocalService service;
	private Properties props;

	@BeforeTest
	public void beforeTest() throws IOException, InterruptedException {
//		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		props = load_global_variables("src", "global.properties");
		startServer();
//		startEmulator(props.getProperty("device"),props.getProperty("emulatorPath"));
		startEmulator();

		File app = new File(props.getProperty("App"));

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, (String) props.getProperty("Device"));

		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "200");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AppiumDriver(service.getUrl(), capabilities);
	}

	public void startServer() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}

//	public void startEmulator(String deviceName, String emulatorPath) throws IOException, InterruptedException {
//		p = Runtime.getRuntime().exec("cd /d " +emulatorPath+ " && emulator -avd " +deviceName);
//		p.waitFor();
//	}
	
	public void startEmulator() throws IOException, InterruptedException {
		Process p = Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
//		Thread.sleep(6000);
		p.waitFor(6, TimeUnit.SECONDS);
	}

	public Properties load_global_variables(String path, String appName) throws IOException {
		Properties props = new Properties();
		File global_properties = new File(path, appName);
		FileInputStream file = new FileInputStream(global_properties.getAbsolutePath());
		props.load(file);
		return props;
	}

	@AfterTest
	public void afterTest() throws IOException {
		if (driver != null) {
			driver.closeApp();
		}
		if (service != null) {
			service.stop();
		}
		killEmulator();
	}
	
	public void killEmulator() throws IOException {
		Runtime.getRuntime().exec("adb emu kill");
	}

}
