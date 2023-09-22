from selenium import webdriver
import time

from selenium.webdriver.common.by import By
from webdriver_manager.chrome import (ChromeDriverManager)
from selenium.webdriver.chrome.service import Service as ChromeService

# Initialize Chrome driver instance
driver = webdriver.Chrome(service=ChromeService(executable_path=ChromeDriverManager().install()))

# Navigate to the url
driver.get("https://www.makemytrip.com/flights/?cmp=SEM|M|DF|B|Brand|B_M_Makemytrip_Search_Exact|Brand_Top_5_Exact|Expanded|&s_kwcid=AL!1631!3!!e!!o!!makemytrip.&ef_id=27aeb12bbbc31b94b196d42e1d50db9b:G:s&msclkid=27aeb12bbbc31b94b196d42e1d50db9b")
driver.maximize_window()
time.sleep(1)
driver.refresh()
time.sleep(2)
driver.find_element(By.XPATH,"/html/body/div[1]/div/div[1]/div[1]/div[2]/div[2]/div/section/span").click()
time.sleep(2)#click flights tab
#flights_tab = str(driver.find_element(By.XPATH("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div/nav/ul/li[1]/div/a/span[2]")))
#flights_tab.click()
#click on roundtrip
driver.find_element(By.XPATH,"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]").click()
time.sleep(2)
driver.find_element(By.XPATH,"/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]").click()
time.sleep(2)
driver.find_element(By.XPATH,"//input[@placeholder='From']").send_keys("HYD")
time.sleep(2)
driver.find_element(By.XPATH,"//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='calc60']").click()
time.sleep(1)
driver.find_element(By.XPATH,"//span[normalize-space()='To']").click()
time.sleep(1)
driver.find_element(By.XPATH,"//input[@placeholder='To']").send_keys("MAA")
time.sleep(3)
driver.find_element(By.XPATH,"//li[@id='react-autowhatever-1-section-0-item-0']//div[@class='calc60']").click()
time.sleep(4)
driver.find_element(By.XPATH,"//div[@aria-label='Sun Oct 08 2023']//div[@class='dateInnerCell']").click()
time.sleep(5)
driver.find_element(By.XPATH,"//div[@aria-label='Fri Oct 13 2023']//p[contains(text(),'13')]").click()
time.sleep(2)
driver.find_element(By.XPATH,"//a[contains(@class,'primaryBtn font24 latoBold widgetSearchBtn')]").click()
time.sleep(16)
driver.find_element(By.XPATH,"/html/body/div[1]/div/div[2]/div[2]/div[2]/div/span").click()
time.sleep(20)

element = driver.find_element(By.XPATH,"/html/body/div[1]/div/div[2]/div[2]/div/div[2]/p/span")

search_text = "Flights from Hyderabad to Chennai, and back"
if search_text in element.text:
    print(f"The element contains the {search_text}.")
else:
    print(f"The element does not contain the search text: {search_text}.")

time.sleep(8)

driver.quit()
