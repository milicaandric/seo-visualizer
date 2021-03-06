# seo-visualizer
Program that implements and tests an abstract data structure from selected file and creates relevant GUI. Program helps users (ex: SEO specialists) visualize unused code bytes of website and provides better understanding as to which issues should take priority. Users can then clean up and update their website accordingly.

<h2>Motivation</h2> 
This is a program that helps users (ex: SEO specialists) visualize unused code bytes of a particular website. It can be difficult for SEO specialists to know what to prioritize when they are cleaning up or modifying webpages. This program uses data derived from Chrome dev tools, creates an elegant table and report with that data, and thus provides users with a better understanding as to which issues should take priority depending on their volume and frequency. Users can then clean up and update their websites accordingly. The overarching motivation for creating this program stems from the need to optimize a website. Website optimization can include making a page run faster, cleaning up irrelevant information/code, etc… and is ultimately important for improving website ratings and helping organizations grow!

<h2>Usage</h2>
(1) Run the GUI.java class and wait for the SEO Visualizer window to pop up. 
(2) Click on the "Open file" button in order to be redirected to the Open Dialog on your local machine. 
(3) Select a text file (file with the ".txt" extension, not ".doc" or ".docx") with relevant information that the program can analyze. I have included a text file "cfsChrome.txt". Chrome dev tools does not provide information ragarding unused code bytes for html files or python files so I fabricated a few urls to give the user an idea of how extensive the report could be with the proper information provided. 
(4) If you have uploaded an appropriate text file, the program should confirm which file you uploaded and ask you to click on the "Results" button. 
(5) Click on the "Results" button to access your analysis. 
(6) Explore the interface. Add data you may have forgotten to include in your original text document. Also, notice that when new data is added, the program prints the number of elements total to the console. 

<h2>Ideas</h2>
(1) I would like to implement some sort of webscraping program that retrieves the neccessary data for you. With this, the user would not have to check the Chrome dev tool and manually create the text file. 
(2) Providing some sort of graphic besides a table would be nice and help users better visualize their data. I would eventually like to transform my current table into an interactive pie chart. 
(3) Some of my formatting is a little off and I would have liked to use a JavaFX GridPane instead of a JavaFX BorderPane for my UI. I realized this a little too late and would have had to reformat my entire interface. 
(4) Adding some sort of removal capability to my program.
