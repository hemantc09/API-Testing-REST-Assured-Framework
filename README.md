# API-Testing-REST-Assured-Framework
# Steps to Import the project in eclipse and execute test suite 

**Technology Used:**
1. RestAssured Java API
2. TestNG Framework 
3. Report and logger for generating reports and logs.

**Github repository:**  https://github.com/hemantc09/API-Testing-REST-Assured-Framework

**Steps to import project**
- Download repo from [https://github.com/hemantc09/API-Testing-REST-Assured-Framework] [FoxApiTestingTest.zip]  unzip it
- Go to Eclipse > File > Import > Existing Projects into Workspace
- Click on Next 
- Click on Browse
- Select the Folder “FoxApiTestingTest”
- Click on Open
- Click Finish

Note: Once you Imported the project in eclipse Make sure the project directory is there. 

See Example below: This is the folder structure . 



[![folder Structure eclipse ](https://i.postimg.cc/nLCVHS0W/Screen-Shot-2019-11-21-at-9-47-41-AM.png "folder Structure eclipse ")](https://i.postimg.cc/nLCVHS0W/Screen-Shot-2019-11-21-at-9-47-41-AM.png "folder Structure eclipse ")


**Note:**
Once you have same folder structure imported wait for a while until maven download all the dependencies. 

**Now you all set to run the project.**

### It has following this implemented. 
1. Register Test Case Class
2. Login Test Case Class
3. Reset Test Case Class

Each Test Class has multiple test cases created . Also I have added comments in each class.


**1. Steps to Run the Test suite using Maven**

------------


- Right click on pom.xml file in the project directory level
- Select Run As > 6.Maven Test

*Note: Now your test suit is running. It will log all the success or errors on the eclipse console*

**Steps to see the results using report.html**

Go to Report Directory
Right click foxReport.html > Open With WebBrowser
This will open the report in WebBrowser and it will show the entire test suite report

**2. Steps to Run the Test suite using TestNG**

------------



Right click on tsetng.xml file in the project directory level
Select Run As >  TestNG Suite

*Note: Now your test suit is running. It will log all the success or errors on the eclipse console*


**Steps to see the results using report.html**

- Go to test-output Directory
- Right click index.html > Open With WebBrowser
- This will open the index.html in WebBrowser and it will show the entire test suite report

**File shared:**
https://drive.google.com/file/d/1Tddrl0UNO90Hai1zS5U4hKu3paWN-9Iy/view?usp=sharing


**Note:**
- Entire test suite is verified and work as expected with no errors. 
- you might see authentication key error or email id errors. make sure to update those
- Email me for any help: hemantc09@gmail.com



Regards,
Hemant 

Have a great day


