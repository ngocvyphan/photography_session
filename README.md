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
