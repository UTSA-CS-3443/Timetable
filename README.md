# Project Timetable

A Simple Event and Todo Management Tool, that helps you stay on your personal schedule.

## Description

Events can be entered in on any time table that the user wishes, and a static To-Do list is available for general time-insensitive projects. The app would remind the user a set time before the event, or should the user wish to prioritize the event, the app would progressively more aggressively send reminders to the user until the user marks the event as complete. The app would be lightweight, but have pop ups and audio notifications.

## Getting Started

### Dependencies

* Java SE 9 and or higher.


### Installing

* Navigate to the Timetable Repository: https://github.com/Anthrac1t3/Project-Timetable
* Click the "Code" Dropdown for cloning the code, then select your preferred method. (E.g Download Zip, or Copying the link, etc)
* You now have a copy of the program!


### Executing program

* Once the program is downloaded, you can choose one of two options.
1. Running the provided executable.
2. Opening and running the program in an IDE (E.g Eclipse, Intellij)
* Ensure to add the below line of text into your vim arguments in the IDE (Eclipse):
* Click Run, then Run Configurations
* Navigate to the Arguments tab, then the VM Arguments section.
* Paste in the line below, then hit Apply.
* *Note: This is to add the correct module path and modules to the application.
```
--module-path "C:\JavaFX\javafx-sdk-17.0.0.1\lib" --add-modules javafx.controls,javafx.fxml,javafx.media
```


## Help

Common Issues:
* Creating too long of Todo statements to where they drift off the page.
* Creating Events with an End Date that is before the Start Date. (Program allows the addition of the event, but will not display on Calendar)
* Creating too many events on one day will start to overlap the colored event tiles from different days below it.


## Authors

1. Connor Acred
2. Brian Bissland
3. Austen Green
4. Cole Holub


## Version History

* 0.1
    * Initial Release of the Calendar interface with Events, Todo's and Settings.

* Future Release Updates:
   * Fixing the aforementioned Common Issues.
   * When you click a day, then Add Event, it will use the selected date for the Start Date and End Date fields.
   * Enhancing the Interface Design, to give it a more Modern feel.


## Acknowledgments

* Professor Amanda Fernandez
* Fellow Classmate: Daniel Rodriguez
