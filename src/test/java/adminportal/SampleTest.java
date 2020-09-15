package adminportal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void openBrowser(){
        System.out.println("Before class 1");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }
    @AfterClass
    public static void closeBrowser(){
        System.out.println("After class 1");
        driver.quit();
    }

    @Before
    public void login(){
        System.out.println("Before");
        driver.get("http://bananaappsuser15-001-site1.gtempurl.com/Admin");
        driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.id("Password")).sendKeys("adminadmin");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Assert.assertEquals(driver.findElement(By.className("content-header")).getText(),"Dashboard");
    }
    @After
    public void logout(){
        System.out.println("After");
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void testcase1(){
        System.out.println("Test Case 1");
    }

    @Test
    public void testcase2(){
        System.out.println("Test Case 2");
    }


}
