@ICICLogin
Feature: ICICI bank Login with diffrent credintioal

Background: 
Given Launch ICICI Url
@Login1
Scenario: ICICI Bank Login page with valid, invalid , null datas and Logins with detailed Report
When Mouse hover to Login and Select personal Banking 
And Enter User id
|nitheesh|nitheesh@12|nitheesh2323 | 
And Enter Password
|pass1|pass2|pass3| 
And Select Fund Transfer Option 
And Click Login
Then Close the session

@Login2
Scenario Outline: ICICI Bank Login page with valid, invalid , null datas and Logins with detailed Report
Given Launch ICICI Url
When Mouse hover to Login and Select personal Banking 
And Enter User "<username>" id
And Enter "<password>" Password 
And Select Fund Transfer Option 
And Click Login
Then Close the session 

Examples:
|username|password|
|nitheesh|Nitheesh@123|
|Nithi|Nikhi@123|
|Ram|Ramu@*123|