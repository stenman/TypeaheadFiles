Typeahead Files - Incremental search for files on disk in selected directories

INSTALL (Windows)
NOTE: The daemon and the JRE has to be the same arcitechture (32- or 64-bit)
# Download and add commons-daemon to root dir (check naming in pom.xml and install.bat)
# Download and add Java JRE for windows to root dir (check naming in pom.xml and install.bat/uninstall.bat)
# Run maven install (check for eventual errors in ..\Windows\System32\LogFiles\Apache)
# Run install.bat (found in ..\target\installer directory)


TODO:
        [x] get app running as service in windows (and later linux and os/x)
        [ ] make the service "wake up" (do something) from a global command
        [ ] create a simple and lightweight swing(?) app with only one text box for searching (inc. search)
        [ ] open the text field from the global command
        [ ] under the text box, create a list (text area sort of?) that should contain the search results
        [ ] get incremental search working
        [ ] use a db or simply keep updated version in memory?
        [ ] look in configured directories recursively after files
        [ ] add options: file type(s) to search for
        [ ] add options: two columns (dev/stable) or three columns (name/dev bool/stable bool)


