#Author: chaithanya kommineni

@tag
Feature: Functionality of github
Background:
Given Open browser as "firefox" And enter url as "https://github.com/"
@tag1
Scenario: Validation of github login

When Enter username <username> And password <password> And click on sign in button
	|chaithanyakommineni|9492055182k|
Then Successfully login github

@tag2
Scenario: invalid of github login
When Enter username <username> And password <password> And click on sign in button
	|chaithanyakommineni|9492055182|
Then unSuccessfully login github
@tag3
Scenario Outline: valid login github

When Enter username "<username>" And password "<password>" And click on sign in button
	
Then unSuccessfully login github
Examples:
|username|password|
|chaithanyakommineni|9492055182k|
|chaithanyakommineni|9492055182|
|chaithanyakommineni|9492055182k|