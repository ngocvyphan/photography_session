# Project: Photography Session Management System  #

---
## Development Team ##

Business Client:  Sherri Ashton
<br/>
Lead Developer:  Vy Phan
<br/>
Quality Control:  Nguyen Nguyen
<br/>
<br/>
The project: Photography Session Management System belongs to Sherri.
<br/>

---
## Description ##

The Photography Session Management System is designed to help photographers easily manage their client bookings and session details. It lets photographers record important information about each session, such as the client's name, session type (e.g., portrait, wedding, or event), and the session date and time. Additionally, photographers can set their hourly rate and the number of hours for each session, with the system automatically calculating the total cost.
<br/>
<br/>
This system replaces traditional methods like handwritten bookings or basic spreadsheets with a more streamlined and user-friendly digital solution. Photographers will have a clear overview of all upcoming sessions and can organize their schedules more effectively, ensuring no double-bookings or scheduling conflicts. The ability to specify the type of session also helps photographers tailor their preparations to meet client expectations.
<br/>
<br/>
The system also automatically calculates the session's total cost by multiplying the hourly rate by the number of hours booked. This ensures clear and transparent pricing for both the photographer and the client. By simplifying the management of multiple sessions, this system enhances efficiency, reduces errors.

---
## Color ##

Main Color: #808080 (grey) </br>
Secondary Color: #000000 (black) </br>
Accent Color: #008081 (dark cyan) </br>

---
## Required Fields ##

This will be a list of fields and their datatype (class design format). There are expected to be a minimum of six fields.<br>
id int Unique id for each row / primary key <br/>
clientName String Person's name <br/>
packageNumber int The number of the package 1 (Basic), 2 (Standard), 3(Premium), 4(Event), 5(Custom) <br/>
date String Date that the session was booked <br/>
sessionNotes String Additional information </br>
hourlyRate double The hourly rate for each session is $150/hour </br>
numberOfHoursBooked int The number of hours booked for that session </br>
addedPhotoAlbum boolean if the client wants to add photo album or not (extra $50) </br>
addedVideo boolean if the client wants to add video or not (extra $500) </br>
addedExtraEditing boolean if the client wants to add extra editing or not (extra $100) </br>
addedExtraPrints boolean if the client wants to add extra prints (extra $3/each) </br>
numberOfExtraPrints int The number of extra prints the client wants to add </br>
cost Double Cost (see calculation) </br>

---
## Calculation ##
**Available Photography Packages:** </br>
1) Basic - 1-hour session with up to 10 edited photos: $150.00 </br>
2) Standard - 2-hour session with up to 25 edited photos: $300.00 </br>
3) Premium - 4-hour session with up to 50 edited photos: $600.00 </br>
4) Event - 8-hour session with unlimited photos and full retouching: $1200.00 </br>
5) Custom - numberOfHoursBooked * hourlyRate </br>
</br>
**ADD-ONS:**</br> 
Add photo album: Extra $50 </br>
Add extra prints: Extra $3/each </br>
Add video: Extra $500 </br>
Add extra editing: Extra $100 </br>
</br>
**Example 1:**
</br>
</br>
Please choose a package (enter the number):
</br>
</br>
2 
</br>
</br> 
You selected: Standard </br>
Total price: $300.0 </br>
</br> 
ADD - ONS 
</br>
</br> 
Would you like to add a photo album for $50? (yes/no) 
</br>
</br> 
yes 
</br>
</br> 
Extra prints? $3 each (yes/no) 
</br>
</br>
no
</br>
</br> 
Would you like Video $500? (yes/no) 
</br>
</br>
no
</br>
</br>
Extra Editing? $100? (yes/no)
</br>
</br> 
no 
</br>
</br> 
**Total price with add-ons: $350.00**
</br>
</br>
**Example 2:**
</br>
</br>
Please choose a package (enter the number):
</br>
</br> 
5 
</br>
</br>
How many hours you would like to book:
</br>
</br>
5
</br>
</br>  
You selected: Custom </br>
Total price: $750.0 </br>
</br> 
ADD - ONS
</br>
</br> 
Would you like to add a photo album for $50? (yes/no) 
</br>
</br> 
no 
</br>
</br> 
Extra prints? $3 each (yes/no) 
</br>
</br> 
yes
</br>
</br>
How many extra prints you would like to take:
</br>
</br>
5
</br>
</br> 
Would you like Video $500? (yes/no)
</br>
</br> 
no 
</br>
</br> 
Extra Editing? $100? (yes/no)
</br>
</br> 
no 
</br>
</br> 
**Total price with add-ons: $765.00**
</br>
</br>

---
## Report Details ##
Report 1: Allow users to select the date of booking the photography session and display the photography session booking of that booking date
</br>
Report 2: Allow users to select a lower limit cost and upper limit cost and display any photography session in that cost range

---
## Sprint 1 ##

- Ensure the project is public
- Can add team members to the project
- Send a link to your repo to the instructor, BA, and PM
- Ensure the project has issue tracking
--> Jira issues needs to be used this year.

## Sprint 2 ##

This sprint will deal with completing the report requirement of the project and involves working with JDBC in your projects. In your project team, there will be some collaboration needed to have the report requirements specified and to test the report. The report requirements are to be specified in the Bitbucket readme file. The coding is to be completed individually. The class example project will provide an example of each of the requirements for this sprint. Note that each team member will have their respective issues to complete separately from the other teammates' issues. JDBC The reports are to be implemented using DAO classes with JDBC (rather than Spring Data JPA). The reports must allow the user to enter the criteria for the report on an input form and then be taken to a report results view.
File I/O In addition to displaying the report results to the screen, the web application should save the report to a file. The file should be saved in "c:\cis2232\" folder and be named based on the type of report and the current date. An example of a filename could be "TicketOrdersForCustomer202105111537.txt".

## Sprint 3 ##

- List functionality is implemented.
- Add functionality is implemented.
- Delete functionality is implemented.
- Update functionality is implemented.
- Validation is implemented for add and update functionality (using Spring Data JPA)

## Sprint 4 ##

This sprint will require implementing a basic REST API for your project.
- Jersey setup in the projects.
- Service to get all.
- Service to get one.
- Service to delete.
- Service to add (post).
- Return an appropriate http response code if the post service includes invalid data values.

## Sprint 5 ##

The project was completed in small sprints. This final sprint will be used to ensure that all the pieces are working. Finishing touches. Ensure that the main business Controller files are coded to meet CIS programming standards (including Javadocs, naming, and formatting). A demonstration in class or by narrated screen record video is expected by the end of the semester.