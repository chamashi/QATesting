# OrangeHRM Selenium Tests

This repository contains Selenium-based automated tests for the OrangeHRM application.

## Test Files

### `Login.java`

This test file contains the following login functionality tests:

1. **InvalidLoginOne**: Tests if a user can log in without entering credentials.
2. **InvalidLoginTwo**: Tests if a user can log in with a correct username and an incorrect password.
3. **InvalidLoginThree**: Tests if a user can log in with an incorrect username and a correct password.
4. **InvalidLoginFour**: Tests if a user can log in with an incorrect username and an incorrect password.
5. **ValidLogin**: Tests if a user can log in with correct credentials.

### `ToggleMenu.java`

This test file contains the following menu and timesheet functionality tests:

1. **Toggle**: Tests the toggle menu functionality.
2. **ToggleTimeFeature**: Tests the time feature within the toggle menu.
3. **SelectEmployee**: Tests selecting an employee from the timesheet view.
4. **CreateTimesheet**: Tests creating a timesheet.
5. **EditTimesheetBTN**: Tests the edit timesheet button.
6. **EditTimesheetFeature**: Tests the edit timesheet functionality, including adding/deleting rows and resetting.
7. **ApproveTimesheet**: Tests approving a timesheet.

## Setup and Execution

### Prerequisites

- Java JDK
- Maven
- ChromeDriver
- TestNG
- Selenium WebDriver
- Chrome browser
