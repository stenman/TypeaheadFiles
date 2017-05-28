:: USE THIS TO INSTALL FOR WIN 64-BIT (don't forget to add a space followd by a carat in the end of each statement!)
:: commons-daemon\amd64\prunsrv //IS//TypeaheadFiles
:: --Install="%cd%\commons-daemon\amd64\prunsrv.exe"
commons-daemon\prunsrv //IS//TypeaheadFiles ^
--Install="%cd%\commons-daemon\prunsrv.exe" ^
--Jvm="%cd%\jre1.8.0_131\bin\server\jvm.dll" ^
--DisplayName="Typeahead Files" ^
--Description="Quickly search for files" ^
--StartMode=jvm ^
--StopMode=jvm ^
--Startup=auto ^
--StartClass=se.perfektum.typeaheadfiles.ServiceLauncher ^
--StopClass=se.perfektum.typeaheadfiles.ServiceLauncher ^
--StartParams=start ^
--StopParams=stop ^
--StartMethod=windowsService ^
--StopMethod=windowsService ^
--Classpath="%cd%\typeahead-files.jar" ^
--LogLevel=DEBUG ^
--LogPath="%cd%\logs" ^
--LogPrefix=procrun.log ^
--StdOutput="%cd%\logs\stdout.log" ^
--StdError="%cd%\logs\stderrr.log"

:: USE THIS TO INSTALL FOR WIN 64-BIT
:: commons-daemon\amd64\prunsrv //ES//TypeaheadFiles
commons-daemon\prunsrv //ES//TypeaheadFiles