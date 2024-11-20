I have covered all functional requirements/Bonus in the framework. Below are some highlights:

Tests are runnable from the command line. Executer needs to have maven installed in the machine. Executer needs to clone/download the project from the mentioned repo: git@github.com:preeti14nov/QuantumTest.git and run command mvn run in command prompt. Test Script will start executing which can be seen in the logs in command prompt.

Test run has been configured inside config.poperties file at project root folder only from where we can can change the URL

Framework is designed to support cross browser testing, As of now, Entore script will gets executed in 3 browsers: Chrome, Firefos & edge parallely.

There are 2 option to pass the Test Data or environment variables, either inside Test data excel sheet or config.properties file. I have used Test Data excel sheet for keeping the test data and we can place the environment variables inside config.properties file in key-value format.

Tests are running in parallel on 3 browsers, Framework is flexible enough to support more browsers

Post execution, there 2 type of reports which are getting generated. One is emailable-output-report.html inside test-output folder, which is a TestNG report. Another one is extent report which has been implemented to produce customized report which can be seen inside reports folder at project root location. The report name is index.html. This report can further be customized as per need.

All tests run in headless mode once executer executes.

Tests captures screenshots as well in case of failure under Screenshots folder at Project root location. There are 3 subfolders based on the browser where script is getting executed. Further, it automatically creates a date folder inside browser folder for the day script is getting executed. Under Date folder, Screenshots are getting captured with the name of Test Script in case of failure.

Everything in the framework is preety simple and easily maintainable which anyone can understand. A part fromm above componenet, we have 2 xml's as well. One is POM.xml where all required maven dependecies has been placed and another one is our main xml which is getting executed during every run which can be customized further as per need with name 'QuantumAssignments.xml' insie project root location

The actual code can be seen inside subfolders of src directory.

Thanks

Preeti Kumari
