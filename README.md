# Project Timetable

A Simple Event and Todo Management Tool, that helps you stay on your personal schedule.

## Description

Events can be entered in on any time table that the user wishes, and a static To-Do list is available for general time-insensitive projects. The app will remind the user a set time before the event, or should the user wish to prioritize the event, it will send alerts every 5 minutes after the requested remind time, up until the event time. The app sends reminders to the user about events coming up, and even notify the user when they load the program up and have missed events. The app is meant to be lightweight, but have pop ups and audio notifications.

## Getting Started

### Dependencies

* Java SE 9 and or higher.


### Downloading

* Navigate to the Timetable Repository: https://github.com/Anthrac1t3/Project-Timetable
* Click the "Code" Dropdown for cloning the code, then select your preferred method. (E.g Download Zip, or Copying the link, etc)
* You now have a copy of the program!


### Installing / Executing

* Once the program is downloaded, you can follow the below steps to get it started.
* Opening and running the program in an IDE (E.g Eclipse, Intellij)
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
   * Adding in compatibility with common calendar file types so that the user can import their Google calendar (or any) if they would like.


## Acknowledgments

* Professor: Amanda Fernandez
* Fellow Classmate: Daniel Rodriguez
