# Double-Double
Term Project for CPSC101
@authors Sam Kelly, Rui Song, Erik Searle, Scott 

New Classes: 
-Course Component
-ID
-Meeting
-Blocks
-Professor
-Location
-MasterSchedule
-Course Combo

Course Component:
-Subtype
  -Lab/Lec/Tut
-Meetings

Descrip: A section for a course (a lecture section, lab section, tutorial section), i.e. A course object will contain
multiple course components

Meeting:
-Professor
-Room
-Meeting Time
-Blocks

Descrip: Describes the time and place where a group will be meeting for a course section, i.e. a course component may have multiple
meetings

Blocks:
-StartTime
-DayOfWeek
-30 mins long
-Can be InConflict

Professor:
-Name

Room:
-room number

MeetingTime:
-StartTime
-EndTime
-Duration
-DayOfWeek

MasterSchedule:
-Holds all Courses
-reads csv file and turns info into courses

Course Combo:
-can be class
-or can be info on text file read by drop down menus


Implementation of creating course object:
-MasterSchedule checks and creates block of lines for one course name and passes to Course
object constructor
-Course constructor creates course components
-course components create meetings
-meetings create blocks

Division of Labour:
Erik: MasterSchedule
Sam: Course
Ray: Meeting, MeetingTime, Block
Scott: CourseComponent, Professor, Location
