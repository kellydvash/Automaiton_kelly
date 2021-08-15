import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;
public class Main {
    public static Finals finals = new Finals();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your username");
        String username = scanner.nextLine();
        System.out.println("please enter your password");
        String password = scanner.nextLine();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\kelly\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        driver.manage().window().maximize();
        List<WebElement> elementList = driver.findElements(By.className("top-header-menu"));
        WebElement topMenu = elementList.get(finals.getFIRST_OBJECT());
        List<WebElement> topMenuItems = topMenu.findElements(By.tagName("li"));
        WebElement personalInfo = topMenuItems.get(finals.getPERSONAL_INFO());
        personalInfo.click();
        PAUSE();
        WebElement usernameBox = driver.findElement(By.id("Ecom_User_ID"));
        if (usernameBox != null) {
            usernameBox.sendKeys(username); }
        PAUSE();
        WebElement passwordBox = driver.findElement(By.id("Ecom_Password"));
        if (passwordBox != null) {
            passwordBox.sendKeys(password);
        }
        PAUSE();
        WebElement logIn = driver.findElement(By.id("wp-submit"));
        logIn.click();
        PAUSE();
        List<WebElement> loginOptions = driver.findElements(By.className("row"));
        WebElement rowSelection = loginOptions.get(finals.getMENU_CHOSE());
        List<WebElement> moodleRowSelection = rowSelection.findElements(By.tagName("div"));
        WebElement moodleButton = moodleRowSelection.get(finals.getFIRST_OBJECT());
        moodleButton.click();
        PAUSE();
        List<WebElement> optionalCourses = driver.findElements(By.className("multiline"));
        printOptionalCourses(optionalCourses);
        System.out.println("please choose one of the courses");
        int option = scanner.nextInt();
        WebElement selectedCourse = selectedCourse(optionalCourses,option);
        selectedCourse.click();
        PAUSE();
        WebElement menu = driver.findElement(By.id("action-menu-toggle-1"));
        menu.click();
        WebElement disconnectButton = driver.findElement(By.id("actionmenuaction-6"));
        disconnectButton.click();
        PAUSE();

        List<WebElement> topList = driver.findElements(By.id("menu-top-header"));
        WebElement optionList = topList.get(finals.getFIRST_OBJECT());
        List<WebElement> disconnectMoodle = optionList.findElements(By.tagName("li"));
        WebElement disconnect = disconnectMoodle.get(finals.getDISCONNECT_CHOSE());
        disconnect.click();

    }
    public static void PAUSE() {
        try { Thread.sleep(finals.getPAUSE());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void printOptionalCourses(List<WebElement> optionalCourses) {
        for (int i=0; i<optionalCourses.size();i++) {
            System.out.println(i + "-" + optionalCourses.get(i).getText());
        }
    }
    public static WebElement selectedCourse(List<WebElement> courseList, int choice) {
        WebElement selectedCourse =courseList.get(finals.getFIRST_OBJECT());
        for (int i=0; i<courseList.size();i++) {
            if (choice == i) {
                selectedCourse =  courseList.get(i);
            }
        }
        return selectedCourse;
    }

}