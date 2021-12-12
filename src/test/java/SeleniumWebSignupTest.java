import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver_win32/chromedriver.exe");
        //1. open your Chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        // Test 1. verify that user input the right URL and on the right web page
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
        System.out.println("wrong page");
        Thread.sleep(5000);
        //3. maximize the browser
        driver.manage().window().maximize();
        //4.Click on the signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

        @Test(priority = 0)
        public void positiveSignup() throws InterruptedException {
            // Test7 verify that user is successfully signup when valid details are inputted
            // Input your username on the username field
            driver.findElement(By.id("user_username")).sendKeys("peace60");
            //6. Locate the email address and input your email address on the email field
            driver.findElement(By.id("user_email")).sendKeys("peace60@gmail.com");
            //7. Locate the password and input the password on the password field
            driver.findElement(By.id("user_password")).sendKeys("Admin1");
            //8.Click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);

    }
    @Test(priority =1)
    public void clickUser1Item() throws InterruptedException {
        //9. click on the User1 on the listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test2 verify that when user click on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct Url page");
        else
            //fail
            System.out.println("wrong Url page");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (Using python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test9 Verify that item search for user1 page is present
        String expectedpageUrl = "/users/1";
        String actualpageUrl =driver.getCurrentUrl();
        if (actualpageUrl.contains(expectedpageUrl))
            //pass
            System.out.println("current User1Page");
        else
            //fail
            System.out.println("wrong User1Page");
        Thread.sleep(5000);

    }
    @Test (priority = 3)
     public void logoutSuccessfully(){
        //11. Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test10 verify that whe the user logout, he/she is directed back to home page
        String expectedTittle = "AlphaBlog";
        String actualTittle = driver.getTitle();
        if (expectedTittle.contains(actualTittle))
            //pass
            System.out.println("Correct webpage");
        else
            //fail
            System.out.println("wrong webpage");

    }
    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        //Click on the signup button to open the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        // Test3 verify that user cannot signup with username less than 3 characters
        //5.Locate the username and input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("pe");
        //6. Locate the email address and input your email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("peace50@gmail.com");
        //7. Locate the password and input the password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Admin1");
        //8.Click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

    }

    @AfterTest
       public void closeBrowser() {
        //Quit the browser
            driver.quit();

    }
}