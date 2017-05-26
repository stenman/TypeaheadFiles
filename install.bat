commons-daemon\prunsrv //IS//TypeaheadFiles^
--DisplayName="Typeahead Files"^
--Description="Quickly search for files"^
--Install="%cd%\commons-daemon\prunsrv.exe"^
--Jvm="%cd%\jre1.8.0_131\bin\client\jvm.dll"^
--StartMode=jvm^
--StopMode=jvm^
--Startup=auto^
--StartClass=se.perfektum.typeaheadfiles.ServiceLauncher^
--StopClass=se.perfektum.typeaheadfiles.ServiceLauncher^
--StartParams=start^
--StopParams=stop^
--StartMethod=windowsService^
--StopMethod=windowsService^
--Classpath="%cd%\typeahead-files.jar"^
--LogLevel=DEBUG^
--LogPath="%cd%\logs"^
--LogPrefix=procrun.log^
--StdOutput="%cd%\logs\stdout.log"^
--StdError="%cd%\logs\stderr.log"


commons-daemon\prunsrv //ES//TypeaheadFiles